package com.product.model;

import java.util.List;

public class ProdService {
	
private ProdDAO_interface dao=null;
	
	public ProdService() {
		dao=new ProdDAO();
	}
	
	public ProdVO getOne(String prod_id) {
		return dao.findByPrimaryKey(prod_id);
	}
	
	public  List getAll(){
		return dao.getAll();
	}
	
	public void insertOne(ProdVO prodVO){
		dao.insert(prodVO);
	}
	
	public List getByName(String prod_name){
		return dao.findByName(prod_name);
	}
	
	public void update(ProdVO prodVO){
		dao.update(prodVO);
	}
	
	public void delete(String prod_id){
		dao.delete(prod_id);
		
	}
	
	public List getByGroup(String prod_group){
		return dao.findByGroup(prod_group);
	}
}
