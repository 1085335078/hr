package cn.mldn.dao;

import java.util.List;

import cn.mldn.vo.Emp;
/**
 * 定义emp表的数据层的操作标准
 * @author mldn
 */
public interface IEmpDAO extends IDAO<Integer,Emp> {
	/**
	 * 查询雇员的详细信息，包括雇员对应的领导信息以及所在的部门信息
	 * @param id 要查询的雇员编号
	 * @return 所有的数据以VO对象返回，如果没有则返回null
	 * @throws Exception SQL查询错误
	 */
	public Emp findByIdDetails(Integer id) throws Exception ;
	/**
	 * 查询雇员的完整信息
	 * @return 所有的数据对象以List集合返回，如果没有数据集合长度为0（size() == 0）
	 * @throws Exception SQL查询错误
	 */
	public List<Emp> findAllDetails() throws Exception ;
	/**
	 * 分页查询雇员的完整信息
	 * @param currentPage 当前所在的页
	 * @param lineSize 每有莪显示数据行数
	 * @param column 要进行模糊查询的数据列
	 * @param keyWord 模糊查询的关键字
	 * @return 如果表中有数据，则所有的数据会封装为VO对象而后利用List集合返回，<br>
	 * 如果没有数据，那么集合的长度为0（size() == 0，不是null）
	 * @throws Exception SQL执行异常
	 */
	public List<Emp> findAllSplitDetails(Integer currentPage,Integer lineSize,String column,String keyWord) throws Exception ;
}
