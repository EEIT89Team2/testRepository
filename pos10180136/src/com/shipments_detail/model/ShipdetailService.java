package com.shipments_detail.model;

import java.util.List;

import com.shipments_detail.model.ShipdetailVO;

public class ShipdetailService {

	private ShipdetailDAO_interface dao=null;
	
	public ShipdetailService(){
		dao=new ShipdetailDAO();
	}
	
	public List<ShipdetailVO> getByShipId(String ship_id){
		return dao.findByShipId(ship_id);
	}
	
	public void delete (String ship_id,String prod_id){

		dao.delete(ship_id, prod_id);
	}
}
