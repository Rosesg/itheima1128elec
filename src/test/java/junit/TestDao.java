package junit;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDao {
    
    @Test
    public void saveTest() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans.xml");
        // 简单了，直接找这个接口就可以了，面向接口
        IElecTestDao bean = (IElecTestDao) ac.getBean(IElecTestDao.SERVICE_NAME);
        
        ElecTest elecTest = new ElecTest();
        elecTest.setTestName("测试Dao名称");
        elecTest.setTestDate(new Date());
        elecTest.setTestRemark("测试Dao备注");
        bean.save(elecTest);
        
        ac.close();
    }
}
