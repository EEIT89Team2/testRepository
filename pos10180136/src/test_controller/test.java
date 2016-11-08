package test_controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

	public static void main(String[] args) {
		
		String name="R";
		String id="R2016100300006";
		String newID;
		
		String date=id.substring(1, 9);
		Integer idNo=Integer.parseInt(id.substring(9))+1;
		
		
		java.util.Date utilDate = new Date(); 
		  java.sql.Timestamp stp = new java.sql.Timestamp(utilDate.getTime());
		  String today = ((stp.toString().split(" "))[0].split("-"))[0]+((stp.toString().split(" "))[0].split("-"))[1]+
	    		   ((stp.toString().split(" "))[0].split("-"))[2];
		  
		  if(date.equals(today)){
			  newID=name+date+String.format("%05d", idNo);
		  }else{
			  newID=name+today+"00001";
		  }
//			int nextval1 = Integer.parseInt(today);
//		String	emp_id=name+today+String.format("%05d", 1);
		
		
			System.out.println(newID);

	}

}
