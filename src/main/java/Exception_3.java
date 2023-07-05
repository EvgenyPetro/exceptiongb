import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exception_3 {

    public static void main(String[] args) {
        saveUser(getUser());
    }


    public static void saveUser(User user) {
        try (FileWriter writer = new FileWriter(user.lastname, true)) {
            writer.write(user + "\n");
        } catch (IOException e) {
            System.out.println("Не удалось записать в файл");
            throw new RuntimeException(e);
        }
    }

    public static List<String> readUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию, имя, отчество, номер телефона через пробел");
        String userString = scanner.nextLine();
        String[] userSplit = userString.split(" ");

        if (userSplit.length != 4) {
            return Collections.emptyList();
        }
        return Arrays.asList(userSplit);
    }

    public static User getUser() {
        List<String> userString = readUser();

        if (userString.isEmpty()) {
            System.out.println("Пользователь ввел меньше или больше данных");
            throw new IndexOutOfBoundsException();
        }

        try {

            String firstname = userString.get(0);
            checkNoNumber(firstname);
            String lastname = userString.get(1);
            checkNoNumber(lastname);
            String surname = userString.get(2);
            checkNoNumber(surname);
            long phoneNumber = Long.parseLong(userString.get(3));
            return new User(lastname, firstname, surname, phoneNumber);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Введен неправильно телефон");
        } catch (FIOException e) {
            throw new RuntimeException("Введен неправильно ФИО");
        }

    }

    public static void checkNoNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                throw new FIOException();
            }
        }
    }


    static class User {
        private String firstname;
        private String lastname;
        private String surname;
        private long phoneNumber;

        public User(String firstname, String lastname, String surname, long phoneNumber) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.surname = surname;
            this.phoneNumber = phoneNumber;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public long getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(long phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return
                    lastname + "_" + firstname + "_" + surname + "_" + phoneNumber;
        }
    }

    private static class FIOException extends RuntimeException {
    }
}
