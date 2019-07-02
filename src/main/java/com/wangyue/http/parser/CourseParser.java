package com.wangyue.http.parser;

import com.wangyue.http.vo.Course;
import org.dom4j.Element;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component
public class CourseParser extends BaseParser {

    /**
     * 遍历当前节点元素下面的所有(元素的)子节点
     *<?xml version="1.0" encoding="utf-8"?>
     *
     * <CourseTable>
     * 	<Table1>
     * 		<CourseNO>Y0001</CourseNO>
     * 		<CourseName>马克思主义基本原理</CourseName>
     * 		<DepartmentID>56</DepartmentID>
     * 		<DepartmentName>马克思主义学院</DepartmentName>
     * 	</Table1>
     * @param rootNode
     * @return
     */
    public List<Course> listNodes(Element rootNode) {
        List<Course> courseList = new ArrayList<>();
        Iterator it = rootNode.elementIterator();
        while (it.hasNext()) {
            Element table = (Element) it.next();
            Course courseData = new Course();
            Iterator itt = table.elementIterator();

            while (itt.hasNext()) {
                Element tableChild = (Element) itt.next();

                if (tableChild.getName().equals("CourseNO")) {
                    courseData.setCourseNO(tableChild.getText());
                } else if (tableChild.getName().equals("CourseName")) {
                    courseData.setCourseName(tableChild.getText());
                } else if (tableChild.getName().equals("DepartmentID")) {
                    courseData.setDepartmentID(tableChild.getText());
                } else if (tableChild.getName().equals("DepartmentName")) {
                    courseData.setDepartmentName(tableChild.getText());
                }
            }
            courseList.add(courseData);
        }

        return courseList;
    }

}
