package test_controller;

import java.io.Serializable;

public class TestVO implements Serializable {
	private static final long serialVersionUID = 1L;

public TestVO(){}
	
	private byte[] img;

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}
	
}
