package com.SpringCourse.service;

import com.SpringCourse.client.IStudentClient;
import com.SpringCourse.controller.dto.StudentDTO;
import com.SpringCourse.entities.Course;
import com.SpringCourse.http.response.StudentByCourseResponse;
import com.SpringCourse.persistence.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private IStudentClient studentClient;
    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {

        Course course = courseRepository.findById(idCourse).orElse(new Course());

        List<StudentDTO> studentsDTOList = studentClient.getAllStudentsByCourse(idCourse);
        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentsDTOList(studentsDTOList)
                .build();

    }
}
