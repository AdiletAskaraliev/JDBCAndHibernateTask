package peaksoft;



import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

//        userService.saveUser("Alex", "Morgan", (byte) 28);
//        userService.saveUser("Asan", "Asanov", (byte) 17);
//        userService.saveUser("Uson", "Usonov", (byte) 20);
//        userService.saveUser("Ivan", "Ivanov", (byte) 23);
//        userService.saveUser("BBBB", "aaaa", (byte) 23);

//        System.out.println(userService.getAllUsers());

//        userService.removeUserById(8L);

//        userService.cleanUsersTable();

        userService.dropUsersTable();

    }
}
