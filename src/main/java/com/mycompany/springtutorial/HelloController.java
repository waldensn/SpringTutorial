
package com.mycompany.springtutorial;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    //Gets persons from MongoDB
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
    
    //Gets employees from PostgreSQL
     public ArrayList<Employee> getEmployees(){
        ArrayList<Employee> empList = new ArrayList<Employee>();
        try
        {
            String url = "jdbc:postgresql://192.168.56.103:5432/steve";
            //PostgresConnection con = new PostgresConnection(url, "steve", "steve");
            PostgresConnection con = new PostgresConnection();
            Statement stmt = con.getConnection().createStatement();
            String sql = "SELECT id, name, position FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);
            while( rs.next() ){
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String position = rs.getString("position");
                Employee emp = new Employee(id, name, position);
                empList.add(emp);
            }
        }
        catch (SQLException e){
            System.out.println("Postgres connection failed, sql. " + e.getMessage());
        }
        catch (ClassNotFoundException e){
            System.out.println("Postgres connection failed, class not found. " + e.getMessage());
        }
         
        return empList;
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
    
    //GET to //locahost:8080/emps
     @RequestMapping("/emps")
    public EmployeeResponse getEmployeeResponse(){
        ArrayList<Employee> empList = getEmployees();
        EmployeeResponse response = new EmployeeResponse();
        response.setSuccess(true);
        response.setCount(empList.size());
        response.setEmps(empList);
        return response;
    }
}
