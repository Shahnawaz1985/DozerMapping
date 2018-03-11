package com.bac.beans.custom;

public class Person {
	
	private String name;
	private String nickName;
	private int age;
	
	public Person() {
		
	}

	public Person(String name, String nickName, int age) {
		super();
		this.name = name;
		this.nickName = nickName;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}	
}
