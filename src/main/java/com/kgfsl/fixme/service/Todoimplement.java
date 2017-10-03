package com.kgfsl.fixme.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kgfsl.fixme.model.Todo;
import com.kgfsl.fixme.repository.TodoRepository;

@Service("todoService")
public class Todoimplement implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> findAll1() {
        // TODO Auto-generated method stub
        return todoRepository.findAll();
    }

    @Override
    public Todo save(Todo todo) {
        // TODO Auto-generated method stub
        return todoRepository.saveAndFlush(todo);

    }

    @Override
    public Todo findOne(long id) {
        // TODO Auto-generated method stub
        return todoRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        todoRepository.delete(id);
    }

}




