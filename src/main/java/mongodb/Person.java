package mongodb;


import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Person {
    @Id
    int id;
    String name;
    Address adress;

    public Person(){
        name ="";
        adress = new Address();
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(Address address){
        this.adress = address;
    }
}
