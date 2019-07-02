package com.wangyue.http.vo;

public class Student {
    private String departmentID;
    private String departmentName;
    private String stuID;
    private String classNO;
    private String stuNO;
    private String stuName;
    private String grade;
    private String sex;
    private String birthday;
    private String politicalState;
    private String specialName;
    private String specialID;
    private String nation;
    private String identityNO;
    private String eduYear;
    private String eduLever;
    private String testNO;
    private String stuPlace;
    private String state;

    public Student() {
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getClassNO() {
        return classNO;
    }

    public void setClassNO(String classNO) {
        this.classNO = classNO;
    }

    public String getStuNO() {
        return stuNO;
    }

    public void setStuNO(String stuNO) {
        this.stuNO = stuNO;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPoliticalState() {
        return politicalState;
    }

    public void setPoliticalState(String politicalState) {
        this.politicalState = politicalState;
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    public String getSpecialID() {
        return specialID;
    }

    public void setSpecialID(String specialID) {
        this.specialID = specialID;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getIdentityNO() {
        return identityNO;
    }

    public void setIdentityNO(String identityNO) {
        this.identityNO = identityNO;
    }

    public String getEduYear() {
        return eduYear;
    }

    public void setEduYear(String eduYear) {
        this.eduYear = eduYear;
    }

    public String getEduLever() {
        return eduLever;
    }

    public void setEduLever(String eduLever) {
        this.eduLever = eduLever;
    }

    public String getTestNO() {
        return testNO;
    }

    public void setTestNO(String testNO) {
        this.testNO = testNO;
    }

    public String getStuPlace() {
        return stuPlace;
    }

    public void setStuPlace(String stuPlace) {
        this.stuPlace = stuPlace;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Student{" +
                "departmentID='" + departmentID + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", stuID='" + stuID + '\'' +
                ", classNO='" + classNO + '\'' +
                ", stuNO='" + stuNO + '\'' +
                ", stuName='" + stuName + '\'' +
                ", grade='" + grade + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", politicalState='" + politicalState + '\'' +
                ", specialName='" + specialName + '\'' +
                ", specialID='" + specialID + '\'' +
                ", nation='" + nation + '\'' +
                ", identityNO='" + identityNO + '\'' +
                ", eduYear='" + eduYear + '\'' +
                ", eduLever='" + eduLever + '\'' +
                ", testNO='" + testNO + '\'' +
                ", stuPlace='" + stuPlace + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
