package first_task_internship.spring_restfull_api.services;

import first_task_internship.spring_restfull_api.library.Response;
import first_task_internship.spring_restfull_api.models.entities.TodolistRequest;


public interface TodolistService {
    Response addTodolist(TodolistRequest request);
    Response getAllTodolist();
    Response getTodolistById(Long id);
    Response deleteTodolistById(Long id);
    Response getTodolistByTask(String task);
    Response getTodolistByStatus(String task);

    Response updateTodolistByID(Long id, TodolistRequest todolistRequest);
}
