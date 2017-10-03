package com.kgfsl.fixme;
import com.kgfsl.fixme.model.Todo;

import java.util.*;


public class TodoComn

{
   
public  List<Todo> testmethod()
{
   
 
     Todo a1=new TodoBuilder().name("bhuvana").status("completed").priority("first").iscompleted(true).build();
     Todo a2=new TodoBuilder().name("agalya").status("completed").priority("second").iscompleted(true).build();

     ArrayList<Todo> t2=new ArrayList<Todo> ();


     t2.add(a1);
     t2.add(a2);
     return t2;
}

public  Todo testmethod1()
{
   
 
     Todo a1=new TodoBuilder().name("bhuvana").status("completed").priority("first").iscompleted(true).build();
    /* Todo a2=new TodoBuilder().name("agalya").status("completed").priority("second").iscompleted(true).build();

     ArrayList<Todo> t2=new ArrayList<Todo> ();


     t2.add(a1);
     t2.add(a2);*/
     return a1;
}

}