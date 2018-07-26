package com.hawkingfoo.dao;

import com.hawkingfoo.model.Student;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface StudentMapper {
    @Insert("INSERT INTO student (name, sex, addr) VALUES (#{name}, #{sex}, #{addr})")
    int insert(Student stu);

    @InsertProvider(type = Provider.class, method = "batchInsert")
    int batchInsert(List<Student> students);

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student selectById(@Param("id") int id);

    @DeleteProvider(type = Provider.class, method = "batchDelete")
    int batchDelete(List<Student> students);

    @Select("SELECT * FROM student")
    List<Student> selectAll();


    class Provider {
        /* 批量插入 */
        public String batchInsert(Map map) {
            List<Student> students = (List<Student>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO student (name,sex,addr) VALUES ");
            MessageFormat mf = new MessageFormat(
                    "(#'{'list[{0}].name}, #'{'list[{0}].sex}, #'{'list[{0}].addr})"
            );

            for (int i = 0; i < students.size(); i++) {
                sb.append(mf.format(new Object[] {i}));
                if (i < students.size() - 1)
                    sb.append(",");
            }
            return sb.toString();
        }

        /* 批量删除 */
        public String batchDelete(Map map) {
            List<Student> students = (List<Student>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM student WHERE id IN (");
            for (int i = 0; i < students.size(); i++) {
                sb.append("'").append(students.get(i).getId()).append("'");
                if (i < students.size() - 1)
                    sb.append(",");
            }
            sb.append(")");
            return sb.toString();
        }
    }
}
