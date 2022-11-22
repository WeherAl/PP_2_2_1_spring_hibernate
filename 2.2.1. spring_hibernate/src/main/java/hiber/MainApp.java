package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.CarServiceImp;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        user1.setCar(new Car("Mark", 3));
        userService.add(user1);


        addUserWithCar("Alex", "Zurisk", "avc@mail.ru", "BMW", 5, userService);
        addUserWithCar("James", "Bond", "007@mail.ru", "RollsRoyce", 7, userService);
        addUserWithCar("Ostap", "Bender", "Turkish@mail.ru", "VAZ", 2, userService);
        addUserWithCar("Pol", "Walker", "speedyspeed@mail.ru", "Supra", 5, userService);
        addUserWithCar("Andrey", "Bond", "006@mail.ru", "RollsRoyce", 7, userService);
        addUserWithCar("Anna", "Karenina", "Karenina@mail.ru", "RollsRoyce", 7, userService);



        List<User> users = userService.getUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car model = " + user.getCar().getModel());
            System.out.println("Car series = " + user.getCar().getSeries());
            System.out.println();
        }

        List<User> userListWithCar = userService.getUsersWithSomeCar("RollsRoyce",7);
        for (User user : userListWithCar) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car model = " + user.getCar().getModel());
            System.out.println("Car series = " + user.getCar().getSeries());
            System.out.println();
        }

        context.close();
    }


    public static void addUserWithCar(String name, String lastname, String email, String carModel, int series, UserService service) {
        User user = new User(name, lastname, email);
        Car car = new Car(carModel, series);
        car.setUser(user);
        user.setCar(car);

        service.add(user);

    }


}
