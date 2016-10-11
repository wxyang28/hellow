package com.lgs.bean;

public class Stu_info {
      private int stu_id;
      private int stu_tp_id;
      private String stu_user_name;
      private String stu_name;
      private enum stu_sex{ÄĞ,Å®}
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public int getStu_tp_id() {
		return stu_tp_id;
	}
	public void setStu_tp_id(int stu_tp_id) {
		this.stu_tp_id = stu_tp_id;
	}
	public String getStu_user_name() {
		return stu_user_name;
	}
	public void setStu_user_name(String stu_user_name) {
		this.stu_user_name = stu_user_name;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	};
      
}
