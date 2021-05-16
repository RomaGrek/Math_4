import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public class Polynom {
    static double leftBoard;
    static double rightBoard;
    static int n;

    static int checkLeft(double x, double h) {
        double s = rightBoard;
        int pop = 0;
        while (x < s) {
            s -= h;
            pop++;
        }
        return (pop - 1);
    }
//
//    static int checkRight(double x, double h) {
//        int s = leftBoard;
//        int pop = 0;
//        while (x > s) {
//            s += h;
//            pop++;
//        }
//        return (pop - 1);
//    }


    static void newtonMethod(Function function) {
        double[] xData = new double[91];
        double[] yData = new double[91];
        int p = 0;
        for (double i = 1; i <= 10; i = i + 0.1) {
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
        int sumX = 90;
        
        double[] xPol = new double[sumX];
        double[] yPol = new double[sumX];
        
        xxx = leftBoard;
        for (int i = 0; i < sumX; i++) {
//            if (xxx < (leftBoard + rightBoard) / 2) {
                double factorial = 1;
                double drob = 1;
                double result = function.func(leftBoard + h);
                double t = (xxx - 2.8) / h;
                for (int j = 1; j < n; j++) {
                    factorial *= j;
                    drob *= t - j + 1;
                    result += (drob/factorial) * y_d[j][0];
                }
                xPol[i] = xxx;
                yPol[i] = result;

            xxx = xxx + 0.1;
        }
        chart.addSeries("SUKA", xPol, yPol);
        new SwingWrapper(chart).displayChart();


//        double facrorial = 1;     // факториал
//        double result = function.func(leftBoard);
//        double[] xPol = new double[shet];
//        double[] yPol = new double[shet];
//        xPol[0] = leftBoard;
//        yPol[0] = function.func(leftBoard);
//        xxx = leftBoard + 0.1;
//        double drob = 1;
//       for (int i = 0; i < shet; i++) {
//           double t = (xxx - leftBoard) / h;
//           if (i < (leftBoard + rightBoard) / 2) {
//               for (int j = 1; j < checkLeft(xxx, h); j++) {
//                   facrorial *= j;
//                   drob *= t - j + 1;
//                   result += (drob/facrorial) * y_d[j][0];
//               }
//               xPol[i] = xxx;
//               yPol[i] = result;
//               result = function.func(leftBoard);
//           }else {
//               for (int j = (leftBoard + rightBoard) / 2; j < checkRight(xxx, h); j++) {
//                   facrorial *= j;
//                    drob *= t - j + 1;
//                   result += (drob/facrorial) * y_d[j][0];
//               }
//               xPol[i] = xxx;
//               yPol[i] = result;
//               result = function.func(leftBoard);
//           }
//           xxx += 0.1;
//       }






//        XYChart chart1 = QuickChart.getChart("1", "X", "Y", "y(x)1", xData_inter, yData_inter);
//        chart.addSeries("lol", xData_inter, yData_inter);
//
//        new SwingWrapper(chart).displayChart();

    }

//    double Newton(double x, int n, double *MasX, double *MasY, double step)
//    {
//        // выделяем память под динамический двумерный массив dy
//        double **dy = new double*[n];
//        for ( int i = 0; i < n; i++ ) dy[i] = new double[n];
//
//        // подсчитываем dy
//        for ( int i = 0; i < n; i++ )
//        {
//            dy[0][i] = MasY[i];
//        }
//
//        for ( int i = 1; i < n; i++ )
//        {
//            for ( int j = 0; j < n-i; j++ )
//            {
//                dy[i][j] = dy[i-1][j+1] - dy[i-1][j];
//            }
//        }
//
//        // вычисляем результирующий y
//        double q = (x-MasX[0]) / step; // см. формулу
//        double result = MasY[0]; // результат (y)
//
//        double mult_q = 1; // произведение из q*(q-1)*(q-2)*(q-n)
//        double fact = 1;  // факториал
//
//        for ( int i = 1; i < n; i++ )
//        {
//            fact *= i;
//            mult_q *= (q-i+1);
//
//            result += mult_q/fact * dy[i][0];
//        }
//
//        // осводождаем dy
//        for ( int i = 0; i < n; i++ ) delete[] dy[i];
//        delete[] dy;
//
//        return result;
//    }
//0
//    Вложения



}
