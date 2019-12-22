package Proxy.JdkProxy.OrderExample;

import com.tianyou.designpattern.Proxy.dynamicproxy.JDKproxy.OrderExample.*;
import org.junit.Test;

public class OrderExampleTest {

        @Test
        public void TestOrderServiceStaticProxy(){
            IOrderService orderService=new OrderService();
            Order order=new Order();
            OrderServiceStaticProxy orderServiceStaticProxy=new OrderServiceStaticProxy(orderService);
            orderServiceStaticProxy.createOrder(order);
        }

        @Test
        public void  TestOrderServiceDynamicProxy(){
            Order order=new Order();
            Order[] orders=new Order[]{order};
            OrderServiceDynamicProxy proxy=new OrderServiceDynamicProxy();
            IOrderService orderService=(IOrderService)proxy.getInstance(new OrderService());
            orderService.createOrder(order);

        }
}
