package com.qcs.namelist.action;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.qcs.base.action.BaseAction;
import com.qcs.base.exception.BusinessException;
import com.qcs.teacher.service.TeacherService;

@ParentPackage("struts-default")
@Namespace("/namelist")
@Results({
	@Result(name="toImportTeacher",location="/WEB-INF/pages/namelist/importTeacher.jsp"),
})
@ExceptionMappings( { @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") }) 

public class NameListAction extends BaseAction {

	public static String TO_IMPORT_TEACHER = "toImportTeacher";
	
	private File uploadFile;
    private String fileFileName;
    private String fileFileContentType;
    @Autowired
    private TeacherService teacherService;

    private Logger log = Logger.getLogger(NameListAction.class);
	
	@Action("toImportTeacher")
	public String toImportTeacher(){
		return TO_IMPORT_TEACHER;
	}
	
	@Action("importTeacher")
	public String importTeacher(){
		if(uploadFile != null){
			//导入Teacher信息
			try {
				teacherService.importTeachers(uploadFile);
			} catch (BusinessException e) {
				log.info(e);
			}
			
		}
		return SUCCESS;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileFileContentType() {
		return fileFileContentType;
	}

	public void setFileFileContentType(String fileFileContentType) {
		this.fileFileContentType = fileFileContentType;
	}
	
	
}
