package first_task_internship.spring_restfull_api.services;

import first_task_internship.spring_restfull_api.library.Response;
import first_task_internship.spring_restfull_api.models.entities.Todolist;
import first_task_internship.spring_restfull_api.models.entities.TodolistRequest;
import org.springframework.data.domain.Page;


public interface TodolistService {
    Response addTodolist(TodolistRequest request);
    Response getAllTodolist();
    Response getTodolistById(Long id);
    Response deleteTodolistById(Long id);
    Response getTodolistByTask(String task, String status);
    Response getTodolistByStatus(String status);
    Response updateTodolistByID(Long id, TodolistRequest todolistRequest);
    Response countTodolistByStatus(String status);
    Response countTodolist();

    Page<Todolist> findTodolistWithPaginationAndSorting(int offset, int pageSize, String field);
    Page<Todolist> findTodolistWithPagination(int offset, int pageSize);
    Page<Todolist> findTodolistWithPaginationByStatus(String status, int offset, int pageSize);

}
