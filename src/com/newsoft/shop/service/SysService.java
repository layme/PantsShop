package com.newsoft.shop.service;

import java.util.List;
import java.util.ArrayList;

import com.newsoft.shop.constant.SqlStore;
import com.newsoft.shop.constant.SysProperties;
import com.newsoft.shop.entity.ResultInfo;
import com.newsoft.shop.entity.User;
import com.newsoft.shop.util.DaoUtil;
import com.newsoft.shop.util.SysUtil;

/**
 * 系统服务
 * @author lmy
 *
 */
public class SysService {
	/**
	 * 登陆服务
	 * @param user
	 * @return
	 */
	public ResultInfo<User> login(User user) {
		ResultInfo<User> ri = new ResultInfo<>();
		DaoUtil dao = new DaoUtil();
		dao.openCon();
		List<String> param = new ArrayList<>();
		param.add(user.getPhone());
		List<User> ul = dao.query(SqlStore.FIND_ONE_USER_BY_PHONE, param, User.class);
		if (ul != null && ul.size() > 0) {
			if (ul.get(0).getPassword().equals(user.getPassword())) {
				ri.setCode(0);
				ri.setData(ul.get(0));
			} else {
				ri.setCode(1);
				ri.setMsg(SysProperties.PASSWORD_WRONG);
			}
		} else {
			ri.setCode(1);
			ri.setMsg(SysProperties.USER_NOT_EXISTS);
		}
		dao.close();
		return ri;
	}
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public ResultInfo<User> registory(User user) {
		ResultInfo<User> ri = new ResultInfo<>();
		DaoUtil dao = new DaoUtil();
		dao.openCon();
		
		int i = dao.modify(SqlStore.ADD_ONE_USER, SysUtil.obj2List(user));
		if (i < 1) {
			ri.setCode(1);
			ri.setMsg(SysProperties.USER_SAVE_ERROR);
		} else {
			ri.setCode(0);
			ri.setData(user);
		}
		return ri;
	}
	
	public static void main(String[] args) {
		SysService s = new SysService();
		User user = new User();
		user.setId(SysUtil.getUUID(SysProperties.USER_PREFIX));
		user.setName("Tom");
		user.setPassword("123456");
		user.setSex("1");
		user.setPhone("12345678977");
		user.setAddress("jfshdfklaseurfuseio");
		ResultInfo<User> ri = s.registory(user);
		System.out.println(ri);
	}
}
