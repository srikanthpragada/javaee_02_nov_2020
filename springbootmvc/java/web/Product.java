package web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Product {
	private double price, discount, netPrice;

	@Min(value=1,message = "Invalid Price. It must be > 0")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Min(value=5, message = "Minimum discount is 5")
	@Max(value=50, message = "Maximum discount is 50")
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}

}
