package com.api.tasks.tasks;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

@Repository
public class tasksRepository {

    @Autowired
    JdbcTemplate jdbc;

   //Fetches all Tasks with all the columns
   // since the return type is List the RowMapper understands that it is the List of Objects
    public List<todo> getAllTasks() {

        return jdbc.query("SELECT * FROM todo_table;",new TaskRowMapper());

    }

    //Fetches only the task
    public List<String> getAlltodos()
    {
        List<String> todos=new ArrayList<>();
        todos.addAll(jdbc.queryForList("SELECT task FROM todo_table;",String.class));
        return  todos;
    }

   // Fetches all field of the corresponding ID
    public todo getAllDetails(int id) {
        todo task=jdbc.queryForObject("SELECT * FROM todo_table where todo_id=?;",new Object[]{id},new TaskRowMapper());
        return task;
    }


    // Insert a new Task
    public String addIndex(todo newTask){

        jdbc.update("INSERT INTO todo_table(task,mark_important)values(?,?);",newTask.getTasks(),newTask.getMark());
        return"data inserted Successfully";
    }

    //Update the Task
    public String UpdateTask(int id, todo edit) {
        jdbc.update("UPDATE  todo_table set task=? where todo_id=?;",edit.getTasks(),id);
        return "Updated Successfully";
    }

    //Update the Mark as Important
    public String UpdateImpo(todo impo, int id) {
        jdbc.update("UPDATE  todo_table set mark_important=? where todo_id=?;",impo.getMark(),id);
        return "Updated Successfully";
    }

    //Delete the Task
    public void DeleteTask(int id) {
        jdbc.update("DELETE FROM todo_table where todo_id=?;",id);
    }

  }
