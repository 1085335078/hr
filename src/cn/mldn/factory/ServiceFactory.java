package cn.mldn.factory;

import cn.mldn.service.IDeptService;
import cn.mldn.service.IEmpService;
import cn.mldn.service.impl.DeptServiceImpl;
import cn.mldn.service.impl.EmpServiceImpl;

public class ServiceFactory {
	public static IEmpService getIEmpServieInstance() {
		return new EmpServiceImpl() ;
	}
	public static IDeptService getIDeptServiceInstance() {
		return new DeptServiceImpl() ;
	}
}
