
import com.xq.demo.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import com.xq.demo.StuInfo;
import com.alibaba.fastjson.*;

@Slf4j
public class ObjTest {

    @Test
    public void testObj(){
        StuInfo stuInfo=new StuInfo();
        stuInfo.setAge(28);
        stuInfo.setName("tom");


        Person<StuInfo> p=new Person();
        p.setStu(stuInfo);
        p.setName("No.1");

        JSON.toJSONString(p);

        log.info(JSON.toJSONString(p));

    }
}
