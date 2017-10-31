package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemComplateDAO;
import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemComplateAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	private ArrayList<CartDTO> CartList = new ArrayList<CartDTO>();

	public String result;

	public BuyItemComplateDAO dao = new BuyItemComplateDAO();

	/**
	 * 商品購入情報登録完了メソッド
	 *
	 * @author internous
	 */
	@SuppressWarnings("unchecked")
	public String execute() {
		CartList = (ArrayList<CartDTO>) session.get("cartList");
		int CartSize = CartList.size();
		for (int i = 0; i < CartSize; i++) {
			int userId = (int) session.get("id");
			int itemId = CartList.get(i).getItemId();
			String itemName = CartList.get(i).getItemName();
			int count = CartList.get(i).getQuantities();
			int price = (int) CartList.get(i).getPrice();
			int totalPrice = count * price;
			try {
				BuyItemComplateDAO dao = new BuyItemComplateDAO();
				dao.buyItemeInfo(userId, itemId, itemName, count, price, totalPrice);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		for (int j = 0; j < CartSize; j++) {
			CartList.remove(0);
		}

		result = SUCCESS;
		return result;
	}

	public ArrayList<CartDTO> getCartList() {
		return CartList;
	}

	public void setCartList(ArrayList<CartDTO> cartList) {
		CartList = cartList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
