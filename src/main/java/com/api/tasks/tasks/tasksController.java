package com.api.tasks.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class tasksController {
    @Autowired
    tasksRepository repo;

    @RequestMapping("/hello")
    public String sayHello()
    {
        return "Hello,World";
    }

    //Get all
    @RequestMapping("/getAll")
    public List<todo> getAll()
        {
            return repo.getAllTasks();
        }

    //Getting only the tasks
    @RequestMapping("/getTodo")
    public List<String> getAllTasks(){
        return repo.getAlltodos();
    }

   //Get a Particular Task
    @RequestMapping("/getDetails/{id}")
    public todo getDetails(@PathVariable("id") int id)
    {
       return repo.getAllDetails(id);
    }

    //Inserting a task into the Database
    @PostMapping("/AddTask")
    public void addTask(@RequestBody todo newTask)
    {
        repo.addIndex(newTask);
    }

    //Updating the task
    @PutMapping("/editTask/{id}")
    public void editTask(@RequestBody todo edit,@PathVariable("id") int id)
    {
       repo.UpdateTask(id,edit);
    }

    //Updating the Mark As Important
    @PutMapping("/editImpo/{id}")
    public void editImpo(@RequestBody todo impo,@PathVariable("id") int id)
    {
        repo.UpdateImpo(impo,id);
    }

    //Deleting the task
    @DeleteMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable("id") int id)
    {
        repo.DeleteTask(id);
    }


}
