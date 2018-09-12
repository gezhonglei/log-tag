package com.gezhonglei.common.log;

import java.util.ArrayList;
import java.util.List;

public class TagConfig {
	private String tagLogger;
	private List<String> tags = new ArrayList<String>();
	private boolean packageLogIncluded;
	private boolean matchedTagInPackageLog;
	private boolean dismatchedTagInPackageLog;
	
	public TagConfig(String tagLogger) {
		this.tagLogger = tagLogger;
	}
	
	public String getTagLogger() {
		return tagLogger;
	}

	public void setTags(List<String> tags) {
		this.tags.clear();
		this.tags.addAll(tags);
	}
	
	public boolean checkPackageLogEnabled(String tag) {
		if(tag == null) return true;
		boolean matched = tags.contains(tag);
		return (matchedTagInPackageLog && matched) || (dismatchedTagInPackageLog && !matched);
	}

	public boolean checkTagLogEnable(String tag) {
		return (tag == null && packageLogIncluded && tags.size() > 0) || (tag != null && tags.contains(tag));
	}

	public boolean isPackageLogIncluded() {
		return this.packageLogIncluded;
	}
	
	public void setPackageLogIncluded(boolean packageLogIncluded) {
		this.packageLogIncluded = packageLogIncluded;
	}
	
	public boolean isMatchedTagInPackageLog() {
		return matchedTagInPackageLog;
	}

	public void setMatchedTagInPackageLog(boolean matchedTagInPackageLog) {
		this.matchedTagInPackageLog = matchedTagInPackageLog;
	}

	public boolean isDismatchedTagInPackageLog() {
		return dismatchedTagInPackageLog;
	}

	public void setDismatchedTagInPackageLog(boolean dismatchedTagInPackageLog) {
		this.dismatchedTagInPackageLog = dismatchedTagInPackageLog;
	}
	
}
