package net.serenity.bdd.junit.cucumber.model;

public class CheckStatusData {

	private String SSN;
	private String filingStatus;
	private String refundAmount;
	
	public String getSSN1() {
		return SSN.substring(0, 3);
	}
	public String getSSN2() {
		return SSN.substring(3, 5);
	}
	public String getSSN3() {
		return SSN.substring(5, 9);
	}
	
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public String getFilingStatus() {
		return filingStatus;
	}
	public void setFilingStatus(String filingStatus) {
		this.filingStatus = filingStatus;
	}
	public String getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}
	
	public void setAll(String SSN, String filingStatus, String refundAmount) {
		this.SSN = SSN;
		this.filingStatus = filingStatus;
		this.refundAmount = refundAmount;
	}




}
