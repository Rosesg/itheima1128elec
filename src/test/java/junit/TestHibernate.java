package junit;
import com.yuantek.elec.domain.ElecTest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Date;

public class TestHibernate {
    //测试保存
    @Test
    public void saveTest() {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //hibernate 迷人的地方就在此，操作对象的过程就是在操作数据库表
        ElecTest elecTest = new ElecTest();
        elecTest.setTestName("测试Hibernate名称");
        elecTest.setTestDate(new Date());
        elecTest.setTestRemark("测试Hibernate名备注");
        session.save(elecTest);

        transaction.commit();
        session.close();
    }
}
