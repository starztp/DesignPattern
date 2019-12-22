package Delegate;

import com.tianyou.designpattern.Delegate.simple.DeveloperLeader;
import com.tianyou.designpattern.Delegate.simple.ProductManager;
import org.junit.Test;

public class SimpleTest {

    @Test
    public void TestSimple(){
        ProductManager manager=new ProductManager();
        manager.command("Java",new DeveloperLeader());
    }
}
