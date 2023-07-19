package peaksoft;

import com.sun.xml.bind.v2.runtime.unmarshaller.UnmarshallingContext;
import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
//        Util.getConnection();
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Alex", "Morgan", (byte) 28);
        userService.saveUser("Asan", "Asanov", (byte) 17);
        userService.saveUser("Uson", "Usonov", (byte) 20);
        userService.saveUser("Ivan", "Ivanov", (byte) 23);
        userService.getAllUsers().forEach(System.out::println);
        userService.removeUserById(5);
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.getAllUsers().forEach(System.out::println);
        userService.dropUsersTable();



    }
}
