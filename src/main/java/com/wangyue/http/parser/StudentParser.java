package com.wangyue.http.parser;

import com.wangyue.http.vo.Student;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentParser extends BaseParser {

    /**
     * 遍历当前节点元素下面的所有(元素的)子节点
     * <?xml version="1.0" encoding="utf-8"?>
     *
     * <StudentTable>
     * <Table1>
     * <DepartmentID>2</DepartmentID>
     * <DepartmentName>经济与管理学院</DepartmentName>
     * <StuID>136394</StuID>
     * <ClassNO>20101184</ClassNO>
     * <StuNO>2010118415</StuNO>
     * <StuName>赵圆圆</StuName>
     * <Grade>2010</Grade>
     * <Sex>女</Sex>
     * <Birthday>19920626</Birthday>
     * <PoliticalState>共青团员</PoliticalState>
     * <SpecialName>财务管理</SpecialName>
     * <SpecialID>30</SpecialID>
     * <Nation>汉族</Nation>
     * <IdentityNO>421022199206265468</IdentityNO>
     * <EduYear>2</EduYear>
     * <EduLever>专升本</EduLever>
     * <TestNO>12P111075000015</TestNO>
     * <StuPlace>湖北三峡职业技术学院</StuPlace>
     * <State>0</State>
     * </Table1>
     * </StudentTable>
     *
     * @param rootNode
     * @return
     */
    public List<Student> listNodes(Element rootNode) {
        List<Student> studentList = new ArrayList<>();
        Iterator it = rootNode.elementIterator();
        while (it.hasNext()) {
            Element table = (Element) it.next();
            Student studentData = new Student();
            Iterator itt = table.elementIterator();

            while (itt.hasNext()) {
                Element tableChild = (Element) itt.next();

                if (tableChild.getName().equals("DepartmentID")) {
                    studentData.setDepartmentID(tableChild.getText());
                } else if (tableChild.getName().equals("DepartmentName")) {
                    studentData.setDepartmentName(tableChild.getText());
                } else if (tableChild.getName().equals("StuID")) {
                    studentData.setStuID(tableChild.getText());
                } else if (tableChild.getName().equals("StuNO")) {
                    studentData.setStuNO(tableChild.getText());
                } else if (tableChild.getName().equals("ClassNO")) {
                    studentData.setClassNO(tableChild.getText());
                } else if (tableChild.getName().equals("StuName")) {
                    studentData.setStuName(tableChild.getText());
                } else if (tableChild.getName().equals("Grade")) {
                    studentData.setGrade(tableChild.getText());
                } else if (tableChild.getName().equals("Sex")) {
                    studentData.setSex(tableChild.getText());
                } else if (tableChild.getName().equals("Birthday")) {
                    studentData.setBirthday(tableChild.getText());
                } else if (tableChild.getName().equals("PoliticalState")) {
                    studentData.setPoliticalState(tableChild.getText());
                } else if (tableChild.getName().equals("SpecialName")) {
                    studentData.setSpecialName(tableChild.getText());
                } else if (tableChild.getName().equals("SpecialID")) {
                    studentData.setSpecialID(tableChild.getText());
                } else if (tableChild.getName().equals("Nation")) {
                    studentData.setNation(tableChild.getText());
                } else if (tableChild.getName().equals("IdentityNO")) {
                    studentData.setIdentityNO(tableChild.getText());
                } else if (tableChild.getName().equals("EduYear")) {
                    studentData.setEduYear(tableChild.getText());
                } else if (tableChild.getName().equals("EduLever")) {
                    studentData.setEduLever(tableChild.getText());
                } else if (tableChild.getName().equals("TestNO")) {
                    studentData.setTestNO(tableChild.getText());
                } else if (tableChild.getName().equals("StuPlace")) {
                    studentData.setStuPlace(tableChild.getText());
                } else if (tableChild.getName().equals("State")) {
                    studentData.setState(tableChild.getText());
                }
            }
            studentList.add(studentData);
        }

        return studentList;
    }

}
