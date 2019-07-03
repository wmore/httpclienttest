package com.wangyue.db.model;

import javax.persistence.*;


@Entity
//指定表名，指定唯一约束
@Table(name = "t_student", uniqueConstraints = {@UniqueConstraint(columnNames = {"studentId"})})
public class TStudent {

    @Id
    private String studentId;
    @Column
    private String grade;
    @Column
    private String idNumber;
    @Column
    private String name;
    // 1--男  2--女
    @Column
    private String sex;
    @Column
    private String studentNumber;
    @Column
    private String acdemyId;
    @Column
    private String classId;
    @Column
    private String specialtyId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getAcdemyId() {
        return acdemyId;
    }

    public void setAcdemyId(String acdemyId) {
        this.acdemyId = acdemyId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(String specialtyId) {
        this.specialtyId = specialtyId;
    }

    @Override
    public String toString() {
        return "TStudent{" +
                "studentId='" + studentId + '\'' +
                ", grade='" + grade + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", acdemyId='" + acdemyId + '\'' +
                ", classId='" + classId + '\'' +
                ", specialtyId='" + specialtyId + '\'' +
                '}';
    }
}
