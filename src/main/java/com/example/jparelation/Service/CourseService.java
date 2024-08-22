package com.example.jparelation.Service;

import com.example.jparelation.ApiException.ApiException;
import com.example.jparelation.Model.Course;
import com.example.jparelation.Model.Teacher;
import com.example.jparelation.Repository.CourseRepository;
import com.example.jparelation.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();

    }
    public void assingTeacherToCourse(Integer courseId, Integer teacherId) {
        Course course = courseRepository.findByCourseId(courseId);
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        course.setName(course.getName());
        course.setTeacher(teacher);
    }
    public void updateCourse(Integer id , Course course) {
        Course course1 = courseRepository.findByCourseId(id);
        if (course1 == null) {
            throw new ApiException("course not found");
        }
        course1.setName(course.getName());
        courseRepository.save(course1);
    }
    public void deleteCourse(Integer id) {
        Course course = courseRepository.findByCourseId(id);
        if (course == null) {
            throw new ApiException("course not found");
        }
        courseRepository.delete(course);
    }
    public Course getTeacherNameByCourseId(Integer courseId) {
        Course course = courseRepository.findByCourseId(courseId);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        return course;





}}
