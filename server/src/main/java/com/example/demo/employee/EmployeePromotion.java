package com.example.demo.employee;

import javax.persistence.criteria.CriteriaBuilder;

public class EmployeePromotion {
    private Long employee;

    private Long howmuch;

    public EmployeePromotion(Long employee, Long howmuch) {
        this.employee = employee;
        this.howmuch = howmuch;
    }

    public EmployeePromotion() {
    }

    public Long getEmployee() {
        return employee;
    }

    public void setEmployee(Long employee) {
        this.employee = employee;
    }

    public Long getHowmuch() {
        return howmuch;
    }

    public void setHowmuch(Long howmuch) {
        this.howmuch = howmuch;
    }
}
