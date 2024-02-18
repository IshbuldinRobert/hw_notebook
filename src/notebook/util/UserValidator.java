package notebook.util;

import notebook.model.User;

public class UserValidator {
    public User validate(User user) {
        String name = user.getFirstName().replace(" ", "").trim();
        String lName = user.getLastName().replace(" ", "").trim();
        user.setFirstName(name);
        user.setLastName(lName);
        return user;
    }

    // Написать проверку наличия Id при обновление контакта
}
