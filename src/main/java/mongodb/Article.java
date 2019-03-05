package mongodb;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Article {
    @Id
    int id;
    String name;
    int stars;

    public Article(int id, String name, int stars){
        this.id = id;
        this.name = name;
        this.stars = stars;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setStars(int stars){
        this.stars = stars;
    }
}
