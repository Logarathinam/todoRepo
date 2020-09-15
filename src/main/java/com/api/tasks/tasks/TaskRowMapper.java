package com.api.tasks.tasks;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper implements RowMapper<todo> {
    @Override
    public todo mapRow(ResultSet resultSet, int i) throws SQLException {
        todo t=new todo();
        t.setId(resultSet.getInt("todo_id"));
        t.setTasks(resultSet.getString("task"));
        t.setMark(resultSet.getString("mark_important"));
        return t;
    }
}
