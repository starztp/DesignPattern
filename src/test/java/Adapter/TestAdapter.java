package Adapter;

import com.tianyou.designpattern.Adapter.LoginExample.SignService;
import com.tianyou.designpattern.Adapter.LoginExample.V1.SignforThirdParty;
import com.tianyou.designpattern.Adapter.LoginExample.V2.LoginForThirdPartyAdapter;
import com.tianyou.designpattern.Adapter.OrderExample.NewOrder;
import com.tianyou.designpattern.Adapter.OrderExample.NewOrderAdapter;
import org.junit.Test;

public class TestAdapter {

    /**
     * 新老订单转换
     */
    @Test
    public void TestOrderExample(){
        NewOrder newOrder=new NewOrderAdapter();
        newOrder.generateNewOrderNumber();
    }

    @Test
    public void TestThridPartyLoginV1(){
        SignService service=new SignforThirdParty();
        ((SignforThirdParty) service).LoginforQQ("602951772");
    }

    @Test
    public void TestThirdPartyLoginV2(){
        LoginForThirdPartyAdapter adapter=new LoginForThirdPartyAdapter();
        adapter.QQLogin("602951772");
        adapter.WechatLoagin("tianyouandstarztp");
    }
}
