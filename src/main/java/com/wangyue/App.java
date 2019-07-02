package com.wangyue;


import com.wangyue.db.dao.StudentDao;
import com.wangyue.db.model.TStudent;
import com.wangyue.http.parser.*;
import com.wangyue.http.vo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        String filePath = "src/main/resources/httpdata/GetDepartment.xml";
//        DepartmentParser departmentParser = new DepartmentParser();
//        List<Department> list = departmentParser.listNodes(departmentParser.initDepartmentFromXmlFile(filePath));
//        for (Department d: list) {
//            System.out.println(d);
//        }

        StudentDao studentDao = new StudentDao();

        String filePath = "src/main/resources/httpdata/GetStudent.xml";
        StudentParser studentParser = new StudentParser();
        List<Student> list = studentParser.listNodes(studentParser.initDepartmentFromXmlFile(filePath));
        List<TStudent> tStudents = new ArrayList<>();
        for (Student s: list) {
            System.out.println(s);
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
        }
        studentDao.batchSaveStudentS(tStudents);

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

//        String filePath = "src/main/resources/httpdata/GetSpecialInfo.xml";
//        SpecialInfoParser specialInfoParser = new SpecialInfoParser();
//        List<SpecialInfo> list = specialInfoParser.listNodes(specialInfoParser.initDepartmentFromXmlFile(filePath));
//        for (SpecialInfo s: list) {
//            System.out.println(s);
//        }
    }


}
