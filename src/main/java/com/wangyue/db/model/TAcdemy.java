package com.wangyue.db.model;

import javax.persistence.*;


@Entity
//指定表名，指定唯一约束
@Table(name = "t_acdemy", uniqueConstraints = {@UniqueConstraint(columnNames = {"acdemyId"})})
public class TAcdemy {

    @Id
    private String acdemyId;
    @Column
    private String acdemyName;

    public TAcdemy() {
    }

    public String getAcdemyId() {
        return acdemyId;
    }

    public void setAcdemyId(String acdemyId) {
        this.acdemyId = acdemyId;
    }

    public String getAcdemyName() {
        return acdemyName;
    }

    public void setAcdemyName(String acdemyName) {
        this.acdemyName = acdemyName;
    }
}
