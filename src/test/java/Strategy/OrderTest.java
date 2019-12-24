package Strategy;


import com.tianyou.designpattern.Strategy.OrderExample.Order;
import org.junit.Test;

public class OrderTest {

    @Test
    public void TestOrder(){
        Order order=new Order(1,1,300);
        order.pay("Alipay");
    }
}
