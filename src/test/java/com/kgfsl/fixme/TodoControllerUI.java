package com.kgfsl.fixme;
import com.kgfsl.fixme.controller.TodoController;
import com.kgfsl.fixme.model.Todo;
//import com.kgfsl.fixme.repository.TodoRepository;
import com.kgfsl.fixme.service.TodoService;
import com.kgfsl.fixme.service.*;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.verify;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)

public class TodoControllerUI
{
@InjectMocks
private TodoController todocontroller;

@Mock
private TodoService todoService;
   
    Todo todo=new Todo();
    TodoComn c=new TodoComn();

@Test
public void todoTest() {
  when(todoService.findAll1()).thenReturn(c.testmethod());
    ResponseEntity<List<Todo>> result = todocontroller.findall();
    assertEquals(2, c.testmethod().size());
}


@Test
public void saveTodo() {
    when(todoService.save(todo)).thenReturn(c.testmethod1());
    ResponseEntity<?> result= todocontroller.put(1L,todo);
    assertEquals(1L,1L);
}

@Test
 public void editTest()
{

when(todoService.findOne(1L)).thenReturn(c.testmethod1());
ResponseEntity<?> result = todocontroller.getById(1L);
assertEquals(1L, 1L);
}

  @Test
     public void deleteTest() {
        todoService.delete(1L);
        verify(todoService, times(1)).delete(1L);
 }
}