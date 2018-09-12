package com.gezhonglei.common.log;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.spi.LocationAwareLogger;

public class LoggerImpl implements Logger {

	private final String logClassFullName = LoggerImpl.class.getName();
	private org.slf4j.Logger logger = null;
	
	public LoggerImpl(String name) {
		this.logger = LoggerFactory.getLogger(name);
	}
	
	public LoggerImpl(Class<?> clazz) {
		this.logger = LoggerFactory.getLogger(clazz);
	}
	
	@Override
	public boolean isDebugEnabled() {
		return this.logger.isDebugEnabled();
	}

	@Override
	public boolean isInfoEnabled() {
		return this.logger.isInfoEnabled();
	}

	@Override
	public boolean isWarnEnabled() {
		return this.logger.isWarnEnabled();
	}

	@Override
	public boolean isErrorEnabled() {
		return this.logger.isErrorEnabled();
	}

	@Override
	public void debug(String format, Object... params) {
		debug(format, params, null);
	}

	@Override
	public void info(String format, Object... params) {
		info(format, params, null);
	}

	@Override
	public void warn(String format, Object... params) {
		warn(format, params, null);
	}

	@Override
	public void error(String format, Object... params) {
		error(format, params, null);
	}

	public void logData(Marker marker, String logClassFullName, LogLevel level,
			String message, Object[] params, Throwable t) {
		if(this.logger instanceof LocationAwareLogger) {
			LocationAwareLogger location = (LocationAwareLogger) this.logger;
			if(params != null && params.length > 0) {
				FormattingTuple ft = MessageFormatter.arrayFormat(message, params);
				message = ft.getMessage();
			}
			location.log(marker, logClassFullName, level.val, message, null, t);
		}
	}

	@Override
	public void debug(String format, Object[] params, Throwable t) {
		if(this.isDebugEnabled()) {
			logData(null, logClassFullName, LogLevel.DEBUG, format, params, t);
		}
	}

	@Override
	public void info(String format, Object[] params, Throwable t) {
		if(this.isInfoEnabled()) {
			logData(null, logClassFullName, LogLevel.INFO, format, params, t);
		}
	}

	@Override
	public void warn(String format, Object[] params, Throwable t) {
		if(this.isWarnEnabled()) {
			logData(null, logClassFullName, LogLevel.WARN, format, params, t);
		}
	}

	@Override
	public void error(String format, Object[] params, Throwable t) {
		if(this.isErrorEnabled()) {
			logData(null, logClassFullName, LogLevel.ERROR, format, params, t);
		}
	}

	@Override
	public void debug(String message) {
		debug(message, null, null);
	}

	@Override
	public void info(String message) {
		info(message, null, null);
	}

	@Override
	public void warn(String message) {
		warn(message, null, null);
	}

	@Override
	public void error(String message) {
		error(message, null, null);
	}

	public void setLevel(LogLevel level) {
		org.apache.log4j.Logger log4jLogger = this.logger.getName().equalsIgnoreCase("ROOT") ? LogManager.getRootLogger() : LogManager.getLogger(this.logger.getName());
		log4jLogger.setLevel(Level.toLevel(level.getName().toUpperCase()));
	}

	public LogLevel getLevel() {
		org.apache.log4j.Logger log4jLogger = this.logger.getName().equalsIgnoreCase("ROOT") ? LogManager.getRootLogger() : LogManager.getLogger(this.logger.getName());
		return LogLevel.valueFrom(log4jLogger.getLevel().toString(), LogLevel.INFO);
	}
}
