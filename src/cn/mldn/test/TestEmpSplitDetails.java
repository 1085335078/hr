package cn.mldn.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.Emp;

public class TestEmpSplitDetails {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			Map<String, Object> map = ServiceFactory.getIEmpServieInstance().listDetails(1, 5, "ename", "");
			int count = (Integer) map.get("empCount");
			System.out.println("Êý¾ÝÁ¿£º" + count);
			List<Emp> all = (List<Emp>) map.get("allEmps");
			Iterator<Emp> iter = all.iterator();
			while (iter.hasNext()) {
				Emp vo = iter.next();
				System.out.println(vo.getEname() + "£¬" + vo.getJob() + "£¬" + vo.getMgr().getEname() + "£¬" + vo.getDept().getDname());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
