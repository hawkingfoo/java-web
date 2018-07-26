package com.hawkingfoo.dao;

import com.hawkingfoo.ApplicationTest;
import com.hawkingfoo.model.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ApplicationTest.class, DataSourceAutoConfiguration.class})
public class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testInsert() {
        Student stu = new Student("a", 0, "x");
        studentMapper.insert(stu);

        List<Student> studentList = studentMapper.selectAll();
        Assert.assertEquals(1, studentList.size());
    }

    @Test
    public void testBatchInsert() {
        Student s1 = new Student("a", 0, "x");
        Student s2 = new Student("b", 0, "y");
        Student s3 = new Student("c", 0, "z");
        List<Student> list = Arrays.asList(s1, s2, s3);
        studentMapper.batchInsert(list);

        List<Student> studentList = studentMapper.selectAll();
        Assert.assertEquals(3, studentList.size());

        studentMapper.batchDelete(studentList);
        studentList = studentMapper.selectAll();
        Assert.assertEquals(0, studentList.size());
    }
}
