
package com.mycompany.springtutorial;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    //GET to locahost:8080/
    @RequestMapping("/")
    public String index(){
        return "Hello from Spring Boot!";
    }
    
    //GET to locahost:8080/test
    @RequestMapping("/test")
    public String test(){
        return "Test works!";
    }
    
    public ArrayList<Person> getPersons(){
                ArrayList<Person> personList = new ArrayList<Person>(){ 
            { 
                add(new Person("John Smith", 31, "Software Engineer")); 
                add(new Person("Mary Wilson", 45, "Accountant")); 
                add(new Person("Mark Johnson", 51, "Customer Support")); 
            } 
        };
        return personList;
    }
    
    //GET to //locahost:8080/persons
    @RequestMapping("/persons")
    public PersonResponse getPersonResponse(){
        ArrayList<Person> personList = getPersons();
        PersonResponse response = new PersonResponse();
        response.setSuccess(true);
        response.setCount(personList.size());
        response.setPersons(personList);
        return response;
    }
}
