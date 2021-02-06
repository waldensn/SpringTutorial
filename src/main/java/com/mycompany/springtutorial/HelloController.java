
package com.mycompany.springtutorial;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
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
        MongoConnection conn = new MongoConnection();
        MongoDatabase db = conn.getClient().getDatabase("Steve");
        MongoCollection<Person> personCol = db.getCollection("Persons", Person.class);
        ArrayList<Person> personList = new ArrayList<Person>();
        
        //calling find method causes no such method exception
        //fixed by adding spring mongo dependency
        for (Person p : personCol.find()) {
            personList.add(p);
        }
       
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
