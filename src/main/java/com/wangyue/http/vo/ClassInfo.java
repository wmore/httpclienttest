package com.wangyue.http.vo;

public class ClassInfo {

    String departmentID;
    String departmentNO;
    String departmentName;
    String classNO;
    String specialID;
    String specialName;
    String eduYear;
    String memberNum;
    String location;
    String eduType;

    public ClassInfo() {
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentNO() {
        return departmentNO;
    }

    public void setDepartmentNO(String departmentNO) {
        this.departmentNO = departmentNO;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getClassNO() {
        return classNO;
    }

    public void setClassNO(String classNO) {
        this.classNO = classNO;
    }

    public String getSpecialID() {
        return specialID;
    }

    public void setSpecialID(String specialID) {
        this.specialID = specialID;
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    public String getEduYear() {
        return eduYear;
    }

    public void setEduYear(String eduYear) {
        this.eduYear = eduYear;
    }

    public String getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(String memberNum) {
        this.memberNum = memberNum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEduType() {
        return eduType;
    }

    public void setEduType(String eduType) {
        this.eduType = eduType;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "departmentID='" + departmentID + '\'' +
                ", departmentNO='" + departmentNO + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", classNO='" + classNO + '\'' +
                ", specialID='" + specialID + '\'' +
                ", specialName='" + specialName + '\'' +
                ", eduYear='" + eduYear + '\'' +
                ", memberNum='" + memberNum + '\'' +
                ", location='" + location + '\'' +
                ", eduType='" + eduType + '\'' +
                '}';
    }
}
