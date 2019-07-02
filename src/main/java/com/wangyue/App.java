package com.wangyue;


import com.wangyue.db.dao.StudentDao;
import com.wangyue.db.model.TStudent;
import com.wangyue.db.service.StudentService;
import com.wangyue.http.parser.*;
import com.wangyue.http.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
@SpringBootApplication
public class App  implements CommandLineRunner {

    @Autowired
    private StudentParser studentParser;

    @Resource
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner=null;
        try {
            scanner =new Scanner(System.in);

            while(true){
                System.out.println("请选择(Y开始同步数据、N退出):");

                String input =scanner.nextLine().trim();
                if(input.equalsIgnoreCase("N")){
                    System.out.println("程序退出..");
                    return  ;
                }
                if(input.equalsIgnoreCase("Y")){
                    System.out.println("开始同步数据..");
                    syncData();
                    return;
                }
            }

        } finally{
            if(scanner!=null){
                scanner.close();
            }
        }

    }


    public void syncData() {

//        String filePath = "src/main/resources/httpdata/GetDepartment.xml";
//        DepartmentParser departmentParser = new DepartmentParser();
//        List<Department> list = departmentParser.listNodes(departmentParser.initDepartmentFromXmlFile(filePath));
//        for (Department d: list) {
//            System.out.println(d);
//        }

//        StudentDao studentDao = new StudentDao();

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
            tStudent.setAcdemyId("1");
            tStudent.setClassId(s.getClassNO());
            tStudent.setSpecialtyId(s.getSpecialID());
            tStudents.add(tStudent);
            System.out.println(tStudent);
        }
        studentService.saveAll(tStudents);
//        studentDao.batchSaveStudentS(tStudents);

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
