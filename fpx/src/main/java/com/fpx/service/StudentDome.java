package com.fpx.service;

import com.fpx.dao.StudentMapper;
import com.fpx.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author qfc
 */

public class StudentDome {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession session =sqlSessionFactory.openSession();
        StudentMapper studentMapper=session.getMapper(StudentMapper.class);
        List<Student> all=studentMapper.findAll();
        System.out.println(all);
        Student student =studentMapper.findById(1);
        System.out.println(student);

    }
}
