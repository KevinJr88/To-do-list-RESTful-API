package first_task_internship.spring_restfull_api.services;

import first_task_internship.spring_restfull_api.library.Response;
import first_task_internship.spring_restfull_api.models.entities.TodolistRequest;


public interface TodolistService {
    Response addTodolist(TodolistRequest request);
    Response getAllTodolist();
    Response getTodolistById(Long id);
    Response deleteTodolistById(Long id);

    Response updateTodolistByID(Long id, TodolistRequest todolistRequest);
}
