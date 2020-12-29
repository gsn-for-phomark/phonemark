package com.gsn.pm.domain;


import lombok.Data;

@Data
public class FileDomain {
	private String fileName;//文件名
	private String upload;//文件上传的路径  表单传过来的字段名
	private String url;
	private Integer uploaded;

}
