package com.java.dao;

import com.java.entity.Employee;
import org.springframework.stereotype.Repository;

/**
 * @author liusigou
 * @create 2019--11--09--11:05
 */
@Repository
public interface EmployeeMapper {
    public Employee getEmp(int id);
}
