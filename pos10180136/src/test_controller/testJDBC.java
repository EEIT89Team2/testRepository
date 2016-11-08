package test_controller;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;


public class testJDBC {

	public String getID() throws Exception{
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=pos";
		String userid = "sa";
		String passwd = "P@ssw0rd";
		//------------------------------------------------
		String tableName="REQUISITION"; //table名稱
		String fieldName="req_id";      //"編號"欄位名稱
		String name="D";                //編號專屬開頭代號
		//------------------------------------------------------
		
		String newID;
		Connection con ;
		
			
			con = DriverManager.getConnection(url, userid, passwd);
			PreparedStatement stmt = con.prepareStatement("SELECT top 1 "+fieldName+" as nextval from "
					+tableName+" ORDER BY "+ fieldName+" DESC");
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			
			//ex:R2016092900001-------------------------------------------------
			
			String id=rs.getString("nextval");
			id="R2016100500006";
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
			
			//-------------------------------------------------------------------
			
			
			
			//ex:E00001----------------------------------------------------------
			
//				int nextval =( Integer.parseInt((rs.getString("nextval").split(name))[1]))+1;
//				newID=name+String.format("%05d", nextval);
			
			//-------------------------------------------------------------------
			
			
			System.out.println(newID);
			
			con.close();
		
			
		
		return newID;
	}
	public static void main(String[] args) throws Exception {
		
	 new testJDBC().getID();
		
		
		}

	}


