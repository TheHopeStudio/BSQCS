package com.qcs.namelist.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import net.sf.json.JSONObject;

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
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import com.qcs.base.action.BaseAction;
import com.qcs.base.exception.BusinessException;
import com.qcs.student.service.StudentService;
import com.qcs.teacher.service.TeacherService;

@ParentPackage("struts-default")
@Namespace("/namelist")
@Results({
	@Result(name="toImportTeacher",location="/WEB-INF/pages/namelist/importTeacher.jsp"),
	@Result(name="toImportStudent",location="/WEB-INF/pages/namelist/importStudent.jsp")
})
@ExceptionMappings( { @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") }) 

public class NameListAction extends BaseAction {

	public static String TO_IMPORT_TEACHER = "toImportTeacher";
	public static String TO_IMPORT_STUDENT = "toImportStudent";
	
	
	private File uploadFile;
    private String fileFileName;
    private String fileFileContentType;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    
    private String info;
    private String err;

    private Logger log = Logger.getLogger(NameListAction.class);
	
	@Action("toImportTeacher")
	public String toImportTeacher(){
		return TO_IMPORT_TEACHER;
	}
	
	@Action("toImportStudent")
	public String toImportStudent(){
		return TO_IMPORT_STUDENT;
	}
	
	@Action("importStudent")
	public void importStudent(){
		if(uploadFile != null){
			//导入Teacher信息
			try {
				studentService.insertStudent(uploadFile);
			} catch (BusinessException e) {
				log.info(e);
				err = e.getMessage();
			}
		}
		if(err == null){
			info = "导入成功";
		}
	}
	
	@Action("importTeacher")   
	public void importTeacher(){
		if(uploadFile != null){
			//导入Teacher信息
			try {
				teacherService.insertTeachers(uploadFile);
			} catch (BusinessException e) {
				log.info(e);
				err = e.getMessage();
			}
		}
		if(err == null){
			info = "导入成功";
		}
		HashMap result = new HashMap();
		result.put("info", info);
		result.put("err", err);
		String str = JSONObject.fromObject(result).toString();
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			log.info(e);
		}
		out.write(str);
		out.flush();
		out.close();
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

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	@JSON
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@JSON
	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	
}
