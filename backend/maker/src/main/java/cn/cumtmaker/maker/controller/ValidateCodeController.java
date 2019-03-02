package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.security.validate.ImageCode;
import cn.cumtmaker.maker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 生成验证码Control
 */
@RestController
public class ValidateCodeController {

    @Autowired
    UserService userService;

    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";
    private SessionStrategy sessionStrategy=new HttpSessionSessionStrategy();

    /**
     * 图片验证码API
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("api/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode =createImageCode(request);
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
    }

    /**
     * 找回密码发送短信API
     * @param request
     * @param username
     * @return
     */
    @GetMapping("api/code/email")
    public int sendEmail(HttpServletRequest request,String username) {
        String sender="cumtgroupsix@163.com";   //发送人的邮箱
        ImageCode imageCode =createImageCode(request);
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
        String code=imageCode.getCode();
        String title="大学生创客联盟";    //标题
        String text="此邮箱所绑定的大学生创客联盟正在尝试找回密码，验证码:  "+code+"\n有效时间2分钟，如非本人操作，请勿泄露。"; //内容文本
        int result=userService.sendEmail(sender,username,title,text);
        return result;
    }



    /**
     * 生成验证码及对应图片
     * @param request
     * @return ImageCode
     */
    private ImageCode createImageCode(HttpServletRequest request) {
        int width = 96;
        int height = 30;
        int length=4;
        int expireIn=120;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        Random random = new Random();

        // 生成画布
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 25));
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }

        // 生成数字验证码
        StringBuilder sRand = new StringBuilder();
        for (int i = 0; i < length; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand.append(rand);
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 18 * i + 6, 22);
        }

        g.dispose();

        return new ImageCode(image, sRand.toString(), expireIn);
    }

    /**
     * 生成随机背景条纹
     * @param fc
     * @param bc
     * @return
     */
    private Color getRandColor(int fc, int bc) {
        int MAX_COLOR_VALUE=255;
        Random random = new Random();
        if (fc > MAX_COLOR_VALUE) {
            fc = MAX_COLOR_VALUE;
        }
        if (bc > MAX_COLOR_VALUE) {
            bc = MAX_COLOR_VALUE;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
    }



