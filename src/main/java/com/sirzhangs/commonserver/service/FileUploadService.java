package com.sirzhangs.commonserver.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.sirzhangs.common.entity.RequestResult;

public interface FileUploadService {

	/**
	 * 上传文件
	 * @param multipartFile
	 * @return
	 */
	RequestResult upload(MultipartFile multipartFile,HttpServletRequest httpServletRequest ,HttpServletResponse response);

	/**
	 * 删除文件
	 * @param ids
	 * @return
	 */
	RequestResult delete(List<String> ids);

	/**
	 * 查询文件
	 * @param id
	 * @return
	 */
	RequestResult findById(String id);
}
