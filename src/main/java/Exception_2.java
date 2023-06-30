import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exception_2 {
    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
    }

    public static void task1() {
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("введите дробное число");
                System.out.printf("Введенное число: %.2f%n", getFloat());
                flag = false;
            } catch (Exception e) {
                System.out.println("Вы ввели не дробное число");
                flag = true;
            }
        }
    }

    private static float getFloat() throws Exception {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String next = scanner.next();
            String[] split = next.split("\\.");
            if (split.length == 2) {
                return Float.parseFloat(next);
            }
            throw new Exception();
        } else {
            throw new Exception();
        }
    }


    public static void task2() {
        try {
            int d = 0;
            int[] intArray = new int[8];
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

    }

    public static void task3() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (FileNotFoundException ex) {
            System.out.println("файл не найден...");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }

    }

    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }

    public static void task4() {
        try {
            System.out.println(getString());
        } catch (Exception e) {
            System.out.println("пустые строки вводить нельзя");
        }
    }

    private static String getString() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if (!next.isBlank()) {
            return next;
        } else {
            throw new Exception();
        }
    }

}
//Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
// вместо этого, необходимо повторно запросить у пользователя ввод данных.
//Если необходимо, исправьте данный код (задание 2
// https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
//Дан следующий код, исправьте его там, где требуется (задание 3
// https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
//Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.