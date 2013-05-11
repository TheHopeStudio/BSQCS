/*
-- Query: SELECT * FROM QCS.menu
LIMIT 0, 1000

-- Date: 2013-05-12 00:37
*/
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (1,'0','11','教师管理','/teacherManager','2');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (2,'0','22','学生管理','/studentManager','2');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (3,'0','33','选题管理','/question','2');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (4,'0','44','名单管理','/namelist','2');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (5,'0','55','资料维护','/personal','2');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (6,'1','11','查询教师','/teacherManager/query.do','2');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (7,'0','1','首页','/user/index.do','2');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (8,'5','1','密码修改','/personal/modifyPassword.do','2');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (9,'4','1','导入教师信息','/namelist/toImportTeacher.do','2');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (10,'4','11','导入学生信息','/namelist/toImportStudent.do','2');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (11,'0','11','题目管理','/question','0');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (12,'0','22','学生管理','/studentManager','0');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (13,'0','33','资料维护','/personal','0');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (14,'11','11','出题','/question/newQuestion.do','0');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (15,'12','11','查询学生','/studentManager/studentList.do','0');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (17,'0','1','首页','/user/index.do','0');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (18,'13','22','密码修改','/personal/modifyPassword.do','0');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (19,'0','11','首页','/user/index.do','1');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (20,'0','22','个人资料','/personal','1');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (21,'0','33','查看成绩排名','/score','1');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (22,'20','11','查看个人信息','/personal/personalInfo.do','1');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (23,'20','22','密码修改','/personal/modifyPassword.do','1');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (24,'1','22','职务维护','/teacherManager/queryJob.do','2');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (27,'11','22','我的题目','/question/myQuestion.do','0');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (28,'3','11','题目审核','/question/toAudit.do','2');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (29,'3','22','选题时间管理','/question/choosingTime.do','2');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (30,'2','11','查看学生列表','/studentManager/studentList.do','2');
INSERT INTO `menu` (`id`,`parent_id`,`seq`,`title`,`uri`,`type`) VALUES (31,'3','33','导出选题结果','/question/toExportResult.do','2');
