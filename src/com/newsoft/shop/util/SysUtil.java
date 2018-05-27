package com.newsoft.shop.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.newsoft.shop.constant.SysProperties;
import com.newsoft.shop.entity.User;

public class SysUtil {
	/**
	 * 指定前缀获取编号
	 * @param key
	 * @return
	 */
	public static String getUUID(String key) {
		return key + System.currentTimeMillis();
	}
	
	/**
	 * 首字母大写
	 * @param s
	 * @return
	 */
	public static String upperHead(String s) {
		if (s == null || "".equals(s)) {
			return null;
		}
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}
	
	/**
	 * 对象转成list
	 * @param t
	 * @return
	 */
	public static <T> List<String> obj2List(T t) {
		if (t == null) {
			return null;
		}
		List<String> list = new ArrayList<>();
		Class<?> cls = t.getClass();
		Field[] f = cls.getDeclaredFields();
		for (int i = 0; i < f.length; i++) {
			f[i].setAccessible(true); //解除封装
			try {
				list.add(f[i].get(t).toString());
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		User user = new User();
		user.setId(getUUID(SysProperties.USER_PREFIX));
		user.setName("Tom");
		user.setPassword("123456");
		user.setSex("1");
		user.setPhone("12345678977");
		user.setAddress("jfshdfklaseurfuseio");
		List<String> list = obj2List(user);
		System.out.println(list.toString());
	}
}
