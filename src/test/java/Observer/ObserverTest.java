package Observer;

import com.tianyou.designpattern.Observer.GPer.Gper;
import com.tianyou.designpattern.Observer.GPer.Question;
import com.tianyou.designpattern.Observer.GPer.Teacher;
import org.junit.Test;

public class ObserverTest {

    @Test
    public void  TestGPer(){
        Question question=new Question();
        question.setUsername("天由");
        question.setContext("如何成为代码之神");
        Gper gper=new Gper();
        Teacher teacher=new Teacher("Tom");
        gper.addObserver(teacher);//添加要通知的观察者
        teacher.update(gper,question);
    }
}
