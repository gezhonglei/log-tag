package com.gezhonglei.common.log;

import java.util.Arrays;

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
	
	public static LogLevel valueFrom(String str, LogLevel defValue) {
		return Arrays.asList(LogLevel.values()).stream().
				filter(p-> p.name.equalsIgnoreCase(str)).findFirst().orElse(defValue);
	}
	
	public static LogLevel valueFrom(int intValue, LogLevel defValue) {
		return Arrays.asList(LogLevel.values()).stream().
				filter(p-> p.val == intValue).findFirst().orElse(defValue);
	}
}
