import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Пожалуйста, введите номер типа функции\n" +
                "sin(x)");
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
                break;
            case 2:
                break;
            default:
                break;
        }
    }

}
