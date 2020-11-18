package beans;

public class InterestBean {
	int amount, days;
	double interest;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		System.out.println(amount);
		this.amount = amount;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public void calculate() {
		if (days < 365)
			interest = (amount * 0.05) / (days / 365.0);
		else
			interest = (amount * 0.06) / (days / 365.0);
	}

}
