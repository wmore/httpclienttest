package com.wangyue.manager;

import com.wangyue.db.model.*;
import com.wangyue.db.service.*;
import com.wangyue.http.parser.*;
import com.wangyue.http.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
        String filePath = "E:\\对接cas\\三峡大学\\httpdata\\GetDepartment.xml";
        List<Department> list = departmentParser.listNodes(departmentParser.initDepartmentFromXmlFile(filePath, "DepartmentTable"));
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
        List<SpecialInfo> list = specialInfoParser.listNodes(specialInfoParser.initDepartmentFromXmlFile(filePath,"SpecialTable"));
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
        List<ClassInfo> list = classInfoParser.listNodes(classInfoParser.initDepartmentFromXmlFile(filePath, "ClassTable"));
        List<TClass> tClassList = new ArrayList<>();
        for (ClassInfo c : list) {
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
     * <DepartmentID>23</DepartmentID>
     * <DepartmentName>水利与环境学院</DepartmentName>
     * <TeacherNO>A015</TeacherNO>
     * <TeacherName>陈新元</TeacherName>
     * <IdentityNO>0</IdentityNO>
     * <Degree>博士后</Degree>
     * <Rank />
     * <Resume>总监理工程师，长期从事工程设计施工监理的教学科研工作。 </Resume>
     * <Email>0</Email>
     */
    private void syncTeacherTable() {
        String filePath = "src/main/resources/httpdata/GetTeacher.xml";
        List<Teacher> list = teacherParser.listNodes(teacherParser.initDepartmentFromXmlFile(filePath, "TeacherTable"));
        List<TTeacher> tTeacherList = new ArrayList<>();
        for (Teacher t : list) {
            System.out.println(t);
            TTeacher tTeacher = new TTeacher();
            tTeacher.setDepartmentId(t.getDepartmentID());
            tTeacher.setCode(t.getTeacherNO());
            tTeacher.setName(t.getTeacherName());
            if (!StringUtils.isEmpty(t.getIdentityNO()) && t.getIdentityNO().length() < 20) {
                tTeacher.setIdNumber(t.getIdentityNO());
            } else {
                tTeacher.setIdNumber("");
            }
            if (!StringUtils.isEmpty(t.getResume()) && t.getResume().length() < 1000) {
                tTeacher.setDescription(t.getResume());
            }
            tTeacher.setEmail(t.getEmail());
            tTeacher.setTeacherId(t.getTeacherNO());
            Map<String, String> map = getBirthInfoFromIDNumber(t.getIdentityNO());
            if (map != null) {
                tTeacher.setSex(map.get("sexCode"));
                if (!StringUtils.isEmpty(map.get("birthday"))) {
                    tTeacher.setBirthDay(map.get("birthday"));
                }
            } else {
                tTeacher.setSex("1");
                tTeacher.setBirthDay(null);
            }
            tTeacher.setStatus("1");
            tTeacher.setPostByRank(t.getRank());
//            tTeacher.setTelephoneNumber();
            tTeacherList.add(tTeacher);
        }
        teacherService.saveAll(tTeacherList);
    }


    private void syncStudentTable() {
        String filePath = "src/main/resources/httpdata/GetStudent.xml";
        List<Student> list = studentParser.listNodes(studentParser.initDepartmentFromXmlFile(filePath, "StudentTable"));
        List<TStudent> tStudents = new ArrayList<>();
        for (Student s : list) {
//            System.out.println(s);
            TStudent tStudent = new TStudent();
            tStudent.setStudentId(s.getStuID());
            tStudent.setGrade(s.getGrade());
            tStudent.setIdNumber(s.getIdentityNO());
            tStudent.setName(s.getStuName());
            tStudent.setSex(s.getSex().equals("男") ? "1" : "2");
            tStudent.setStudentNumber(s.getStuNO());
            tStudent.setAcdemyId(s.getDepartmentID());
            tStudent.setClassId(s.getClassNO());
            tStudent.setSpecialtyId(s.getSpecialID());
            tStudents.add(tStudent);
            System.out.println(tStudent);
        }
        studentService.saveAll(tStudents);
    }

    private Map<String, String> getBirthInfoFromIDNumber(String idNumber) {
        if (StringUtils.isEmpty(idNumber)) {
            return null;
        }
        String birthday = "";
        String age = "";
        String sexCode = "";

        int year = Calendar.getInstance().get(Calendar.YEAR);
        char[] number = idNumber.toCharArray();
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
        if (flag && idNumber.length() == 15) {
            birthday = "19" + idNumber.substring(6, 8) + "-"
                    + idNumber.substring(8, 10) + "-"
                    + idNumber.substring(10, 12);
            sexCode = Integer.parseInt(idNumber.substring(idNumber.length() - 3, idNumber.length())) % 2 == 0 ? "2" : "1";
            age = (year - Integer.parseInt("19" + idNumber.substring(6, 8))) + "";
        } else if (flag && idNumber.length() == 18) {
            birthday = idNumber.substring(6, 10) + "-"
                    + idNumber.substring(10, 12) + "-"
                    + idNumber.substring(12, 14);
            sexCode = Integer.parseInt(idNumber.substring(idNumber.length() - 4, idNumber.length() - 1)) % 2 == 0 ? "2" : "1";
            age = (year - Integer.parseInt(idNumber.substring(6, 10))) + "";
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("birthday", birthday);
        map.put("age", age);
        map.put("sexCode", sexCode);
        return map;
    }

}
