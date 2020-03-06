package com.sirzhangs.commonserver.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.util.StringUtils;
import com.sirzhangs.common.entity.RequestResult;
import com.sirzhangs.common.util.GeneratorCodeUtil;
import com.sirzhangs.commonserver.entity.FileData;
import com.sirzhangs.commonserver.mapper.FileUploadMapper;
import com.sirzhangs.commonserver.service.FileUploadService;
import com.sirzhangs.commonserver.util.FileUploadUtil;

@Service
public class FileUploadServiceImpl implements FileUploadService {
	
	private Logger log = LoggerFactory.getLogger(FileUploadService.class);

	@Autowired
	private FileUploadUtil fileUploadUtil;
	
	@Autowired
	private FileUploadMapper fileUploadMapper;

	@Override
	public RequestResult upload(MultipartFile multipartFile,HttpServletRequest request ,HttpServletResponse response) {
		
		String url;
		try {
			url = fileUploadUtil.uploadFile(multipartFile);
		} catch (IOException e) {
			log.error(e.getMessage());
			return RequestResult.fail("上传失败");
		}
		
		if(StringUtils.isEmpty(url)) {
			return RequestResult.fail("上传失败");
		}
		
		// 封装数据对象
		String id = GeneratorCodeUtil.generatorCode(64);
		String name = multipartFile.getName();
		String originalFilename = multipartFile.getOriginalFilename();
		String fileName = StringUtils.isEmpty(name) ? originalFilename : name;
		long size = multipartFile.getSize();
		String typeCode = multipartFile.getContentType();
		
		String ownerPar = request.getParameter("owner");
		String authPar = request.getParameter("owner");
		String owner = StringUtils.isEmpty(ownerPar) ? "" : ownerPar;
		String auth = StringUtils.isEmpty(authPar) ? "" : authPar;
		
		FileData fileData = new FileData(id,fileName,"",typeCode,size,url,new Date(),"",owner,auth);
		
		int count = fileUploadMapper.add(fileData);
		
		return count > 0 ? RequestResult.ok():RequestResult.fail();
	}

	@Override
	public RequestResult delete(List<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestResult findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
