package test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.zhku.jsjs.haofeng.dao.SearchHibernateDao;
import cn.zhku.jsjs.haofeng.domain.MyTable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProjectTest {
	@Resource(name="sessionFactory")
	private SessionFactory sf;
	
	@Test
	public void test(){
		Configuration conf = new Configuration().configure();
		SessionFactory SessionFactory = conf.buildSessionFactory();
		Session session = SessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		MyTable t1 = session.get(MyTable.class, 01);
		t1.setT_name("la la la ");
		session.save(t1);
		transaction.commit();
		session.close();
		SessionFactory.close();
	}
	
	@Test
	public void test2(){
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		MyTable t1 = session.get(MyTable.class, 01);
		t1.setT_name("la la la ");
		session.save(t1);
		transaction.commit();
		session.close();
	}
	
	@Resource(name="searchHibernateDao")
	private SearchHibernateDao sd;
	
	@Test
	public void test3(){
		List<String> searchHname = sd.searchHname("h");
		System.out.println(searchHname);
	}
}
