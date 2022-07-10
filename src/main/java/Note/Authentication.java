package Note;

import java.util.Scanner;

public class Authentication {
    private static final String LOGIN = "slava";
    private static final String PASSWORD = "123";

    public void authenticate() {
        Scanner s = new Scanner(System.in);

        boolean isAuthenticationSuccess = false;
        for (int i = 3; i != 0 && !isAuthenticationSuccess; i--) {
            String login;
            String password;

            System.out.print("Login: ");
            login = s.nextLine();

            System.out.print("Password: ");
            password = s.nextLine();

            if (validate(login, password)) {
                isAuthenticationSuccess = true;
            } else {
                System.out.println("Password is incorrect. Please try again. ");
            }
        }

        if (!isAuthenticationSuccess) {
            throw new RuntimeException("Login failed");
        }
    }

    public boolean validate(String login, String password) {
//        Можно так:
//        if (login.equals(LOGIN) && password.equals(PASSWORD)) {
//            return true;
//        } else {
//            return false;
//        }

//        А можно так:
//        return login.equals(LOGIN) && password.equals(PASSWORD) ? true : false;

//        Но еще можно так:
        return login.equals(LOGIN) && password.equals(PASSWORD);
    }
}
