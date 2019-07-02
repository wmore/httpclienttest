package com.wangyue.http.vo;

public class SpecialInfo {

    String DepartmentID;
    String DepartmentNO;
    String DepartmentName;
    String SpecialID;
    String SpecialNO;
    String SpecialName;

    public SpecialInfo() {
    }

    public String getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(String departmentID) {
        DepartmentID = departmentID;
    }

    public String getDepartmentNO() {
        return DepartmentNO;
    }

    public void setDepartmentNO(String departmentNO) {
        DepartmentNO = departmentNO;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public String getSpecialID() {
        return SpecialID;
    }

    public void setSpecialID(String specialID) {
        SpecialID = specialID;
    }

    public String getSpecialNO() {
        return SpecialNO;
    }

    public void setSpecialNO(String specialNO) {
        SpecialNO = specialNO;
    }

    public String getSpecialName() {
        return SpecialName;
    }

    public void setSpecialName(String specialName) {
        SpecialName = specialName;
    }

    @Override
    public String toString() {
        return "SpecialInfo{" +
                "DepartmentID='" + DepartmentID + '\'' +
                ", DepartmentNO='" + DepartmentNO + '\'' +
                ", DepartmentName='" + DepartmentName + '\'' +
                ", SpecialID='" + SpecialID + '\'' +
                ", SpecialNO='" + SpecialNO + '\'' +
                ", SpecialName='" + SpecialName + '\'' +
                '}';
    }
}
