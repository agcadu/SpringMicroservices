package com.SpringCourse.client;

import com.SpringCourse.controller.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-student", url = "localhost:8080/api/students")
public interface IStudentClient {

    @GetMapping("/search-course/{idCourse}")
    List<StudentDTO> getAllStudentsByCourse(@PathVariable Long idCourse);
}
