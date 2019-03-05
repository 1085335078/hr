package cn.mldn.test.junit;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.Dept;
import junit.framework.TestCase;

public class IDeptServiceTest {

	@Test
	public void testInsert() {
		Dept vo = new Dept();
		vo.setDeptno(12);
		vo.setDname("罚站");
		vo.setLoc("北京");
		try {
			TestCase.assertTrue(ServiceFactory.getIDeptServiceInstance().insert(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		Dept vo = new Dept();
		vo.setDeptno(11);
		vo.setDname("裸跑");
		vo.setLoc("北京");
		try {
			TestCase.assertTrue(ServiceFactory.getIDeptServiceInstance().update(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		Set<Integer> ids = new HashSet<Integer>();
		ids.add(12);
		try {
			TestCase.assertTrue(ServiceFactory.getIDeptServiceInstance().delete(ids));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testList() {
		try {
			List<Dept> all = ServiceFactory.getIDeptServiceInstance().list() ;
			System.out.println(all);
			TestCase.assertTrue(all.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGet() {
		try {
			TestCase.assertNotNull(ServiceFactory.getIDeptServiceInstance().get(10));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
