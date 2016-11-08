package test_controller;

import java.util.Date;

public class testDate {

	public static void main(String[] args) {
		long nowD = new java.util.Date().getTime();
		Date key_date = new Date(nowD);
		  System.out.println(key_date);

	}

}
