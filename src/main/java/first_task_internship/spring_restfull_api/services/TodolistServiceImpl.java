package first_task_internship.spring_restfull_api.services;

import first_task_internship.spring_restfull_api.library.Response;
import first_task_internship.spring_restfull_api.models.entities.Todolist;
import first_task_internship.spring_restfull_api.models.entities.TodolistRequest;
import first_task_internship.spring_restfull_api.models.repositories.TodolistRepo;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class TodolistServiceImpl implements TodolistService{

    @Autowired
    private TodolistRepo todolistRepo;

    @Override
    public Response addTodolist(TodolistRequest request) {
        Todolist todolist = new Todolist();
        todolist.setTask(request.getTask());
        todolist.setNote(request.getNote());
        todolist.setStatus(request.getStatus());

        todolist = todolistRepo.save(todolist);

        Response response = new Response();
        response.setStatus(HttpStatus.CREATED.value());
        response.setMessage("Successfully added Data");
        response.setData(todolist);

        return response;
    }

    @Override
    public Response getAllTodolist() {

        List<Todolist> todolists = todolistRepo.findAll();
        Response response = new Response(HttpStatus.OK.value(),"Successfully get all data", todolists);
        return response;
    }

    @Override
    public Response getTodolistById(Long id) {
        Todolist todolist = todolistRepo.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("To do list is not found!");
        });
        return new Response(HttpStatus.OK.value(),"Successfully get all data", todolist);
    }

    @Override
    public Response deleteTodolistById(Long id) {

        Todolist todolist = todolistRepo.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("To do list is not found!");
        });

      todolist.setIsDeleted(true);
      todolist = todolistRepo.save(todolist);

      return new Response(HttpStatus.OK.value(),"Successfully delete data", todolist);
    }

    @Override
    public Response getTodolistByTask(String task, String status) {
        List<Todolist> todolists = todolistRepo.findAllByTaskContainingAndStatus(task, status);
        Response response = new Response(HttpStatus.OK.value(),"Successfully get data", todolists);
        return response;
    }

    @Override
    public Response getTodolistByStatus(String status) {
        List<Todolist> todolists = todolistRepo.findAllByStatus(status);
        Response response = new Response(HttpStatus.OK.value(),"Successfully get data", todolists);
        return response;
    }

    @Override
    public Response updateTodolistByID(Long id, TodolistRequest request){

        Todolist todolist = todolistRepo.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("To do list is not found!");
        });

        todolist.setTask(request.getTask());
        todolist.setNote(request.getNote());
        todolist.setStatus(request.getStatus());

        todolist = todolistRepo.save(todolist);

        return new Response(HttpStatus.OK.value(),"Successfully update data", todolist);
    }

    public List<Todolist> findTodolistWithSorting(String field){
        return todolistRepo.findAll(Sort.by(Sort.Direction.DESC, field));
    }

    public Page<Todolist> findTodolistWithPaginationByStatus(String status, int offset, int pageSize){
        PageRequest pageRequest = PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.DESC, "id"));
        Page<Todolist> todolist = todolistRepo.findAllByStatus(status, pageRequest);
        return todolist;
    }

    public Page<Todolist> findTodolistWithPagination(int offset, int pageSize){
        PageRequest pageRequest = PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.DESC, "id"));
        Page<Todolist> todolist = todolistRepo.findAll(pageRequest);
        return todolist;
    }

    public Page<Todolist> findTodolistWithPaginationAndSorting(int offset,int pageSize,String field){
        Page<Todolist> todolist = todolistRepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.DESC, field)));
        return  todolist;
    }

    public Response countTodolistByStatus(String status) {
        Long count = todolistRepo.countByStatus(status);
        return new Response(HttpStatus.OK.value(), "Successfully counted data", count);
    }

    public Response countTodolist() {
        Long count = todolistRepo.count();
        return new Response(HttpStatus.OK.value(), "Successfully counted data", count);
    }


}
