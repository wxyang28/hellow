package com.lgs.bean;

public class Tp_info {
     private int tp_id;
     private String tp_name;
     private String tp_user_name;
     private String tp_role;
     private String tp_tel;
     private enum tp_sex{ÄÐ,Å®}
	public int getTp_id() {
		return tp_id;
	}
	public void setTp_id(int tp_id) {
		this.tp_id = tp_id;
	}
	public String getTp_name() {
		return tp_name;
	}
	public void setTp_name(String tp_name) {
		this.tp_name = tp_name;
	}
	public String getTp_user_name() {
		return tp_user_name;
	}
	public void setTp_user_name(String tp_user_name) {
		this.tp_user_name = tp_user_name;
	}
	public String getTp_role() {
		return tp_role;
	}
	public void setTp_role(String tp_role) {
		this.tp_role = tp_role;
	}
	public String getTp_tel() {
		return tp_tel;
	}
	public void setTp_tel(String tp_tel) {
		this.tp_tel = tp_tel;
	};
     
}
