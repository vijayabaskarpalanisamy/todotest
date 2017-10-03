package com.kgfsl.fixme.controller;
import com.kgfsl.fixme.service.TodoService;
import com.kgfsl.fixme.model.Todo;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/todolist")
public class TodoController {
	@Autowired
	private TodoService todoService;


@GetMapping("/get")public @ResponseBody ResponseEntity<List<Todo>> findall() {
return new ResponseEntity<>(todoService.findAll1(), HttpStatus.OK);
}

  @GetMapping("/get/{todoId}")
    public @ResponseBody ResponseEntity<?> getById(@PathVariable Long todoId) {

        Todo todo = todoService.findOne(todoId);
        return new ResponseEntity<>(todo, HttpStatus.OK);

    }
@PostMapping("/post")public ResponseEntity<?> post(@RequestBody Todo todo, UriComponentsBuilder ucBuilder) {
todoService.save(todo);
HttpHeaders headers = new HttpHeaders();
headers.setLocation(ucBuilder.path("/get/{id}").buildAndExpand(todo.getId()).toUri());
return new ResponseEntity<>(headers, HttpStatus.CREATED);

}
@PutMapping("/put/{todoId}")
public ResponseEntity<?> put(@PathVariable Long todoId , @RequestBody Todo todo) {
todoService.save(todo);
return new ResponseEntity<>(todo, HttpStatus.OK);
}

@DeleteMapping("/delete/{todoId}")
public ResponseEntity<?> delete(@PathVariable Long todoId) {
todoService.delete(todoId);
return new ResponseEntity<>(HttpStatus.OK);
}

}
