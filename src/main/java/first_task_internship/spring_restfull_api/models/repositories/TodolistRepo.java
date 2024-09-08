package first_task_internship.spring_restfull_api.models.repositories;

import first_task_internship.spring_restfull_api.models.entities.Todolist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodolistRepo extends JpaRepository<Todolist, Long> {
    List<Todolist> findAllByTaskContainingAndStatus(String substring, String status);
    List<Todolist> findAllByStatus(String status);
    Page<Todolist> findAllByStatus(String status, Pageable pageable);
    Long countByStatus(String status);
}








//import org.springframework.data.repository.CrudRepository;
//
//import java.util.List;

//public interface TodolistRepo extends CrudRepository<Todolist, Long> {
//
//    List<Todolist> findByTaskContains(String task);
//}


