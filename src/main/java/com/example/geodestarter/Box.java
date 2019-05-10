package com.example.geodestarter;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

@Region("Box")
public class Box implements Serializable  {
	
	@Id
	private String id;
	private int width, length, depth;
	
	public Box() {
		
	}
	
	public Box(String id, int width, int length, int depth) {
		super();
		this.id = id;
		this.width = width;
		this.length = length;
		this.depth = depth;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	

}
