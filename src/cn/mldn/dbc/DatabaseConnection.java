package cn.mldn.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 本类的主要功能是负责数据库的连接与关闭的
 * @author MLDN	
 */
public class DatabaseConnection {
	private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver" ;
	private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:mldn" ;
	private static final String DBUSER = "c##scott" ;
	private static final String PASSWORD = "tiger" ;
	private Connection conn = null ;	// 保存连接对象
	/**
	 * 构造方法的主要目的是进行数据库连接，只要在程序之中实例化了DatabaseConnection对象
	 * 那么就表示要进行数据库的连接操作了，所以在构造方法之中连接数据库
	 * 在本构造方法之中，如果出现了异常，将直接输出异常信息，因为如果数据库连接都没有了，根本就无法操作
	 */
	public DatabaseConnection() {
		try {
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 取得一个数据库连接对象，这个对象在构造方法中取得
	 * @return Connection接口对象
	 */
	public Connection getConnection() {
		return this.conn ;
	}
	/**
	 * 关闭连接，不管是否连接上，执行此操作都不会出错
	 */
	public void close() {
		if (this.conn != null) {	// 取得了连接
			try {	// 关闭连接
				this.conn.close() ;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

