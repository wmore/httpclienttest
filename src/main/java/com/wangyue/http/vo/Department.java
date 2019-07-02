package com.wangyue.http.vo;

public class Department {

    String id;
    String bmh;
    String departmentName;
    String departmentNo;


    public Department(String id, String bmh, String departmentName, String departmentNo) {
        this.id = id;
        this.bmh = bmh;
        this.departmentName = departmentName;
        this.departmentNo = departmentNo;
    }

    public Department() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBmh() {
        return bmh;
    }

    public void setBmh(String bmh) {
        this.bmh = bmh;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(String departmentNo) {
        this.departmentNo = departmentNo;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", bmh='" + bmh + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentNo='" + departmentNo + '\'' +
                '}';
    }
}
