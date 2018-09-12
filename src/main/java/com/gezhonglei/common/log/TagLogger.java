package com.gezhonglei.common.log;

public interface TagLogger extends Logger {
	
	void debugTag(String tag, String format, Object... params);
	void infoTag(String tag, String format, Object... params);
	void warnTag(String tag, String format, Object... params);
	void errorTag(String tag, String format, Object... params);
	
	void debugTag(String tag, String format, Object[] params, Throwable t);
	void infoTag(String tag, String format, Object[] params, Throwable t);
	void warnTag(String tag, String format, Object[] params, Throwable t);
	void errorTag(String tag, String format, Object[] params, Throwable t);
	
	Logger getLogger(String tag);
}
