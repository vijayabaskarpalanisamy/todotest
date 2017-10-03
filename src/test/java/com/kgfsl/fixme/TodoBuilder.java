package com.kgfsl.fixme;
import com.kgfsl.fixme.model.*;
public class TodoBuilder {
  private Todo t1 = new Todo();
  
  public TodoBuilder id(long id) {
	  t1.setId(id);
    return this;
  }
public TodoBuilder name(String name) {
	  t1.setName(name);
    return this;
  }
  public TodoBuilder status(String status) {
	  t1.setStatus(status);
    return this;
  }
  public TodoBuilder priority(String priority) {
	  t1.setPriority(priority);
    return this;
  }
  
 public TodoBuilder iscompleted(Boolean isCompleted) {
	 t1.setIsCompleted(isCompleted);
    return this;
}
  public Todo build() {
    return t1;
  }
}
