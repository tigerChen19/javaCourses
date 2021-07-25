package cta;

import lombok.Data;

@Data
public class MyStudent {
    private int id;
    private String name;

    public void print() {
        System.out.println("my name is " + getName());
    }
}
