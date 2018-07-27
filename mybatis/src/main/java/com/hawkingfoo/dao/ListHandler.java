package com.hawkingfoo.dao;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@MappedTypes(value = List.class)
@MappedJdbcTypes(value = JdbcType.VARCHAR, includeNullJdbcType = true)
public class ListHandler extends BaseTypeHandler<List<String>> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i,
                                    List<String> config, JdbcType type) throws SQLException {
        preparedStatement.setString(i, JSON.toJSONString(config));
    }

    @Override
    public List<String> getNullableResult(
            ResultSet resultSet, String configStr) throws SQLException {
        return JSON.parseObject(resultSet.getString(configStr), List.class);
    }

    @Override
    public List<String> getNullableResult(
            ResultSet resultSet, int i) throws SQLException {
        return JSON.parseObject(resultSet.getString(i), List.class);
    }

    @Override
    public List<String> getNullableResult(
            CallableStatement resultSet, int i) throws SQLException {
        return JSON.parseObject(resultSet.getString(i), List.class);
    }
}
