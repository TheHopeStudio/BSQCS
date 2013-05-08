package com.qcs.teacher.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.qcs.base.exception.BusinessException;
import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationResult;
import com.qcs.common.utils.MD5Utils;
import com.qcs.teacher.dao.TeacherDao;
import com.qcs.teacher.pojo.Teacher;
import com.qcs.teacher.service.TeacherService;
import com.qcs.user.dao.UserDao;
import com.qcs.user.pojo.User;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private UserDao userDao;
	
	private Logger log = Logger.getLogger(TeacherServiceImpl.class);
	
	@Override
	public int add(Teacher t) throws BusinessException {
		return teacherDao.add(t);
	}

	@Override
	public int delete(Teacher t) throws BusinessException {
		return teacherDao.delete(t);
	}

	@Override
	public int update(Teacher t) throws BusinessException {
		return teacherDao.update(t);
	}

	@Override
	public List<Teacher> query(Teacher t) throws BusinessException {
		return teacherDao.query(t);
	}

	@Override
	public List<Teacher> query(Teacher t, boolean join)
			throws BusinessException {
		return teacherDao.query(t,join);
	}

	@Override
	public PaginationResult<Teacher> query(Teacher t, PaginationInfo pageInfo)
			throws BusinessException {
		return teacherDao.query(t, pageInfo);
	}

	@Override
	public PaginationResult<Teacher> query(Teacher t, PaginationInfo pageInfo,
			boolean join) throws BusinessException {
		return teacherDao.query(t, pageInfo,join);
	}

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void insertTeachers(File uploadFile) throws BusinessException {
		POIFSFileSystem fs = null;
		User user = null;
		Teacher teacher = null;
		try {
			fs = new POIFSFileSystem(new FileInputStream(uploadFile));
			//得到Excel工作簿对象   
			HSSFWorkbook wb = new HSSFWorkbook(fs);  
			//得到Excel工作表对象   
			HSSFSheet sheet = wb.getSheetAt(0); 
			//行数
			int rowNum = sheet.getLastRowNum();
			//表头行不要
			for(int i=1; i<rowNum; ++i){
				//得到Excel工作表的行   
				HSSFRow row = sheet.getRow(i);
				teacher = new Teacher();
				teacher.setTeacherNo(row.getCell(0).toString());
				teacher.setName(row.getCell(1).toString());
				String gender = row.getCell(2).equals("女") ? "0" : "1";
				teacher.setGender(gender);
				teacher.setBirthDate(row.getCell(3).toString());
				teacher.setDepartment(row.getCell(4).toString());
				teacher.setEducation(row.getCell(5).toString());
				teacher.setDegree(row.getCell(6).toString());
				teacher.setJob(row.getCell(7).toString());
				teacher.setJobTitle(row.getCell(8).toString());
				teacher.setMajor(row.getCell(9).toString());
				teacher.setGraduated(row.getCell(10).toString());
				teacher.setTeacherCert(row.getCell(11).toString());
				teacher.setRemark(row.getCell(12).toString());
				
				
				//创建一个用户
				user = new User();
				user.setUsername("T"+teacher.getTeacherNo());
				user.setPassword(MD5Utils.getMD5(teacher.getTeacherNo().getBytes()));
				user.setType("0");
				user.setState("0");
				//插入数据到user表
				if(userDao.add(user) > 0){
					teacher.setUserId(user.getId());
					teacherDao.add(teacher);
				}
			}
		} catch(DataAccessException e){
			log.info(e);
			throw new BusinessException("添加教师:"+teacher.getName()+",教工号:"+teacher.getTeacherNo()+"时出错！可能是教工号已存在!");
		} catch (FileNotFoundException e) {
			log.info(e);
			throw new BusinessException("找不到文件![file:"+uploadFile.getAbsolutePath()+"]");
		} catch (IOException e) {
			log.info(e);
			throw new BusinessException("文件读取异常");
		}   
	}

}
