package com.sam.jsonApp;

import java.time.LocalDateTime;
import java.util.Date;

public class JsonObjects {

    String _id;
    String createdOn;
    String updatedOn;
    Float []vcModelVisitor;
    Float [] vcModelNonVisitor1;
    Float [] vcModelNonVisitor2;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Float[] getVcModelVisitor() {
        return vcModelVisitor;
    }

    public void setVcModelVisitor(Float[] vcModelVisitor) {
        this.vcModelVisitor = vcModelVisitor;
    }

    public Float[] getVcModelNonVisitor1() {
        return vcModelNonVisitor1;
    }

    public void setVcModelNonVisitor1(Float[] vcModelNonVisitor1) {
        this.vcModelNonVisitor1 = vcModelNonVisitor1;
    }

    public Float[] getVcModelNonVisitor2() {
        return vcModelNonVisitor2;
    }

    public void setVcModelNonVisitor2(Float[] vcModelNonVisitor2) {
        this.vcModelNonVisitor2 = vcModelNonVisitor2;
    }
}
