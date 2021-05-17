import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Пожалуйста, введите номер типа функции\n" +
                "1: y(x) = 1 - sin(x)\n" +
                "2: y(x) = 4 * exp(x) - x + 2 * sin(x)\n" +
                "3: y(x) = cos(x)^2 + 4 * x - 1");
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        switch (type) {
            case 1:
                Function function1;
                function1 = (x) -> 1 - Math.sin(x);
                System.out.println("Пожалуйста, введите левую и правую границу промежутка");
                Polynom.leftBoard = scanner.nextInt();
                Polynom.rightBoard = scanner.nextInt();
                System.out.println("Пожалуйста, введите количество точек интерполяции");
                Polynom.n = scanner.nextInt();
                Polynom.newtonMethod(function1);
                Polynom.searchY();
                break;
            case 2:
                Function function2;
                function2 = (x) -> 4 * Math.exp(x) - x + 2*Math.sin(x);
                System.out.println("Пожалуйста, введите левую и правую границу промежутка");
                Polynom.leftBoard = scanner.nextInt();
                Polynom.rightBoard = scanner.nextInt();
                System.out.println("Пожалуйста, введите количество точек интерполяции");
                Polynom.n = scanner.nextInt();
                Polynom.newtonMethod(function2);
                Polynom.searchY();
                break;
            case 3:
                Function function3;
                function3 = (x) -> Math.pow(Math.cos(x), 2) + 4 * x - 1;
                System.out.println("Пожалуйста, введите левую и правую границу промежутка");
                Polynom.leftBoard = scanner.nextInt();
                Polynom.rightBoard = scanner.nextInt();
                System.out.println("Пожалуйста, введите количество точек интерполяции");
                Polynom.n = scanner.nextInt();
                Polynom.newtonMethod(function3);
                Polynom.searchY();
            default:
                break;
        }
    }

}
