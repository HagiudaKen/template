package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {

	private ArrayList<CartDTO> CartList = new ArrayList<CartDTO>();

	public Map<String, Object> session;

	public String result;

	public int itemDelete;

	public int[] quantities;

	/**
	 * 商品購入情報登録メソッド
	 *
	 * @author internous
	 */
	@SuppressWarnings("unchecked")
	public String execute() throws SQLException {
		if (session.get("id") != null) {

			CartList = (ArrayList<CartDTO>) session.get("cartList");
			for (int i = 0; i < CartList.size(); i++) {
				if (itemDelete == 0) {
					CartDTO dto = new CartDTO();
					dto.setUserId(CartList.get(i).getUserId());
					dto.setItemId(CartList.get(i).getItemId());
					dto.setItemName(CartList.get(i).getItemName());
					dto.setStock(CartList.get(i).getStock());
					dto.setPrice(CartList.get(i).getPrice());
					dto.setQuantities(quantities[i] + CartList.get(i).getQuantities());
					dto.setTotalPrice(CartList.get(i).getTotalPrice());
					CartList.set(i, dto);
				} else {
					if (CartList.get(i).getItemId() == itemDelete) {
						CartList.remove(i);
						return NONE;
					}
				}
			}
			session.put("cartList", CartList);
			return SUCCESS;
		}
		return ERROR;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<CartDTO> getCartList() {
		return CartList;
	}

	public void setCartList(ArrayList<CartDTO> cartList) {
		CartList = cartList;
	}

	public int getItemDelete() {
		return itemDelete;
	}

	public void setItemDelete(int itemDelete) {
		this.itemDelete = itemDelete;
	}

	public int[] getQuantities() {
		return quantities;
	}

	public void setQuantities(int[] quantities) {
		this.quantities = quantities;
	}
}
