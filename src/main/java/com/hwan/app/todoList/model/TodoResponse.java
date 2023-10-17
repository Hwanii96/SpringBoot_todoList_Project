package com.hwan.app.todoList.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse {

    private Long id;
    private String title;
    private Long order;
    private Boolean completed;
    private String url;

    //  TodoResponse 는 이후 코드 작성을 더 편리 하게 작성 하기 위해서,
    //  todoEntity를 파라미터로 받는 생성자를 추가.
    public TodoResponse(TodoEntity todoEntity) {
        this.id = todoEntity.getId();
        this.title = todoEntity.getTitle();
        this.order = todoEntity.getOrder();
        this.completed = todoEntity.getCompleted();

        this.url = "http://localhost:8080/" + this.id;  //  하드 코딩
    }

}   //  TodoResponse
