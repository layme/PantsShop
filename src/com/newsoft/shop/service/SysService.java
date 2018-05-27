package com.newsoft.shop.service;

import java.util.ArrayList;
import java.util.List;

import com.newsoft.shop.constant.SqlStore;
import com.newsoft.shop.constant.SysProperties;
import com.newsoft.shop.entity.Order;
import com.newsoft.shop.entity.PantsStock;
import com.newsoft.shop.entity.ResultInfo;
import com.newsoft.shop.entity.ShoppingCar;
import com.newsoft.shop.entity.User;
import com.newsoft.shop.exception.SysException;
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
		DaoUtil dao = null;
		try {
			dao = new DaoUtil();
			dao.openCon();

			int i = dao.modify(SqlStore.ADD_ONE_USER, SysUtil.obj2List(user));
			if (i < 1) {
				ri.setCode(1);
				ri.setMsg(SysProperties.USER_SAVE_ERROR);
			} else {
				ri.setCode(0);
				ri.setData(user);
			}
		} catch (SysException e) {
			ri.setCode(1);
			ri.setMsg(e.getMessage());
		}

		dao.close();
		return ri;
	}

	/**
	 * 查询购物车列表
	 * @param id
	 * @return
	 */
	public ResultInfo<List<ShoppingCar>> findShoppingCarList(String id) {
		ResultInfo<List<ShoppingCar>> ri = new ResultInfo<>();
		DaoUtil dao = null;
		try {
			dao = new DaoUtil();
			dao.openCon();

			List<ShoppingCar> list = dao.query(SqlStore.FIND_ALL_SHOPPING_CAR_BY_USER_ID, id, ShoppingCar.class);
			ri.setCode(0);
			ri.setData(list);
		} catch (SysException e) {
			ri.setCode(1);
			ri.setMsg(e.getMessage());
		}
		dao.close();
		return ri;
	}

	/**
	 * 添加购物车
	 * @param car
	 * @return
	 */
	public ResultInfo<ShoppingCar> addToShoppingCar(ShoppingCar car) {
		ResultInfo<ShoppingCar> ri = new ResultInfo<>();
		DaoUtil dao = null;
		try {
			dao = new DaoUtil();
			dao.openCon();

			int i = dao.modify(SqlStore.ADD_ONE_SHOPPING_CAR, SysUtil.obj2List(car));
			if (i < 1) {
				ri.setCode(1);
				ri.setMsg(SysProperties.ADD_SHOPPING_CAR_ERROR);
			} else {
				ri.setCode(0);
			}
		} catch (SysException e) {
			ri.setCode(1);
			ri.setMsg(e.getMessage());
		}
		dao.close();
		return ri;
	}
	
	/**
	 * 删除一条购物车商品
	 * @param id
	 * @return
	 */
	public ResultInfo<ShoppingCar> delOneShoppingCar(String id) {
		ResultInfo<ShoppingCar> ri = new ResultInfo<>();
		DaoUtil dao = null;
		try {
			dao = new DaoUtil();
			dao.openCon();

			int i = dao.modify(SqlStore.DEL_ONE_SHOPPING_CAR, id);
			if (i < 1) {
				ri.setCode(1);
				ri.setMsg(SysProperties.DEL_SHOPPING_CAR_ERROR);
			} else {
				ri.setCode(0);
			}
		} catch (SysException e) {
			ri.setCode(1);
			ri.setMsg(e.getMessage());
		}
		dao.close();
		return ri;
	}
	
	/**
	 * 清空条购物车商品
	 * @param id
	 * @return
	 */
	public ResultInfo<ShoppingCar> cleanShoppingCar(String id) {
		ResultInfo<ShoppingCar> ri = new ResultInfo<>();
		DaoUtil dao = null;
		try {
			dao = new DaoUtil();
			dao.openCon();

			int i = dao.modify(SqlStore.CLEAN_ONE_SHOPPING_CAR, id);
			if (i < 1) {
				ri.setCode(1);
				ri.setMsg(SysProperties.CLEAN_SHOPPING_CAR_ERROR);
			} else {
				ri.setCode(0);
			}
		} catch (SysException e) {
			ri.setCode(1);
			ri.setMsg(e.getMessage());
		}
		dao.close();
		return ri;
	}
	
	/**
	 * 创建订单
	 * @param order
	 * @return
	 */
	public ResultInfo<Order> careateOrder(Order order) {
		ResultInfo<Order> ri = new ResultInfo<>();
		DaoUtil dao = null;
		try {
			dao = new DaoUtil();
			dao.openCon();
			
			int i = dao.modify(SqlStore.ADD_ONE_ORDER, order);
			if (i < 1) {
				ri.setCode(1);
				ri.setMsg(SysProperties.ORDER_ADD_ERROR);
			} else {
				ri.setCode(0);
			}
		} catch (SysException e) {
			ri.setCode(1);
			ri.setMsg(e.getMessage());
		}
		dao.close();
		return ri;
	}

	/**
	 * 创建订单
	 * @param order
	 * @return
	 */
	public ResultInfo<PantsStock> addOnePants(PantsStock ps) {
		ResultInfo<PantsStock> ri = new ResultInfo<>();
		DaoUtil dao = null;
		try {
			dao = new DaoUtil();
			dao.openCon();
			
			int i = dao.modify(SqlStore.ADD_ONE_STOCK, ps);
			if (i < 1) {
				ri.setCode(1);
				ri.setMsg(SysProperties.STOCK_ADD_ERROR);
			} else {
				ri.setCode(0);
			}
		} catch (SysException e) {
			ri.setCode(1);
			ri.setMsg(e.getMessage());
		}
		dao.close();
		return ri;
	}
	
	public static void main(String[] args) {
		SysService s = new SysService();
		PantsStock ps = new PantsStock();
		ps.setId(SysProperties.STOCK_PREFIX + System.currentTimeMillis());
		ps.setName("牛仔运动生活裤");
		ps.setPrice(100.00);
		ps.setStock(100);
		ps.setSale(0);
		ps.setVersion(0);
		ResultInfo<PantsStock> ri = s.addOnePants(ps);
		System.out.println(ri.toString());
	}
}
