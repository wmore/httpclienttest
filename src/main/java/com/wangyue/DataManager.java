package com.wangyue;

import com.wangyue.db.model.*;
import com.wangyue.db.service.*;
import com.wangyue.http.parser.*;
import com.wangyue.http.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

@Component
public class DataManager {

    @Resource
    private StudentParser studentParser;

    @Resource
    private DepartmentParser departmentParser;

    @Resource
    private SpecialInfoParser specialInfoParser;

    @Resource
    private ClassInfoParser classInfoParser;

    @Resource
    private StudentService studentService;

    @Resource
    private AcdemyService acdemyService;

    @Resource
    private SpecialtyService specialtyService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private ClassService classService;

    @Resource
    private TeacherService teacherService;

    @Resource
    private TeacherParser teacherParser;

    public void syncData() {

        clearAllTable();

        syncDepartmentTable();
        syncSpecialtyTable();
        syncClassTable();
        syncTeacherTable();
        syncStudentTable();



//        String filePath = "src/main/resources/httpdata/GetTeacher.xml";
//        TeacherParser teacherParser = new TeacherParser();
//        List<Teacher> list = teacherParser.listNodes(teacherParser.initDepartmentFromXmlFile(filePath));
//        for (Teacher t: list) {
//            System.out.println(t);
//        }

//        String filePath = "src/main/resources/httpdata/GetClassInfo.xml";
//        ClassInfoParser classInfoParser = new ClassInfoParser();
//        List<ClassInfo> list = classInfoParser.listNodes(classInfoParser.initDepartmentFromXmlFile(filePath));
//        for (ClassInfo c: list) {
//            System.out.println(c);
//        }

//        String filePath = "src/main/resources/httpdata/GetCourse.xml";
//        CourseParser courseParser = new CourseParser();
//        List<Course> list = courseParser.listNodes(courseParser.initDepartmentFromXmlFile(filePath));
//        for (Course c: list) {
//            System.out.println(c);
//        }


    }

    private void clearAllTable() {
        departmentService.removeAll();
        acdemyService.removeAll();
        specialtyService.removeAll();
        studentService.removeAll();
        teacherService.removeAll();
        classService.removeAll();
    }

    private void syncDepartmentTable() {
        String filePath = "src/main/resources/httpdata/GetDepartment.xml";
        List<Department> list = departmentParser.listNodes(departmentParser.initDepartmentFromXmlFile(filePath));
        List<TAcdemy> tAcdemyList = new ArrayList<>();
        List<TDepartment> tDepartmentList = new ArrayList<>();
        for (Department d : list) {
            TAcdemy tAcdemy = new TAcdemy();
            tAcdemy.setAcdemyId(d.getId());
            tAcdemy.setAcdemyName(d.getDepartmentName());
            tAcdemyList.add(tAcdemy);

            TDepartment tDepartment = new TDepartment();
            tDepartment.setDepartmentId(d.getId());
            tDepartment.setDepartmentName(d.getDepartmentName());
            tDepartmentList.add(tDepartment);
            System.out.println(d);
        }
        acdemyService.saveAll(tAcdemyList);
        departmentService.saveAll(tDepartmentList);
    }

    private void syncSpecialtyTable() {
        String filePath = "src/main/resources/httpdata/GetSpecialInfo.xml";
        List<SpecialInfo> list = specialInfoParser.listNodes(specialInfoParser.initDepartmentFromXmlFile(filePath));
        List<TSpecialty> tSpecialtyList = new ArrayList<>();
        for (SpecialInfo s : list) {
            System.out.println(s);
            TSpecialty tSpecialty = new TSpecialty();
            tSpecialty.setSpecialtyId(s.getSpecialID());
            tSpecialty.setAcdemyId(s.getDepartmentID());
            tSpecialty.setSpecialtyCode(s.getSpecialNO());
            tSpecialty.setSpecialtyName(s.getSpecialName());
            tSpecialtyList.add(tSpecialty);
        }
        specialtyService.saveAll(tSpecialtyList);
    }

    private void syncClassTable() {
        String filePath = "src/main/resources/httpdata/GetClassInfo.xml";
        List<ClassInfo> list = classInfoParser.listNodes(classInfoParser.initDepartmentFromXmlFile(filePath));
        List<TClass> tClassList = new ArrayList<>();
        for (ClassInfo c: list) {
            System.out.println(c);
            TClass tClass = new TClass();
            tClass.setClassId(c.getClassNO());
            tClass.setClassName(c.getClassNO());
            tClass.setSpecialtyId(c.getSpecialID());
            tClass.setAcdemyId(c.getDepartmentID());
            tClassList.add(tClass);
        }
        classService.saveAll(tClassList);
    }

    /**
     *     <DepartmentID>23</DepartmentID>
     *     <DepartmentName>水利与环境学院</DepartmentName>
     *     <TeacherNO>A015</TeacherNO>
     *     <TeacherName>陈新元</TeacherName>
     *     <IdentityNO>0</IdentityNO>
     *     <Degree>博士后</Degree>
     *     <Rank />
     *     <Resume>总监理工程师，长期从事工程设计施工监理的教学科研工作。 </Resume>
     *     <Email>0</Email>
     */
    private void syncTeacherTable() {
        String filePath = "src/main/resources/httpdata/GetTeacher.xml";
        List<Teacher> list = teacherParser.listNodes(teacherParser.initDepartmentFromXmlFile(filePath));
        List<TTeacher> tTeacherList = new ArrayList<>();
        for (Teacher t : list) {
            System.out.println(t);
            TTeacher tTeacher = new TTeacher();
            tTeacher.setDepartmentId(t.getDepartmentID());
            tTeacher.setCode(t.getTeacherNO());
            tTeacher.setName(t.getTeacherName());
            tTeacher.setIdNumber(t.getIdentityNO());
            tTeacher.setDescription(t.getResume());
            tTeacher.setEmail(t.getEmail());
            tTeacher.setTeacherId(t.getTeacherNO());
            tTeacher.setStatus("1");
            tTeacher.setSex("1");
            tTeacher.setBirthDay();
            tTeacher.setPost();
            tTeacher.setTelephoneNumber();
            tTeacherList.add(tTeacher);
        }
        teacherService.saveAll(tTeacherList);
    }


    private void syncStudentTable() {
        String filePath = "src/main/resources/httpdata/GetStudent2.xml";
        List<Student> list = studentParser.listNodes(studentParser.initDepartmentFromXmlFile(filePath));
        List<TStudent> tStudents = new ArrayList<>();
        for (Student s: list) {
//            System.out.println(s);
            TStudent tStudent = new TStudent();
            tStudent.setStudentId(s.getStuID());
            tStudent.setGrade(s.getGrade());
            tStudent.setIdNumber(s.getIdentityNO());
            tStudent.setName(s.getStuName());
            tStudent.setSex(s.getSex().equals("男")?"1":"2");
            tStudent.setStudentNumber(s.getStuNO());
            tStudent.setAcdemyId(s.getDepartmentID());
            tStudent.setClassId(s.getClassNO());
            tStudent.setSpecialtyId(s.getSpecialID());
            tStudents.add(tStudent);
            System.out.println(tStudent);
        }
        studentService.saveAll(tStudents);
    }

    private Map<String, String> getBirthInfoFromIDNumber(String  idNumber) {
            String birthday = "";
            String age = "";
            String sexCode = "";

            int year = Calendar.getInstance().get(Calendar.YEAR);
            char[] number = certificateNo.toCharArray();
            boolean flag = true;
            if (number.length == 15) {
                for (int x = 0; x < number.length; x++) {
                    if (!flag) return new HashMap<String, String>();
                    flag = Character.isDigit(number[x]);
                }
            } else if (number.length == 18) {
                for (int x = 0; x < number.length - 1; x++) {
                    if (!flag) return new HashMap<String, String>();
                    flag = Character.isDigit(number[x]);
                }
            }
            if (flag && certificateNo.length() == 15) {
                birthday = "19" + certificateNo.substring(6, 8) + "-"
                        + certificateNo.substring(8, 10) + "-"
                        + certificateNo.substring(10, 12);
                sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 3, certificateNo.length())) % 2 == 0 ? "F" : "M";
                age = (year - Integer.parseInt("19" + certificateNo.substring(6, 8))) + "";
            } else if (flag && certificateNo.length() == 18) {
                birthday = certificateNo.substring(6, 10) + "-"
                        + certificateNo.substring(10, 12) + "-"
                        + certificateNo.substring(12, 14);
                sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 4, certificateNo.length() - 1)) % 2 == 0 ? "F" : "M";
                age = (year - Integer.parseInt(certificateNo.substring(6, 10))) + "";
            }
            Map<String, String> map = new HashMap<String, String>();
            map.put("birthday", birthday);
            map.put("age", age);
            map.put("sexCode", sexCode);
            return map;
    }
}
