package com.his.model;

public class ViewPolicyBean {
	private int policy_id;
	private String insurance_name;
	private int policy_amount;
	private int policy_duration;
	private String premium_type;
	private String policy_start_date;
	private int discount;
	private int premium_amount;
	private String maturity_date;
	private int customer_id;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ViewPolicyBean() {
	};

	public ViewPolicyBean(int policy_id, String insurance_name,
			int policy_amount, int policy_duration, String premium_type,
			String policy_start_date, int discount, int premium_amount,
			String maturity_date, int customer_id) {
		super();
		this.policy_id = policy_id;
		this.insurance_name = insurance_name;
		this.policy_amount = policy_amount;
		this.policy_duration = policy_duration;
		this.premium_type = premium_type;
		this.policy_start_date = policy_start_date;
		this.discount = discount;
		this.premium_amount = premium_amount;
		this.maturity_date = maturity_date;
		this.customer_id = customer_id;
	}

	public int getPolicy_id() {
		return policy_id;
	}

	public void setPolicy_id(int policy_id) {
		this.policy_id = policy_id;
	}

	public String getInsurance_name() {
		return insurance_name;
	}

	public void setInsurance_name(String insurance_name) {
		this.insurance_name = insurance_name;
	}

	public int getPolicy_amount() {
		return policy_amount;
	}

	public void setPolicy_amount(int policy_amount) {
		this.policy_amount = policy_amount;
	}

	public int getPolicy_duration() {
		return policy_duration;
	}

	public void setPolicy_duration(int policy_duration) {
		this.policy_duration = policy_duration;
	}

	public String getPremium_type() {
		return premium_type;
	}

	public void setPremium_type(String premium_type) {
		this.premium_type = premium_type;
	}

	public String getPolicy_start_date() {
		return policy_start_date;
	}

	public void setPolicy_start_date(String policy_start_date) {
		this.policy_start_date = policy_start_date;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getPremium_amount() {
		return premium_amount;
	}

	public void setPremium_amount(int premium_amount) {
		this.premium_amount = premium_amount;
	}

	public String getMaturity_date() {
		return maturity_date;
	}

	public void setMaturity_date(String maturity_date) {
		this.maturity_date = maturity_date;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	@Override
	public String toString() {
		return "ViewPolicyBean [policy_id=" + policy_id + ", insurance_name="
				+ insurance_name + ", policy_amount=" + policy_amount
				+ ", policy_duration=" + policy_duration + ", premium_type="
				+ premium_type + ", policy_start_date=" + policy_start_date
				+ ", discount=" + discount + ", premium_amount="
				+ premium_amount + ", maturity_date=" + maturity_date
				+ ", customer_id=" + customer_id + ", status=" + status + "]";
	}

	

}
