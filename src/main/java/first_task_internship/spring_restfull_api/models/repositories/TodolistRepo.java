package first_task_internship.spring_restfull_api.models.repositories;

import first_task_internship.spring_restfull_api.models.entities.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodolistRepo extends JpaRepository<Todolist, Long> {
    List<Todolist> findAllByTaskContaining(String substring);
    List<Todolist> findAllByStatus(String substring);


}








//import org.springframework.data.repository.CrudRepository;
//
//import java.util.List;

//public interface TodolistRepo extends CrudRepository<Todolist, Long> {
//
//    List<Todolist> findByTaskContains(String task);
//}


