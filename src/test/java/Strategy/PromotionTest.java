package Strategy;

import com.tianyou.designpattern.Strategy.PromotionExample.Activity;
import com.tianyou.designpattern.Strategy.PromotionExample.Promotion;
import com.tianyou.designpattern.Strategy.PromotionExample.PromotionFactory;
import org.junit.Test;

public class PromotionTest {

    @Test
    public void TestPromotion(){
        Promotion promotion=PromotionFactory.getPromotion("FriendsDeal");
        Activity activity=new Activity(promotion);
        activity.excuteActivity();
    }
}
