package com.wangyue.db.model;

import javax.persistence.*;

/**
 * `classId` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '主键Id',
 * `className` varchar(40) CHARACTER SET utf8 NOT NULL COMMENT '班级名称',
 * `acdemyId` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '外键-所属院系id',
 * `planId` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '字段可不填',
 * `specialtyId` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '外键-所属专业id',
 */
@Entity
//指定表名，指定唯一约束
@Table(name = "t_class", uniqueConstraints = {@UniqueConstraint(columnNames = {"classId"})})
public class TClass {

    @Id
    private String classId;
    @Column
    private String className;
    @Column
    private String acdemyId;
    @Column
    private String planId;
    @Column
    private String specialtyId;

    public TClass() {
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAcdemyId() {
        return acdemyId;
    }

    public void setAcdemyId(String acdemyId) {
        this.acdemyId = acdemyId;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(String specialtyId) {
        this.specialtyId = specialtyId;
    }
}
