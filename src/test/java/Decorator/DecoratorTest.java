package Decorator;

import com.tianyou.designpattern.Decorator.Cake.BaseCake;
import com.tianyou.designpattern.Decorator.Cake.Cake;
import com.tianyou.designpattern.Decorator.Cake.ChocolateCakeDecorator;
import com.tianyou.designpattern.Decorator.Cake.FruitCakeDecorator;
import com.tianyou.designpattern.Decorator.Login.v1.BaseThirdPartySign;
import com.tianyou.designpattern.Decorator.Login.v1.ThirdPartySign;
import com.tianyou.designpattern.Decorator.Login.v1.WechatSignDecorator;
import org.junit.Test;

public class DecoratorTest {

    @Test
    public void TestCake(){
        Cake cake=new BaseCake();
        cake=new ChocolateCakeDecorator(cake);
        cake=new ChocolateCakeDecorator(cake);
        cake=new FruitCakeDecorator(cake);
        System.out.println(cake.getMessage());
        System.out.println(cake.getPrice());
    }


    @Test
    public void TestLoginV1(){
        ThirdPartySign sign=new BaseThirdPartySign();
        sign= new WechatSignDecorator(sign);
        System.out.println(sign.login("aass"));
    }
}
