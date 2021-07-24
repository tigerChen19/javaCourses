package cta;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Data
@Component(value = "myStudent2")
public class MyStudent2 {
    @Autowired MyStudent3 myStudent3;

    private int id;
    private String name="myStudenComponet";
    public void print(){
        System.out.println("my name is " + this.name);
    }
    public void print2(){
        myStudent3.print();
    }

}
