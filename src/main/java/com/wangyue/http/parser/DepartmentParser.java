package com.wangyue.http.parser;

import com.wangyue.http.vo.Department;
import org.dom4j.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component
public class DepartmentParser extends BaseParser {

    /**
     * 遍历当前节点元素下面的所有(元素的)子节点
     *<?xml version="1.0" encoding="utf-8"?>
     *
     * <DepartmentTable>
     *   <Table1>
     *     <ID>2</ID>
     *     <BMH>206</BMH>
     *     <DepartmentName>经济与管理学院</DepartmentName>
     *     <DepartmentNO>D</DepartmentNO>
     *   </Table1>
     * @param rootNode
     * @return
     */
    public List<Department> listNodes(Element rootNode) {
        List<Department> departmentList = new ArrayList<>();
//        Element departmentElement = rootNode.element("DepartmentTable");
        Iterator it = rootNode.elementIterator();
        while (it.hasNext()) {
            Element table = (Element) it.next();
            Department departmentData = new Department();
            Iterator itt = table.elementIterator();

            while (itt.hasNext()) {
                Element tableChild = (Element) itt.next();

                if (tableChild.getName().equals("ID")) {
                    departmentData.setId(tableChild.getText());
                } else if (tableChild.getName().equals("BMH")) {
                    departmentData.setBmh(tableChild.getText());
                } else if (tableChild.getName().equals("DepartmentName")) {
                    departmentData.setDepartmentName(tableChild.getText());
                } else if (tableChild.getName().equals("DepartmentNO")) {
                    departmentData.setDepartmentNo(tableChild.getText());
                }
            }
            departmentList.add(departmentData);
        }

        return departmentList;
    }

}
