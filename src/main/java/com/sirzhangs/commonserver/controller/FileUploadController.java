package com.sirzhangs.commonserver.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sirzhangs.common.entity.RequestResult;
import com.sirzhangs.commonserver.service.FileUploadService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "FileUploadController")
@RestController
@RequestMapping(value = "/file/manage",produces = "application/json")
public class FileUploadController {

	@Autowired
	private FileUploadService fileUploadService;
	
	@ApiOperation(value = "文件上传",notes = "")
	@PostMapping("upload")
	public RequestResult upload(
			MultipartFile multipartFile,HttpServletRequest request, HttpServletResponse response
			) {
		return	fileUploadService.upload(multipartFile,request,response);
	}

	@ApiOperation(value = "文件删除",notes = "")
	@PostMapping("delete")
	public RequestResult delete(
			@RequestBody List<String> ids) {
		return fileUploadService.delete(ids);
	}
	
	@ApiOperation(value = "文件查找",notes = "")
	@GetMapping("findById/{id}")
	public RequestResult findById(
			@PathVariable("id")String id) {
		return fileUploadService.findById(id);
	}
}
