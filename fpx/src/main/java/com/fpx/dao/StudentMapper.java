package com.fpx.dao;

import com.fpx.domain.Student;

import java.io.IOException;
import java.util.List;

/**
 * @author qfc
 */
public interface StudentMapper   {
    public List<Student> findAll()throws IOException;

    public Student findById(int id);

}
