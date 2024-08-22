package com.example.jparelation.Service;

import com.example.jparelation.ApiException.ApiException;
import com.example.jparelation.Model.Teacher;
import com.example.jparelation.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();

    }
    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Teacher teacher, Integer id ) {
        Teacher  teacher1 = teacherRepository.findTeacherById(id);
        if(teacher1 == null) {
            throw new ApiException("Teacher not found");
        }
        teacher1.setName(teacher.getName());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setSalary(teacher.getSalary());
        teacherRepository.save(teacher1);
    }
    public void deleteTeacher(Integer id) {
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if(teacher1 == null) {
            throw new ApiException("Teacher not found");
        }
        teacherRepository.delete(teacher1);
    }
    public Teacher getTeacherDetails(Integer id) {
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if(teacher1 == null) {
            throw new ApiException("Teacher not found");

        }
        return teacher1;
}}
