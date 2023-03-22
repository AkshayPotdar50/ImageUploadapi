package com.boot.image.payload;


public class FileResponce {
private 	String filename;
	private  String messege;
	public FileResponce(String filename, String messege) {
		super();
		this.filename = filename;
		this.messege = messege;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
	

	
}
