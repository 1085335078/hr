package cn.mldn.test;

import java.util.Date;

import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.Emp;

public class TestEmpInsert {

	public static void main(String[] args) {
		Emp vo = new Emp() ;
		vo.setEmpno(8889);
		vo.setEname("³Â¹ÚÏ£") ;
		vo.setJob("ÉãÓ°Ê¦");
		vo.setHiredate(new Date()) ;
		vo.setSal(10.0) ;
		vo.setComm(0.5);
		try {
			System.out.println(ServiceFactory.getIEmpServieInstance().insert(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
