package com.kepka.databaseoracle.Controllers;

import com.kepka.databaseoracle.services.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/getStudents")
    public String hello() {
        List<String> students = studentService.getAllStudent();
        StringBuilder builder = new StringBuilder();
        for (String student : students) {
            builder.append("Student: ").append(student).append("<br>");
        }
        builder.append("<select>\n");
        for (String student : students) {
            builder.append("<option value=\"volvo\">").append(student).append("</option>\n");
        }
        builder.append("</select>");
        return builder.toString();
    }
}
