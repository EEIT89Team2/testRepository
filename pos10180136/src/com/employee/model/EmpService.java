package com.employee.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class EmpService {
	
	private EmpDAO_interface dao=null;
	
	public EmpService() {
		dao=new EmpDAO();
	}
	
	public EmpVO getOne(String emp_id) throws IOException, IOException{
		return dao.findByPrimaryKey(emp_id);
	}
	
	public  List getAll() throws IOException{
		return dao.getAll();
	}
	
	public void insertOne(EmpVO empVO){
		dao.insert(empVO);
	}
	
	public List getByName(String emp_name){
		return dao.findByName(emp_name);
	}
	
	public void update(EmpVO empVO){
		dao.update(empVO);
	}
	
	public void delete(String emp_id){
		dao.delete(emp_id);
		
	}
	
	public void setPassCode(String pass_code,String emp_id){
		dao.setPassCode(pass_code, emp_id);
	}
}
