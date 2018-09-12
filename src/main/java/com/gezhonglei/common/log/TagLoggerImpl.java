package com.gezhonglei.common.log;

public class TagLoggerImpl extends LoggerImpl implements TagLogger {
	
	private static final String FQCN = TagLoggerImpl.class.getName();
	
	protected LoggerImpl tagLogger;
	protected TagConfig config;
	
	public TagLoggerImpl(String packageName, String loggerName, TagConfig config) {
		super(packageName);		
		this.tagLogger = new LoggerImpl(loggerName);
		this.config = config;
	}

	public void logDataFlag(String tag, String logClassFullName, LogLevel level, String format,
			Object[] params, Throwable t) {
		if(config.checkPackageLogEnabled(tag)) {
			this.logData(null, logClassFullName, level, format, params, t);
		}
		if(config.checkTagLogEnable(tag)) {
			this.tagLogger.logData(null, logClassFullName, LogLevel.ERROR, format, params, t);
		}
	}
	
	@Override
	public void debug(String format, Object... params) {
		logDataFlag(null, FQCN, LogLevel.DEBUG, format, params, null);
	}
		

	@Override
	public void info(String format, Object... params) {
		logDataFlag(null, FQCN, LogLevel.INFO, format, params, null);
	}

	@Override
	public void warn(String format, Object... params) {
		logDataFlag(null, FQCN, LogLevel.WARN, format, params, null);
	}

	@Override
	public void error(String format, Object... params) {
		logDataFlag(null, FQCN, LogLevel.ERROR, format, params, null);
	}

	@Override
	public void debugTag(String tag, String format, Object... params) {
		this.logDataFlag(tag, FQCN, LogLevel.DEBUG, format, params, null);
	}

	@Override
	public void infoTag(String tag, String format, Object... params) {
		this.logDataFlag(tag, FQCN, LogLevel.INFO, format, params, null);
	}

	@Override
	public void warnTag(String tag, String format, Object... params) {
		this.logDataFlag(tag, FQCN, LogLevel.WARN, format, params, null);
	}

	@Override
	public void errorTag(String tag, String format, Object... params) {
		this.logDataFlag(tag, FQCN, LogLevel.ERROR, format, params, null);
	}

	@Override
	public Logger getLogger(String tag) {
		return new InnerLogger(tag, this);
	}

	@Override
	public void debugTag(String tag, String format, Object[] params, Throwable t) {
		this.logDataFlag(tag, FQCN, LogLevel.ERROR, format, params, t);
	}

	@Override
	public void infoTag(String tag, String format, Object[] params, Throwable t) {
		this.logDataFlag(tag, FQCN, LogLevel.ERROR, format, params, t);
	}

	@Override
	public void warnTag(String tag, String format, Object[] params, Throwable t) {
		this.logDataFlag(tag, FQCN, LogLevel.ERROR, format, params, t);
	}

	@Override
	public void errorTag(String tag, String format, Object[] params, Throwable t) {
		this.logDataFlag(tag, FQCN, LogLevel.ERROR, format, params, t);
	}
}
