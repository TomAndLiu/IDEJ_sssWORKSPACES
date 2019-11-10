package com.java.service;

import com.java.dao.EmployeeMapper;
import com.java.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liusigou
 * @create 2019--11--09--11:09
 */
@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    public Employee getEmp(int id){
        return employeeMapper.getEmp(id);
    }
}
