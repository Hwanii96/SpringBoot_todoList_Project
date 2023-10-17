package com.hwan.app.todoList.service;

import com.hwan.app.todoList.model.TodoEntity;
import com.hwan.app.todoList.model.TodoRequest;
import com.hwan.app.todoList.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoEntity add(TodoRequest request) {    //  insert()

        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(request.getTitle());
        todoEntity.setOrder(request.getOrder());
        todoEntity.setCompleted(request.getCompleted());

        return this.todoRepository.save(todoEntity);
    }

    public TodoEntity searchById(Long id) { //  selectOne()

        this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return null;
    }

    public List<TodoEntity> searchAll() {   //  selectAll()

        return this.todoRepository.findAll();
    }

    public TodoEntity updateById(Long id, TodoRequest request) { //  update()

        TodoEntity todoEntity = this.searchById(id);

        if(request.getTitle() != null) {
            todoEntity.setTitle(request.getTitle());
        }
        if(request.getOrder() != null) {
            todoEntity.setOrder(request.getOrder());
        }
        if(request.getCompleted() != null) {
            todoEntity.setCompleted(request.getCompleted());
        }
        return this.todoRepository.save(todoEntity);
    }

    public void deleteById(Long id) {   //  deleteOne()

        this.todoRepository.deleteById(id);
    }

    public void deleteAll() {   //  deleteAll()

        this.todoRepository.deleteAll();
    }

}   //  TodoService
