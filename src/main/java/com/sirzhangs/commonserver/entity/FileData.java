package com.sirzhangs.commonserver.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileData {
	/**
	 * 主键ID
	 */
	private String id;
	/**
	 * 文件名称
	 */
	private String fileName;
	/**
	 * 文件类型
	 */
	private String typeName;
	/**
	 * 文件类型编码
	 */
	private String typeCode;
	/**
	 * 文件大小
	 */
	private Long size;
	/**
	 * 文件存放路径
	 */
	private String url;
	/**
	 * 文件上传时间
	 */
	private Date createdTime;
	/**
	 * 文件上传者
	 */
	private String creator;
	/**
	 * 文件所有者
	 */
	private String owner;
	/**
	 * 文件权限
	 */
	private String auth;
}
