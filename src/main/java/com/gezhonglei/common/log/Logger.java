package com.gezhonglei.common.log;

public interface Logger {
	boolean isDebugEnabled();
	boolean isInfoEnabled();
	boolean isWarnEnabled();
	boolean isErrorEnabled();
	
	void debug(String format, Object... params);
	void info(String format, Object... params);
	void warn(String format, Object... params);
	void error(String format, Object... params);
}
