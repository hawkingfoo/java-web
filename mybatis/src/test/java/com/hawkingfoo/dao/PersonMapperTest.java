package com.hawkingfoo.dao;

import com.hawkingfoo.ApplicationTest;
import com.hawkingfoo.model.Person;
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
public class PersonMapperTest {
    @Autowired
    private PersonMapper personMapper;

    @Test
    public void testInsert() {
        Person person = new Person();
        person.setName("LiMing");
        person.setCities(Arrays.asList("Beijing", "Shanghai"));

        // insert
        personMapper.insert(person);

        List<Person> personList = personMapper.selectAll();
        Assert.assertEquals(1, personList.size());
    }
}
