package com.fpx.mapper;

import com.fpx.domain.Student;

import java.util.List;

public interface StudentsMapper {
    public List<Student> findByCondition(Student student);

    public List<Student> findByIds(List<Integer> ids);

}
