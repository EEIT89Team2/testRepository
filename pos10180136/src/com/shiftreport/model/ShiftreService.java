package com.shiftreport.model;

import java.sql.Date;
import java.util.List;


public class ShiftreService {

	private ShiftreDAO_interface dao=null;
	
	public ShiftreService() {
		dao=new ShiftreDAO();
	}
	
	public ShiftreVO getOne(Date Date,String shift) {
		return dao.findByPrimaryKey(Date,shift);
	}
	
	public  List getAll(){
		return dao.getAll();
	}
	
	public void insertOne(ShiftreVO shiftreVO){
		dao.insert(shiftreVO);
	}
	
	public List getByDate(Date Date){
		return dao.findByDate(Date);
	}
	
	public void update(ShiftreVO shiftreVO){
		dao.update(shiftreVO);
	}
	
	public void delete(Date Date,String shift){
		dao.delete(Date,shift);
		
	}

}
