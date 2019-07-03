package com.wangyue.db.model;

import javax.persistence.*;


@Entity
//指定表名，指定唯一约束
@Table(name = "t_department", uniqueConstraints = {@UniqueConstraint(columnNames = {"departmentId"})})
public class TDepartment {

    @Id
    private String departmentId;
    @Column
    private String departmentName;
    @Column
    private String parentId;

    public TDepartment() {
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
