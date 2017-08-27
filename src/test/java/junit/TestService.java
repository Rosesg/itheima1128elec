package junit;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by 11602 on 2017/8/27.
 */
public class TestService {
    @Test
    public void saveTest() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans.xml");
        // 简单了，直接找这个接口就可以了，面向接口
        IElecTestService bean = (IElecTestService) ac.getBean(IElecTestService.SERVICE_NAME);

        ElecTest elecTest = new ElecTest();
        elecTest.setTestName("测试service名称");
        elecTest.setTestDate(new Date());
        elecTest.setTestRemark("测试service备注");
        bean.saveElecTest(elecTest);

        ac.close();
    }
}
