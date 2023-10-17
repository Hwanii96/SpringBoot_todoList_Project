package com.hwan.app.todoList.repository;

import com.hwan.app.todoList.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

}   //  TodoRepository
