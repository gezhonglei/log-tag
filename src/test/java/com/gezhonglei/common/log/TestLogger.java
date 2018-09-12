package com.gezhonglei.common.log;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLogger {

	private static TagLogger logger = LogFactory.getTagLogger("tag");
	
	private TagConfig config = LogFactory.getConfig("tag");
	private String tag = "192.168.1.1:502";
	
	@Before
	public void init() {
		System.out.println("----- init -----");
		config.setTags(Arrays.asList(tag));
	}
	
	@After
	public void clear() {
		config.setTags(Arrays.asList());
		config.setPackageLogIncluded(false);
		config.setMatchedTagInPackageLog(false);
		config.setDismatchedTagInPackageLog(false);
	}
	
	@Test
	public void test01() {
		String value = "AAAAAA";
		logger.info("----- package-level-info ------");
		logger.debug("debug: {}", value);
		logger.info("info: {}", value);
		logger.warn("warn: {}", value);
		logger.error("error: {}", value);
	}
	
	@Test
	public void test02() {
		String value = "BBBBBB";
		logger.infoTag(tag, "------- matched tag --------");
		logger.debugTag(tag, "debugTag: {}", value);
		logger.infoTag(tag, "infoTag: {}", value);
		logger.warnTag(tag, "warnTag: {}", value);
		logger.errorTag(tag, "errorTag: {}", value);
	}
	
	@Test
	public void test03() {
		String value = "CCCCCC";
		String tag = "aa";
		logger.infoTag(tag, "------- dismatched tag --------");
		logger.debugTag(tag, "debugTag: {}", value);
		logger.infoTag(tag, "infoTag: {}", value);
		logger.warnTag(tag, "warnTag: {}", value);
		logger.errorTag(tag, "errorTag: {}", value);
	}
	
	@Test
	public void test04() {
		String value = "DDDDDDD";
		Logger tagInstanceLogger = logger.getLogger(tag);
		tagInstanceLogger.info("------- simplified logger--------");
		tagInstanceLogger.debug("debug: {}", value);
		tagInstanceLogger.info("info: {}", value);
		tagInstanceLogger.warn("warn: {}", value);
		tagInstanceLogger.error("error: {}", value);
	}
	
	@Test
	public void test05() {
		config.setPackageLogIncluded(true);
		test01();
	}
	
	@Test
	public void test06() {
		config.setTags(Arrays.asList());
		config.setPackageLogIncluded(true);
		test01();
	}
	
	@Test
	public void test07() {
		config.setMatchedTagInPackageLog(true);
		test02();
	}
	
	@Test
	public void test08() {
		config.setDismatchedTagInPackageLog(true);
		test03();
	}
}
