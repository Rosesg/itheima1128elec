package com.yuantek.elec.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 11602 on 2017/8/26.
 */
public class ElecTest implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 6789415717451044185L;

    private String testID;

    private String testName;

    private Date testDate;

    private String testRemark;

    public String getTestID() {
        return testID;
    }

    public void setTestID(String testID) {
        this.testID = testID;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getTestRemark() {
        return testRemark;
    }

    public void setTestRemark(String testRemark) {
        this.testRemark = testRemark;
    }
}
