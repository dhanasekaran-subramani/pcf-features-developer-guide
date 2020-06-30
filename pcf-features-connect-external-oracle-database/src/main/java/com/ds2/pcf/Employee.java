package com.ds2.pcf;

import lombok.Data;

@Data
public class Employee {
    private int empno;
    private String ename;
    private String job;
    private String mgr;
    private String hiredate;
    private int comm;
    private int deptno;
}
