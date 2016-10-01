package com.superinc.europe.onlineshopping.gu.entities.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="goodsinorders")
public class GoodsOrders implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "goodsorders_id")
	private int goodsOrdersId;

	@ManyToOne(targetEntity=Orders.class, fetch = FetchType.LAZY)
	@JoinColumn(name="orders_id_FK", referencedColumnName = "orders_id")
    private Orders ordersFk; 

	@ManyToOne(targetEntity=Goods.class, fetch = FetchType.LAZY)
	@JoinColumn(name="goods_id_FK", referencedColumnName = "goods_id")
    private Goods goodsFk; 
    
    @Column(name="count")
    private int count = 1;

	public GoodsOrders() {
	}
	
	public GoodsOrders(Orders ordersFk, Goods goodsFk, int count) {
		this.ordersFk = ordersFk;
		this.goodsFk = goodsFk;
		this.count = count;
	}

	public int getGoodsOrders() {
		return goodsOrdersId;
	}

	public void setGoodsOrders(int goodsOrders) {
		this.goodsOrdersId = goodsOrders;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Orders getOrdersFk() {
		return ordersFk;
	}

	public void setOrdersFk(Orders ordersFk) {
		this.ordersFk = ordersFk;
	}

	public Goods getGoodsFk() {
		return goodsFk;
	}

	public void setGoodsFk(Goods goodsFk) {
		this.goodsFk = goodsFk;
	}

	@Override
	public int hashCode() {
        int hash = 1;
//        hash = hash * 31 + description.hashCode();
//        hash = hash * 31 + goods_id;
          hash = 31;
        return hash;
	}

	@Override
	public String toString() {
		return "GoodsOrders [goodsOrdersId=" + goodsOrdersId + ", ordersFk="
				+ ordersFk + ", goodsFk=" + goodsFk + ", count=" + count + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
//		BlackBox other = (BlackBox) obj;
//		if (varA != other.varA)
//			return false;
//		if (varB != other.varB)
//			return false;
		return true;
	}
}