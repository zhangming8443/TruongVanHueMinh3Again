package com.example.ss10.service;

import com.example.ss10.model.Student;
import com.example.ss10.repository.IStudentRepo;
import com.example.ss10.repository.StudentRepo;

import java.util.List;

public class StudentService implements IStudentService{
    private final IStudentRepo studentRepo = new StudentRepo();
    @Override
    public List<Student> display() {
        return studentRepo.display();
    }
}
