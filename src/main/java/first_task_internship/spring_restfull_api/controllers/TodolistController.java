package first_task_internship.spring_restfull_api.controllers;

import first_task_internship.spring_restfull_api.library.Response;
import first_task_internship.spring_restfull_api.models.entities.Todolist;
import first_task_internship.spring_restfull_api.models.entities.TodolistRequest;
import first_task_internship.spring_restfull_api.services.TodolistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todolist")
public class TodolistController {

    @Autowired
    private TodolistServiceImpl todolistService;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping
    public ResponseEntity<?> addTodolist(@RequestBody TodolistRequest todolistRequest) {
        try {
            Response response = todolistService.addTodolist(todolistRequest);
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/search")
    public ResponseEntity<?> getTodolistByTask(@RequestBody TodolistRequest todolistRequest) {
        try {
            Response response = todolistService.getTodolistByTask(todolistRequest.getTask());
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/filter")
    public ResponseEntity<?> getTodolistByStatus(@RequestBody TodolistRequest todolistRequest) {
        try {
            Response response = todolistService.getTodolistByStatus(todolistRequest.getStatus());
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<?> getTodolist() {
        try {
            Response response = todolistService.getAllTodolist();
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getTodolistById(@PathVariable("id") Long id) {
        try {
            Response response = todolistService.getTodolistById(id);
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodolist(@PathVariable("id") Long id, @RequestBody TodolistRequest todolistRequest) {
        try {
            Response response = todolistService.updateTodolistByID(id,todolistRequest);
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodolist(@PathVariable("id") Long id) {
        try {
            Response response = todolistService.deleteTodolistById(id);
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}
