
package com.mycompany.springtutorial;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Person {

    /**
     * @return the id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }
    private ObjectId id;
    @BsonProperty(value = "name")
    private String name;
    @BsonProperty(value = "age")
    private int age;
    @BsonProperty(value = "position")
    private String position;
    
    public Person(){}
    
    public Person(String name, int age, String position){
        this.name = name;
        this.age = age;
        this.position = position;
    }
    
    public Person(ObjectId id, String name, int age, String position){
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
    }
}
