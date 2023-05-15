import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        try {
            authorization("Hello", "world", "world");
        } catch (WrongPasswordException | WrongLoginException e) {
            System.out.println(e.getMessage());
        }
    }

    private static final String REGEX = "^[a-zA-Z0-9_]*$";

    public static void authorization(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login.matches(REGEX)) {
            System.out.printf("%s %s Login is correct\n",LocalTime.now(), LocalDate.now());
        } else throw new WrongLoginException("Incorrect login");

        if (login.length() > 20) {
            throw new WrongLoginException("Login is too long");
        }

        if (password.matches(REGEX)) {
            System.out.printf("%s %s Password is correct\n",LocalTime.now(), LocalDate.now());
        } else throw new WrongPasswordException("Incorrect password");

        if (password.length() >= 20) {
            throw new WrongPasswordException("Password is too long");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password is not confirmed");
        }
    }
}