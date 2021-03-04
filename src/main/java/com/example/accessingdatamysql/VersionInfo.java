package com.example.accessingdatamysql;

public class VersionInfo {

	private String createdDate = "1 January 1970 00:00:00 UT";

	private String projectName = "name-mysqlapp";


	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "VersionInfo{" +
				"createdDate='" + createdDate + '\'' +
				", projectName='" + projectName + '\'' +
				'}';
	}
}
