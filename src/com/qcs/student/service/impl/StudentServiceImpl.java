package com.qcs.student.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.qcs.base.exception.BusinessException;
import com.qcs.common.utils.MD5Utils;
import com.qcs.student.dao.StudentDao;
import com.qcs.student.pojo.Student;
import com.qcs.student.service.StudentService;
import com.qcs.user.dao.UserDao;
import com.qcs.user.pojo.User;

@Service
public class StudentServiceImpl implements StudentService {

	private Logger log = Logger.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public int add(Student student) throws BusinessException {
		return studentDao.add(student);
	}

	@Override
	public int delete(Student student) throws BusinessException {
		return studentDao.delete(student);
	}

	@Override
	public int update(Student student) throws BusinessException {
		return studentDao.update(student);
	}

	@Override
	public List<Student> query(Student student) throws BusinessException {
		return studentDao.query(student);
	}

	@Override
	public void insertStudent(File uploadFile) throws BusinessException {
		POIFSFileSystem fs = null;
		User user = null;
		Student student = null;
		try {
			fs = new POIFSFileSystem(new FileInputStream(uploadFile));
			//得到Excel工作簿对象   
			HSSFWorkbook wb = new HSSFWorkbook(fs);  
			//得到Excel工作表对象   
			HSSFSheet sheet = wb.getSheetAt(0); 
			//行数
			int rowNum = sheet.getLastRowNum();
			//表头行不要
			for(int i=1; i<=rowNum; ++i){
				//得到Excel工作表的行   
				HSSFRow row = sheet.getRow(i);
				student = new Student();
				student.setStudentNo(nvl(row.getCell(0)));
				student.setName(nvl(row.getCell(1)));
				String gender = nvl(row.getCell(3)).equals("女") ? "0" : "1";
				student.setGender(gender);
				student.setDepartment(nvl(row.getCell(4)));
				student.setMajor(nvl(row.getCell(6)));
				student.setClasses(nvl(row.getCell(7)));
				student.setGrade(nvl(row.getCell(9)));
				student.setBirthdate(nvl(row.getCell(10)));
				student.setEmail(nvl(row.getCell(26)));
				student.setTelphone(nvl(row.getCell(27)));
				String score1 = nvl(row.getCell(118));
				String score2 = nvl(row.getCell(119));
				String score3 = nvl(row.getCell(120));
				String score4 = nvl(row.getCell(121));
				
				student.setScore1(parse2double(score1));
				student.setScore2(parse2double(score2));
				student.setScore3(parse2double(score3));
				student.setScore4(parse2double(score4));
				
				//创建一个用户
				user = new User();
				user.setUsername("S"+student.getStudentNo());
				user.setPassword(MD5Utils.getMD5(student.getStudentNo().getBytes()));
				user.setType("1");
				user.setState("0");
				//插入数据到user表
				if(userDao.add(user) > 0){
					student.setUserId(user.getId());
					studentDao.add(student);
				}
			}
		} catch(DataAccessException e){
			log.info(e);
			throw new BusinessException("添加学生:"+student.getName()+",学号:"+student.getStudentNo()+"时出错！可能是学号号已存在!");
		} catch (FileNotFoundException e) {
			log.info(e);
			throw new BusinessException("找不到文件![file:"+uploadFile.getAbsolutePath()+"]");
		} catch (IOException e) {
			log.info(e);
			throw new BusinessException("文件读取异常");
		}  
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<Student> query(Student student, boolean join)
			throws BusinessException {
		return this.studentDao.query(student, join);
	}

	private double parse2double(String something){
		if(StringUtils.isNotBlank(something)){
			if(something.matches("\\d+")){
				return Double.parseDouble(something);
			}
		}
		return 0d;
	}
	
	private String nvl(Object o){
		if(null != o){
			return o.toString();
		}
		return "";
	}
	
	@Override
	public List<Student> queryStudentWhichNoQuestion() throws BusinessException {
		return this.studentDao.queryStudentWhichNoQuestion();
	}

}
