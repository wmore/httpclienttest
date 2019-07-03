package com.wangyue;

import com.wangyue.db.model.TAcdemy;
import com.wangyue.db.model.TClass;
import com.wangyue.db.model.TDepartment;
import com.wangyue.db.model.TSpecialty;
import com.wangyue.db.service.*;
import com.wangyue.http.parser.ClassInfoParser;
import com.wangyue.http.parser.DepartmentParser;
import com.wangyue.http.parser.SpecialInfoParser;
import com.wangyue.http.parser.StudentParser;
import com.wangyue.http.vo.ClassInfo;
import com.wangyue.http.vo.Department;
import com.wangyue.http.vo.SpecialInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    public void syncData() {

        clearAllTable();

        syncDepartmentTable();
        syncSpecialtyTable();
        syncClassTable();


     /*   String filePath = "src/main/resources/httpdata/GetStudent2.xml";
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
            tStudent.setAcdemyId("1");
            tStudent.setClassId(s.getClassNO());
            tStudent.setSpecialtyId(s.getSpecialID());
            tStudents.add(tStudent);
            System.out.println(tStudent);
        }
        studentService.saveAll(tStudents);*/

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

}
