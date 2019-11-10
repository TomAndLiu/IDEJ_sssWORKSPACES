package com.java.controller;

import com.java.entity.Employee;
import com.java.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author liusigou
 * @create 2019--11--09--10:40
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/getEmp")
    public String getEmp(HttpServletRequest request){
        System.out.println("controller");
        HttpSession session = request.getSession();
        Employee emp = employeeService.getEmp(1);
        session.setAttribute("emp",emp);
        System.out.println("emp = " + emp);
        return "success";
    }
}
