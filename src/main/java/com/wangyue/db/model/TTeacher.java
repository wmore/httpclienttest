package com.wangyue.db.model;

import javax.persistence.*;

/**
 * CREATE TABLE `t_teacher` (
 * `teacherId` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '主键id',
 * `birthDay` date DEFAULT NULL COMMENT '生日',
 * `code` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '工号',
 * `description` varchar(2000) CHARACTER SET utf8 DEFAULT NULL COMMENT '教师描述--可不填',
 * `email` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '邮件',
 * `idNumber` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '身份证',
 * `name` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '姓名',
 * `post` int(11) DEFAULT NULL COMMENT '字段可不填',
 * `sex` varchar(11) CHARACTER SET utf8 DEFAULT NULL COMMENT '性别',
 * `status` int(11) NOT NULL COMMENT '字段可不填',
 * `telephoneNumber` varchar(11) CHARACTER SET utf8 DEFAULT NULL COMMENT '电话',
 * `departmentId` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '外键-所属系部id',
 * PRIMARY KEY (`teacherId`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
 */
@Entity
//指定表名，指定唯一约束
@Table(name = "t_teacher", uniqueConstraints = {@UniqueConstraint(columnNames = {"teacherId"})})
public class TTeacher {
    @Id
    private String teacherId;
    @Column
    private String birthDay;
    @Column
    private String code;
    @Column
    private String description;
    @Column
    private String email;
    @Column
    private String idNumber;
    @Column
    private String name;
    @Column
    private String post;
    @Column
    private String sex;
    @Column
    private String status;
    @Column
    private String telephoneNumber;
    @Column
    private String departmentId;

    public TTeacher() {
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
