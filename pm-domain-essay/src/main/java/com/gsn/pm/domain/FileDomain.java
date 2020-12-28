package com.gsn.pm.domain;

public class FileDomain {
	private String fileName;//文件名
	private String upload;//文件上传的路径  表单传过来的字段名
	private String url;
	private Integer uploaded;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUpload() {
		return upload;
	}
	public void setUpload(String upload) {
		this.upload = upload;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getUploaded() {
		return uploaded;
	}
	public void setUploaded(Integer uploaded) {
		this.uploaded = uploaded;
	}
	
	
}
