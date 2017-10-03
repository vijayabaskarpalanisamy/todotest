package com.kgfsl.fixme.service;

import com.kgfsl.fixme.model.Todo;
import java.util.List;


public interface TodoService {

    public List<Todo> findAll1();

    public Todo save(Todo todo);

    public Todo findOne(long id);
	 

    public void delete(Long id);

}

