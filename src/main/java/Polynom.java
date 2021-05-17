import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.Scanner;

public class Polynom {
    static double leftBoard;
    static double rightBoard;
    static int n;
    static double[] xPol;
    static double[] yPol;
    static int sumX;


//    public static double roundCoordinate(double cor) {
//        double quantity = Math.pow(10, 3);
//        double result = Math.ceil(cor * quantity) / quantity;
//        return result;
//    }


    static void newtonMethod(Function function) {
        sumX = (int) (((rightBoard - leftBoard) * 10) + 1);
        double[] xData = new double[sumX];
        double[] yData = new double[sumX];
        int p = 0;
        for (double i = leftBoard; i <= rightBoard; i = i + 0.1) {
            xData[p] = i;
            yData[p] = function.func(i);
            p++;
        }
        XYChart chart = QuickChart.getChart("1", "X", "Y", "y(x)1", xData, yData);

        double h = (rightBoard - leftBoard) / n;
        
        double[] uzliInterpol = new double[n];
        double x_inter = leftBoard + h;
        for (int i = 0; i < n; i++) {
            uzliInterpol[i] = function.func(x_inter);
            x_inter += h;
        }


        
        
        double[][] y_d = new double[n][n];
        double xxx = leftBoard + h;
        for (int i = 0; i < n; i++) {
            y_d[0][i] = function.func(xxx);
            xxx += h;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                y_d[i][j] = y_d[i - 1][j + 1] - y_d[i - 1][j];
            }
        }

        xPol = new double[sumX];
        yPol = new double[sumX];
        
        xxx = leftBoard;
        for (int i = 0; i < sumX; i++) {
                double factorial = 1;
                double drob = 1;
                double result = function.func(leftBoard + h);
                double t = (xxx - (leftBoard + h)) / h;
                for (int j = 1; j < n; j++) {
                    factorial *= j;
                    drob *= t - j + 1;
                    result += (drob/factorial) * y_d[j][0];
                }
                xPol[i] = xxx;
                yPol[i] = result;

                xxx = xxx + 0.1;
        }
        chart.addSeries("Интерполяция", xPol, yPol);
        chart.getStyler().setZoomEnabled(true);
        int simpleDimple = 1;
        double lolish = leftBoard + h;
        for (int i = 0; i < n; i++) {
            String message = Integer.toString(simpleDimple);
            chart.addSeries("x" + message, new double[]{lolish}, new double[]{function.func(lolish)});
            simpleDimple++;
            lolish += h;
        }

        chart.addSeries("lol", new double[]{3}, new double[]{-3});
        new SwingWrapper(chart).displayChart();


    }

    public static void searchY() {
        Scanner scanner1 = new Scanner(System.in);
        while (true) {
            System.out.println("Введите значение X для поиска значения Y по интерполяции:");
            double x_t = scanner1.nextDouble();
            if (x_t == -999) { break; }
            for (int i = 0; i < sumX; i++) {
                if (Math.abs(xPol[i] - x_t) <= 0.00001) {
                    System.out.println("Значение Y в точке " + x_t + " равно " + yPol[i]);
                }
            }
            System.out.println("Для завершения программы введите: -999");
        }
        System.out.println("Завершение программы...");
        System.exit(0);
    }
}


