package cta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo01 {

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext ctx2 = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MyStudent student = (MyStudent) ctx.getBean("studentCta");
        student.print();
        MyStudent2 student2 = (MyStudent2) ctx2.getBean("myStudent2");
        student2.print();
        student2.print2();
        MyStudent4 myStudent4 = (MyStudent4) ctx.getBean("myStudent4");
        myStudent4.print();
    }

    @Bean(name = "myStudent4")
    public static MyStudent4 getMyStudent4() {
        MyStudent4 myStudent4 = new MyStudent4();
        myStudent4.setName("学生4");
        return myStudent4;
    }
}
