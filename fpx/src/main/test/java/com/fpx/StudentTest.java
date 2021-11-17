package com.fpx;

import com.fpx.mapper.StudentsMapper;
import com.fpx.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentTest {
    @Test
    public void test1() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session =sqlSessionFactory.openSession();
        StudentsMapper studentMapper=session.getMapper(StudentsMapper.class);

        //模拟条件student
        Student student=new Student();
       // student.setId(1);
        student.setUsername("xiaoliang");
        //student.setPassword("147369");
        //List<Student> studentlist=studentMapper.findByCondition(student);
        //模拟ids的数据
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);

        List<Student> studentlist1 = studentMapper.findByIds(ids);
        System.out.println(studentlist1);


    }
}
