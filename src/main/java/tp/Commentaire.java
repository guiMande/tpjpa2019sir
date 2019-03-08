package tp;

import javax.persistence.*;

@Entity
public class Commentaire {

    int id;
    String text;

    public Commentaire(){ }

    public Commentaire(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
