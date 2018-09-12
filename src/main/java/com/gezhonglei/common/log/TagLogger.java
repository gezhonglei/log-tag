package com.gezhonglei.common.log;

public interface TagLogger extends Logger {
	void debugTag(String tag, String format, Object... params);
	void infoTag(String tag, String format, Object... params);
	void warnTag(String tag, String format, Object... params);
	void errorTag(String tag, String format, Object... params);
	
	Logger getLogger(String tag);
}
