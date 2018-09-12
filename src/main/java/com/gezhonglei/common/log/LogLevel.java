package com.gezhonglei.common.log;

public enum LogLevel {
	DEBUG("Debug", 10),
	INFO("Info", 20),
	WARN("Warn", 30),
	ERROR("Error", 40);
	
	int val = 0;
	String name = "";
	LogLevel(String name, int val) {
		this.name = name;
		this.val = val;
	}
	
	public int getValue() {
		return val;
	}
	public String getName() {
		return name;
	}
}
