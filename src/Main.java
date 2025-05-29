import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Number number = new Number();
        System.out.print("Введите x: ");
        double x = scanner.nextDouble();
        number.setX(x);
        number.calc();
        System.out.println("Результат y: " + number.getY());

        System.out.println("Введите действие, которое нужно сделать (save/upload/exit): ");
        String s = scanner.next().toLowerCase();

        switch (s) {
            case "save":
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"))) {
                    writer.write("x: " + number.getX() + "\n");
                    writer.write("y: " + number.getY() + "\n");
                    System.out.println("Данные сохранены.");
                } catch (IOException e) {
                    System.out.println("ошибк: " + e.getMessage());
                }
                break;
            case "upload":
                try (BufferedReader reader = new BufferedReader(new FileReader("result.txt"))) {
                    System.out.println("Данные загружены: " + "\n" + reader.readLine() + "\n" + reader.readLine() + "\n");
                } catch (IOException | NullPointerException e) {
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