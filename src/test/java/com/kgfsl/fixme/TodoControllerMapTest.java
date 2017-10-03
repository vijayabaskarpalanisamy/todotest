package com.kgfsl.fixme; 
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.given;

import com.kgfsl.fixme.controller.TodoController;
import com.kgfsl.fixme.model.Todo;

import com.kgfsl.fixme.service.TodoService;
@RunWith(SpringRunner.class)
@WebMvcTest(value = TodoController.class, secure = false)
public class TodoControllerMapTest {

@Autowired
private MockMvc mockMvc;

@MockBean
private TodoService todosService;



@Test
public void getByID() throws Exception {
Todo a2 = new Todo();
a2.setId(1L);
a2.setName("passport");
a2.setStatus("completed");
a2.setPriority("first");
a2.setIsCompleted(true);
given(todosService.findOne(1L)).willReturn(a2);
mockMvc.perform(get("/todolist/get/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
.andExpect(content().json("{'id': 1, 'name': 'passport', 'status': 'completed', 'priority': 'first','isCompleted': true }"));

}

@Test
public void findAll() throws Exception {
Todo a2 = new Todo();
a2.setId(1L);
a2.setName("baskar");
a2.setStatus("completed");
a2.setPriority("first");
a2.setIsCompleted(true);
List<Todo> alist1 = new ArrayList<Todo>();
    alist1.add(a2);
given(todosService.findAll1()).willReturn(alist1);
mockMvc.perform(get("/todolist/get").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
.andExpect(content().json("[{'id': 1,'isCompleted': true, 'name': 'baskar','priority': 'first','status': 'completed'}]"));

}



@Test
public void postmapping() throws Exception {
Todo a2 = new Todo();
a2.setId(1L);
a2.setName("passport");
a2.setStatus("completed");
a2.setPriority("first");
a2.setIsCompleted(true);
when(todosService.findOne(a2.getId())).thenReturn(a2);
mockMvc.perform(post("/todolist/post").contentType(MediaType.APPLICATION_JSON).content(asJsonString(a2)));


}

@Test
public void deleteByID() throws Exception {
Todo a2 = new Todo();
a2.setId(1L);
a2.setName("passport");
a2.setStatus("completed");
a2.setPriority("first");
a2.setIsCompleted(true);
when(todosService.findOne(a2.getId())).thenReturn(a2);
 mockMvc.perform(delete("/todolist/delete/1", a2.getId())).andExpect(status().isOk());
  verify(todosService, times(1)).delete(a2.getId());
       // verifyNoMoreInteractions(eventService);
}


public static String asJsonString(final Object obj) {
try {
final ObjectMapper mapper = new ObjectMapper();
return mapper.writeValueAsString(obj);
}
catch (Exception e) {
throw new RuntimeException(e);
}
}

}