package mongodb;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Address {
    @Id
    int id;
    String street, city, postCode, country;

    public Address(){
        street = "";
        city = "";
        postCode = "";
        country = "";
    }

    public void setStreet(String street){
        this.street = street;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setPostCode(String postCode){
        this.postCode = postCode;
    }

    public void setCountry(String country){
        this.country = country;
    }

}
