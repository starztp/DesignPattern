package Proxy.JdkProxy.dynamicproxy;

import com.tianyou.designpattern.Proxy.Person;
import com.tianyou.designpattern.Proxy.dynamicproxy.JDKproxy.proxy5173;
import com.tianyou.designpattern.Proxy.Me;
import org.junit.Test;

public class DynamicProxyTest{

    /**
     * CGLib 和 JDK 动态代理对比
     * 1.JDK 动态代理是实现了被代理对象的接口，CGLib 是继承了被代理对象
     * 2.JDK 和 CGLib 都是在运行期生成字节码，JDK 是直接写 Class 字节码，CGLib 使用 ASM 框架写 Class 字节码，Cglib 代理实现更复杂，生成代理类比 JDK 效率低
     * 3.JDK 调用代理方法，是通过反射机制调用，CGLib 是通过 FastClass 机制直接调用方法， CGLib 执行效率更高。
     */
    @Test
    public void TestDynamicProxy(){
        proxy5173 proxy=new proxy5173();
        Person person=(Person)proxy.getInstance(new Me());
        person.BuyGold();
    }
}
