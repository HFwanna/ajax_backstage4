package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.zhku.jsjs.haofeng.domain.MyTable;

public class ProjectTest {
	@Test
	public void test(){
		Configuration conf = new Configuration().configure();
		SessionFactory SessionFactory = conf.buildSessionFactory();
		Session session = SessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		MyTable t1 = session.get(MyTable.class, 01);
		t1.setT_name("you not 1");
		session.save(t1);
		transaction.commit();
		session.close();
		SessionFactory.close();
	}
}
