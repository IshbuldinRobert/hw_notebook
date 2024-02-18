package notebook.view;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.util.Commands;

import java.util.Scanner;

public class UserView {
    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void run(){
        Commands com;

        while (true) {
            String command = prompt("Введите команду: ").toUpperCase().trim();
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case LIST:
                    System.out.println(userController.readAll());
                    break;
                case CREATE:
                    User u = userController.createUser();
                    userController.saveUser(u);
                    break;
                case READ:
                    String id = prompt("Идентификатор контакта: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case UPDATE:
                    String userId = prompt("Enter contact id: ");
                    userController.updateUser(userId, userController.createUser());
                    break;
                case DELETE:
                    String deleteUserId = prompt("Идентификатор контакта: ");
                    userController.deleteUser(deleteUserId);
                    break;
            }
        }
    }
    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
