package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = userService.setUser(context.getBean("userBean", User.class), "User1", "Lastname1", "user1@mail.ru", 123, "Toyota");
        userService.add(user1);

        User user2 = userService.setUser(context.getBean("userBean", User.class), "User2", "Lastname2", "user2@mail.ru", 56, "Nissan");
        userService.add(user2);

        User user3 = userService.setUser(context.getBean("userBean", User.class), "User3", "Lastname3", "user3@mail.ru", 150, "Porsche");
        userService.add(user3);

        User users1 = userService.returnUser(123, "Toyota");
        System.out.println(users1);


        context.close();
    }
}
