package cn.mldn.test.juni;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.Emp;
import junit.framework.TestCase;

public class IEmpServiceTest {
	private static int empno;
	static {
		empno = new  Random().nextInt(1000) ; // 动态生成一个empno的 数据
	}
	@Test
	public void testInsert() {
		Emp vo = new Emp() ;
		vo.setEmpno(empno) ;
		vo.setEname("啊-");
		vo.setJob("职位-");
		vo.setHiredate(new Date());
		vo.setSal(10.23);
		vo.setComm(3.3);
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServieInstance().insert(vo)) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		Emp vo = new Emp() ;
		vo.setEmpno(8889) ;
		vo.setEname("啊本-" + empno);
		vo.setJob("人体");
		vo.setHiredate(new Date());
		vo.setSal(10.0);
		vo.setComm(0.5);
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServieInstance().update(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		Set<Integer> ids = new HashSet<Integer>() ;
		ids.add(8889) ;
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServieInstance().delete(ids));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGet() {
		try {
			TestCase.assertNotNull(ServiceFactory.getIEmpServieInstance().get(7369));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testList() {
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServieInstance().list().size()>0) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testListIntIntStringString() {
		try {
			Map<String, Object> map = ServiceFactory.getIEmpServieInstance().list(2, 5, "ename", "");
			int count = (Integer) map.get("empCount");
			List<Emp> all = (List<Emp>) map.get("allEmps");
			TestCase.assertTrue(count > 0 && all.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
