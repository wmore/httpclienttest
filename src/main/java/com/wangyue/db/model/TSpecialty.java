package com.wangyue.db.model;

import javax.persistence.*;


@Entity
//指定表名，指定唯一约束
@Table(name = "t_specialty", uniqueConstraints = {@UniqueConstraint(columnNames = {"specialtyId"})})
public class TSpecialty {

    @Id
    private String specialtyId;
    @Column
    private String specialtyCode;
    @Column
    private String specialtyName;
    @Column
    private String acdemyId;

    public TSpecialty() {
    }

    public String getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(String specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getSpecialtyCode() {
        return specialtyCode;
    }

    public void setSpecialtyCode(String specialtyCode) {
        this.specialtyCode = specialtyCode;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public String getAcdemyId() {
        return acdemyId;
    }

    public void setAcdemyId(String acdemyId) {
        this.acdemyId = acdemyId;
    }
}
