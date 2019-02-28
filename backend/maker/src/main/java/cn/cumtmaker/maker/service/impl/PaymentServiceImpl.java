package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.VO.OrderDetailProductVO;
import cn.cumtmaker.maker.mapper.OrderMasterMapper;
import cn.cumtmaker.maker.mapper.ProductMapper;
import cn.cumtmaker.maker.service.PaymentService;
import cn.cumtmaker.maker.service.ProductService;
import cn.cumtmaker.maker.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    OrderMasterMapper orderMasterMapper;

    @Autowired
    UserService userService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductMapper productMapper;

    private Logger logger= LoggerFactory.getLogger(getClass());

    private int[] soldSum  = new int[100];
    //更新支付状态并向用户发送邮件
    @Override
    public int updatePayStatus(HttpServletRequest request,Integer orderId, Integer payStatus)
    {
        int userId= userService.getUserByRequest(request).getUserId();
        int code=orderMasterMapper.updatePayStatus(userId,orderId,payStatus);
        if(code==1){
            logger.info("UserID为"+userId+"的用户支付订单成功");
            //支付成功后，发送订单支付成功邮件
            String sender="cumtgroupsix@163.com";   //发送人的邮箱
            String username=userService.getUserByRequest(request).getUsername();
            String title="大学生创客联盟";    //标题
            String text="您已成功支付在大学生创客联盟网站上购买的商品，商品处于发货状态，请耐心等待。"; //内容文本
            userService.sendEmail(sender,username,title,text);
            //支付成功后，统计库存与销售
            List<OrderDetailProductVO> orderDetailProductVOS=orderDetailService.getProduct(orderId);
            for(int i=0;i<orderDetailProductVOS.size();i++){
                int productId=orderDetailProductVOS.get(i).getProductId();
                int boughtQuantity=orderDetailProductVOS.get(i).getProductQuantity();
                int stock=productMapper.selectByProductId(productId).getProductStock();
                int newStock=stock-boughtQuantity;
                logger.info("ProductID为"+productId+"的商品此次售出"+boughtQuantity+"件");
                soldSum[productId]=soldSum[productId]+boughtQuantity;
                logger.info("ProductID为"+productId+"的商品总售出"+soldSum[productId]+"件");
                logger.info("ProductID为"+productId+"的商品实时库存为"+newStock+"件");
                productService.updateStock(productId,newStock);
            }
        }
        return code;
    }
}
