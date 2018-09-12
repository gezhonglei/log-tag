package com.gezhonglei.common.log;

public interface Logger {
	boolean isDebugEnabled();
	boolean isInfoEnabled();
	boolean isWarnEnabled();
	boolean isErrorEnabled();
	
	void debug(String message);
	void info(String message);
	void warn(String message);
	void error(String message);
	
	void debug(String format, Object... params);
	void info(String format, Object... params);
	void warn(String format, Object... params);
	void error(String format, Object... params);
	
	void debug(String format, Object[] params, Throwable t);
	void info(String format, Object[] params, Throwable t);
	void warn(String format, Object[] params, Throwable t);
	void error(String format, Object[] params, Throwable t);
}
