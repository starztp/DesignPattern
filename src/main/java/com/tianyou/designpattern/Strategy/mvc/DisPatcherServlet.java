package com.tianyou.designpattern.Strategy.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianyou on 2019/12/26.
 */
public class DisPatcherServlet extends HttpServlet {

    private List<Handler> handlers=new ArrayList<Handler>();

    /**
     * 初始化handlers
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        try {
            Handler handler=new Handler();
            handler.setClazz(OrderController.class);
            handler.setUrl("getOrderId");
            handler.setMethod(OrderController.class.getMethod("getOrderId"));
            handlers.add(handler);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void doDispatch(HttpServletRequest req){
        String url=req.getRequestURI();
        for(Handler handler:handlers){
            if(url.equals(handler.getUrl())){
                try {
                    Object obj=handler.getMethod().invoke(handler.getClazz());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
