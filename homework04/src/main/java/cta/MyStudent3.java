package cta;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MyStudent3 {
    private int id ;
    private String name="student3";
    public void print(){
        System.out.println("my name is "+ this.name);
    }
}
