package com.wangyue.http.parser;

import com.wangyue.http.vo.ClassInfo;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClassInfoParser extends BaseParser {

    /**
     * 遍历当前节点元素下面的所有(元素的)子节点
     *<?xml version="1.0" encoding="utf-8"?>
     *
     * <ClassTable>
     *   <Table1>
     *     <DepartmentID>25</DepartmentID>
     *     <DepartmentNO>W</DepartmentNO>
     *     <DepartmentName>科技学院</DepartmentName>
     *     <ClassNO>20104011</ClassNO>
     *     <SpecialID>162</SpecialID>
     *     <SpecialName>水利水电工程（科技）</SpecialName>
     *     <EduYear>4</EduYear>
     *     <MemberNum>45</MemberNum>
     *     <Location>中区</Location>
     *     <EduType>0</EduType>
     *   </Table1>
     * @param rootNode
     * @return
     */
    public List<ClassInfo> listNodes(Element rootNode) {
        List<ClassInfo> classInfoList = new ArrayList<>();
        Iterator it = rootNode.elementIterator();
        while (it.hasNext()) {
            Element table = (Element) it.next();
            ClassInfo classInfoData = new ClassInfo();
            Iterator itt = table.elementIterator();

            while (itt.hasNext()) {
                Element tableChild = (Element) itt.next();

                if (tableChild.getName().equals("DepartmentID")) {
                    classInfoData.setDepartmentID(tableChild.getText());
                } else if (tableChild.getName().equals("DepartmentNO")) {
                    classInfoData.setDepartmentNO(tableChild.getText());
                } else if (tableChild.getName().equals("DepartmentName")) {
                    classInfoData.setDepartmentName(tableChild.getText());
                } else if (tableChild.getName().equals("ClassNO")) {
                    classInfoData.setClassNO(tableChild.getText());
                } else if (tableChild.getName().equals("SpecialID")) {
                    classInfoData.setSpecialID(tableChild.getText());
                } else if (tableChild.getName().equals("SpecialName")) {
                    classInfoData.setSpecialName(tableChild.getText());
                } else if (tableChild.getName().equals("EduYear")) {
                    classInfoData.setEduYear(tableChild.getText());
                } else if (tableChild.getName().equals("MemberNum")) {
                    classInfoData.setMemberNum(tableChild.getText());
                } else if (tableChild.getName().equals("Location")) {
                    classInfoData.setLocation(tableChild.getText());
                }else if (tableChild.getName().equals("EduType")) {
                    classInfoData.setEduType(tableChild.getText());
                }
            }
            classInfoList.add(classInfoData);
        }

        return classInfoList;
    }

}
