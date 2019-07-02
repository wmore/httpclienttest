package com.wangyue.http.parser;

import com.wangyue.http.vo.Teacher;
import org.dom4j.Element;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component
public class TeacherParser extends BaseParser {

    /**
     * 遍历当前节点元素下面的所有(元素的)子节点
     *<?xml version="1.0" encoding="utf-8"?>
     *
     * <TeacherTable>
     *   <Table1>
     *     <DepartmentID>23</DepartmentID>
     *     <DepartmentName>水利与环境学院</DepartmentName>
     *     <TeacherNO>A002</TeacherNO>
     *     <TeacherName>任德记</TeacherName>
     *     <IdentityNO>420500195106100076</IdentityNO>
     *     <Degree>无</Degree>
     *     <Rank />
     *     <Resume xml:space="preserve"></Resume>
     *     <Email>0</Email>
     *   </Table1>
     * @param rootNode
     * @return
     */
    public List<Teacher> listNodes(Element rootNode) {
        List<Teacher> teacherList = new ArrayList<>();
        Iterator it = rootNode.elementIterator();
        while (it.hasNext()) {
            Element table = (Element) it.next();
            Teacher teacherData = new Teacher();
            Iterator itt = table.elementIterator();

            while (itt.hasNext()) {
                Element tableChild = (Element) itt.next();

                if (tableChild.getName().equals("DepartmentID")) {
                    teacherData.setDepartmentID(tableChild.getText());
                } else if (tableChild.getName().equals("DepartmentName")) {
                    teacherData.setDepartmentName(tableChild.getText());
                } else if (tableChild.getName().equals("TeacherNO")) {
                    teacherData.setTeacherNO(tableChild.getText());
                } else if (tableChild.getName().equals("TeacherName")) {
                    teacherData.setTeacherName(tableChild.getText());
                } else if (tableChild.getName().equals("IdentityNO")) {
                    teacherData.setIdentityNO(tableChild.getText());
                } else if (tableChild.getName().equals("Degree")) {
                    teacherData.setDegree(tableChild.getText());
                } else if (tableChild.getName().equals("Resume")) {
                    teacherData.setResume(tableChild.getText());
                } else if (tableChild.getName().equals("Rank")) {
                    teacherData.setRank(tableChild.getText());
                } else if (tableChild.getName().equals("Email")) {
                    teacherData.setEmail(tableChild.getText());
                }
            }
            teacherList.add(teacherData);
        }

        return teacherList;
    }

}
