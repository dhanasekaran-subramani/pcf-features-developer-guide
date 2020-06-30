package com.ds2.pcf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class OracleService
{
    @Autowired
    JdbcTemplate jdbcTemplate;
    // this is not used currently, can be referred in controller
    public List<Department> getAllDeps()
    {
        List<Department> departments = jdbcTemplate.query("select * from dept", new BeanPropertyRowMapper<Department>(Department.class));

        return departments;
    }

    // this is not used currently, can be referred in controller

    public List<Employee> getAllEmps()
    {
        List<Employee> employees = jdbcTemplate.query("select * from emp", new BeanPropertyRowMapper<Employee>(Employee.class));

        return employees;
    }

    public List<Map<String, Object>>  getAllMessages()
    {
        List<Map<String, Object>> resultSetList = jdbcTemplate.queryForList("select * from schema1.messages"); // schema.table name
        return resultSetList;
    }



}
