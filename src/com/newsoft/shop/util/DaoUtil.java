package com.newsoft.shop.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newsoft.shop.constant.SysProperties;

/**
 * 数据库操作工具
 * @author lmy
 *
 */
public class DaoUtil {
	private Connection conn = null;
	private PreparedStatement ps = null;

	/**
	 * 获取数据库连接，却省为开启
	 */
	public void openCon() {
		this.openCon(true);
	}

	/**
	 * 获取数据库连接，并指定是否开启自动提交，却省为开启
	 * @param autoCommit
	 */
	public void openCon(boolean autoCommit) {
		// 加载驱动
		try {  
			Class.forName(SysProperties.JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("未能成功加载驱动程序，请检查是否导入驱动程序！");
			e.printStackTrace();
		}

		// 获取连接
		try {
			conn = DriverManager.getConnection(SysProperties.JDBC_URL, SysProperties.JDBC_USERNAME, SysProperties.JDBC_PASSWORD);
		} catch (SQLException e) {
			System.out.println("获取数据库连接失败！");
			e.printStackTrace();
		}

		// 开启事务
		try {
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			System.out.println("开启事务失败！");
			e.printStackTrace();
		}
	}
	
	/**
	 * 数据库读操作
	 * @param sql
	 * @param param
	 * @param c
	 * @return
	 */
	public <T> List<T> query(String sql, List<String> param, Class<T> c) {
		this.prepare(sql, param);
		
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("执行数据库读操作失败！");
			e.printStackTrace();
		}
		
		return this.paseResultSet(rs, c);
	}

	/**
	 * 数据库写操作
	 * @param sql
	 * @param param
	 * @return
	 */
	public int modify(String sql, List<String> param) {
		this.prepare(sql, param);
		
		int i = 0;
		try {
			i = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("执行数据库写操作失败！");
			e.printStackTrace();
		}
		
		return i;
	}
	
	/**
	 * 提交事务
	 */
	public void commit() {
		try {
			conn.commit();
		} catch (SQLException e) {
			System.out.println("提交失败！");
			e.printStackTrace();
		}
	}

	/**
	 * 回滚事务
	 */
	public void rollback() {
		try {
			conn.rollback();
		} catch (SQLException e) {
			System.out.println("回滚失败！");
			e.printStackTrace();
		}
	}

	/**
	 * 关闭数据库连接
	 */
	public void close() {
		if (conn != null) {
			try {  
				conn.close();  
			} catch (SQLException e) {  
				e.printStackTrace();  
				conn = null;  
			}
		}
		if (ps != null) {
			try {  
				ps.close();  
			} catch (SQLException e) {  
				e.printStackTrace();  
				ps = null;  
			}
		}
	}
	
	private void prepare(String sql, List<String> param) {
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e1) {
			System.out.println("预编译SQL失败！");
			e1.printStackTrace();
		}
		
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				try {
					ps.setString(i + 1,param.get(i));
				} catch (SQLException e) {
					System.out.println("设置SQL参数失败！");
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 解析结果集，并封装成对象，后放入list
	 * @param rs
	 * @param c
	 * @return
	 */
	private <T> List<T> paseResultSet(ResultSet rs, Class<T> c) {
		List<T> list = new ArrayList<>();
		T ins = null;
		try {
			while(rs.next()){
				ins = c.newInstance();
				Field[] f = c.getDeclaredFields();
				for (int i = 0; i < f.length; i++) {
					f[i].setAccessible(true); //解除封装
			      f[i].set(ins, rs.getObject(f[i].getName()));
				}
				list.add(ins);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
