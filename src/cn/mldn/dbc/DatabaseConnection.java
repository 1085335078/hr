package cn.mldn.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * �������Ҫ�����Ǹ������ݿ��������رյ�
 * @author MLDN	
 */
public class DatabaseConnection {
	private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver" ;
	private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:mldn" ;
	private static final String DBUSER = "c##scott" ;
	private static final String PASSWORD = "tiger" ;
	private Connection conn = null ;	// �������Ӷ���
	/**
	 * ���췽������ҪĿ���ǽ������ݿ����ӣ�ֻҪ�ڳ���֮��ʵ������DatabaseConnection����
	 * ��ô�ͱ�ʾҪ�������ݿ�����Ӳ����ˣ������ڹ��췽��֮���������ݿ�
	 * �ڱ����췽��֮�У�����������쳣����ֱ������쳣��Ϣ����Ϊ������ݿ����Ӷ�û���ˣ��������޷�����
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
	 * ȡ��һ�����ݿ����Ӷ�����������ڹ��췽����ȡ��
	 * @return Connection�ӿڶ���
	 */
	public Connection getConnection() {
		return this.conn ;
	}
	/**
	 * �ر����ӣ������Ƿ������ϣ�ִ�д˲������������
	 */
	public void close() {
		if (this.conn != null) {	// ȡ��������
			try {	// �ر�����
				this.conn.close() ;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

