package com.wangyue.http.vo;

public class Teacher {

    String departmentID;
    String departmentName;
    String teacherNO;
    String teacherName;
    String identityNO;
    String degree;
    String rank;
    String resume;
    String email;

    public Teacher() {
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

    public String getTeacherNO() {
        return teacherNO;
    }

    public void setTeacherNO(String teacherNO) {
        this.teacherNO = teacherNO;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getIdentityNO() {
        return identityNO;
    }

    public void setIdentityNO(String identityNO) {
        this.identityNO = identityNO;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "departmentID='" + departmentID + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", teacherNO='" + teacherNO + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", identityNO='" + identityNO + '\'' +
                ", degree='" + degree + '\'' +
                ", rank='" + rank + '\'' +
                ", resume='" + resume + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
