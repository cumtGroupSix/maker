package cn.cumtmaker.maker.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnLineCount implements HttpSessionListener {
    private Logger logger= LoggerFactory.getLogger(getClass());
    //记录session的数量
    public int count=0;
    //监听session的创建,synchronized 防并发bug
    public synchronized void sessionCreated(HttpSessionEvent arg) {
        count++;
        logger.info("【在线人数增加,人数:"+count+"】");
        arg.getSession().getServletContext().setAttribute("count", count);

    }
    //监听session的销毁
    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent arg) {
        count--;
        logger.info("【在线人数减少,人数:"+count+"】");
        arg.getSession().getServletContext().setAttribute("count", count);
    }
}