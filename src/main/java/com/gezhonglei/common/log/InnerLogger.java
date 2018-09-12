package com.gezhonglei.common.log;

public class InnerLogger implements Logger {

	private static String logClassFullname = InnerLogger.class.getName();
	
	private String tag;
	private TagLoggerImpl logger;
	
	public InnerLogger(String tag, TagLoggerImpl logger) {
		this.tag = tag;
		this.logger = logger;
	}
	
	@Override
	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	@Override
	public boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

	@Override
	public boolean isWarnEnabled() {
		return logger.isWarnEnabled();
	}

	@Override
	public boolean isErrorEnabled() {
		return logger.isErrorEnabled();
	}

	@Override
	public void debug(String format, Object... params) {
		this.logger.logDataFlag(tag, logClassFullname, LogLevel.DEBUG, format, params, null);
	}

	@Override
	public void info(String format, Object... params) {
		this.logger.logDataFlag(tag, logClassFullname, LogLevel.INFO, format, params, null);
	}

	@Override
	public void warn(String format, Object... params) {
		this.logger.logDataFlag(tag, logClassFullname, LogLevel.WARN, format, params, null);
	}

	@Override
	public void error(String format, Object... params) {
		this.logger.logDataFlag(tag, logClassFullname, LogLevel.ERROR, format, params, null);
	}

}
