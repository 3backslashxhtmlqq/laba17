import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Number number = new Number();
        System.out.println("Введите x: ");
        double x = scanner.nextDouble();
        number.setX(x);
        number.calc();
        System.out.println("Результат y: " + number.getY());

        System.out.println("Введите действие, которое нужно сделать (save/upload/exit): ");
        String s = scanner.next().toLowerCase();

        switch (s) {
            case "save":
                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("result.dat"))) {
                    objectOutputStream.writeObject(number);
                    System.out.println("Данные сохранены.");
                } catch (IOException e) {
                    System.out.println("ошибк: " + e.getMessage());
                }
                break;
            case "upload":
                try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("result.dat"))) {
                    Number load = (Number) objectInputStream.readObject();
                    System.out.println("Данные загружены: " + "\n" + "x: " + load.getX() + "\n" + "y: " + load.getY());
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("ошибк: " + e.getMessage());
                }
                break;
            case "exit":
                break;
            default:
                System.out.println("Неизвестная подкоманда.");
                break;
        }

    }
}