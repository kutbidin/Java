package test;

import java.util.concurrent.atomic.AtomicLong;

public class Staff {
	static final AtomicLong Next_ID=new AtomicLong(1);  //initial id is 1
  private final long ID=Next_ID.getAndIncrement();
  private String name;
  private String surName;
public long getID() {
	return ID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surName;
}
public void setSurname(String surname) {
	surName = surname;
}
  
public Staff(String name,String surname) {
	this.name=name;
	this.surName=surname;
}
  
}
