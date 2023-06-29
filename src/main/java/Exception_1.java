import java.util.List;

public class Exception_1 {
    public static void main(String[] args) {

    }

    public int nullpoint(){
        List<Integer> list = null;
        list.size();
        return list.get(1);
    }

    public void outBound(){
        int[] arr = {1,3,5,2};
        System.out.println(arr[10]);
    }

    public double divisionByZero(){
        int a = 10;
        int b = 0;
        return (double) a/b;
    }

    public int[] diff(int[] a, int[] b) {
        if (a == null || b == null) {
            throw new RuntimeException("Один из масивов равен NULL");
        }
        if (a.length != b.length) {
            throw new RuntimeException("Длины масивов не совпадают");
        }
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] - b[i];
        }
        return c;
    }

    public double[] divine(int[] a, int[] b) {
        if (a == null || b == null) {
            throw new RuntimeException("Один из масивов равен NULL");
        }
        if (a.length != b.length) {
            throw new RuntimeException("Длины масивов не совпадают");
        }
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            if (b[i] == 0) {
                throw new RuntimeException("делить на ноль нельзя ");
            }
            c[i] = (double) a[i] / b[i];
        }
        return c;
    }


}
//Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
//Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
//Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
// каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов
// не равны, необходимо как-то оповестить пользователя.
//* Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
// каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов
// не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение,
// которое пользователь может увидеть - RuntimeException, т.е. ваше.