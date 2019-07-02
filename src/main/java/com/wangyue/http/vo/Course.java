package com.wangyue.http.vo;

public class Course {

    String CourseNO;
    String CourseName;
    String DepartmentID;
    String DepartmentName;

    public Course() {
    }

    public String getCourseNO() {
        return CourseNO;
    }

    public void setCourseNO(String courseNO) {
        CourseNO = courseNO;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(String departmentID) {
        DepartmentID = departmentID;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }


    @Override
    public String toString() {
        return "Course{" +
                "CourseNO='" + CourseNO + '\'' +
                ", CourseName='" + CourseName + '\'' +
                ", DepartmentID='" + DepartmentID + '\'' +
                ", DepartmentName='" + DepartmentName + '\'' +
                '}';
    }
}
