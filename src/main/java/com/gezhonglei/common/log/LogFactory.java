package com.gezhonglei.common.log;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LogFactory {
	private LogFactory() {}
	
	private static LogFactory INSTANCE = new LogFactory();
	
	private Map<String, TagConfig> configs = new ConcurrentHashMap<>();
	
	public static TagLogger getTagLogger(String tagLogger) {
		String fullname = getCallerClass();
		TagConfig config = getConfig(tagLogger);
		return new TagLoggerImpl(fullname, tagLogger, config);
	}
	
	public static TagLogger getTagLogger(String tagLogger, Class<?> clazz) {
		String fullname = clazz.getName();
		TagConfig config = getConfig(tagLogger);
		return new TagLoggerImpl(fullname, tagLogger, config);
	}
	
	public static Logger getLogger(Class<?> clazz) {
		return new LoggerImpl(clazz);
	}
	
	public static Logger getLogger() {
		return new LoggerImpl(getCallerClass());
	}

	public static TagConfig getConfig(String flagLogger) {
		TagConfig config = INSTANCE.configs.get(flagLogger);
		if(config == null) {
			config = new TagConfig(flagLogger);
			INSTANCE.configs.put(flagLogger, config);
		}
		return config;
	}
	
	private static String getCallerClass() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		return stackTrace[3].getClassName();
	}
	
	public static void setTags(String tagLogger, List<String> tags) {
		getConfig(tagLogger).setTags(tags);
	}
}
