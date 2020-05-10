package com.example.demo.employee;

import javax.persistence.criteria.CriteriaBuilder;

public class EmployeePromotion {
    private long employee;

    private long howmuch;

    public EmployeePromotion(long employee, long howmuch) {
        this.employee = employee;
        this.howmuch = howmuch;
    }

    public EmployeePromotion() {
    }

    public long getEmployee() {
        return employee;
    }

    public void setEmployee(long employee) {
        this.employee = employee;
    }

    public long getHowmuch() {
        return howmuch;
    }

    public void setHowmuch(long howmuch) {
        this.howmuch = howmuch;
    }
}
