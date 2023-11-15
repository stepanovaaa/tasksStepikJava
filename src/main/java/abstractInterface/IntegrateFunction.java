package abstractInterface;

import java.util.function.DoubleUnaryOperator;

/* Реализуйте метод, выполняющий численное интегрирование заданной функции на заданном интервале
* по формуле левых прямоугольников.
* Функция задана объектом, реализующим интерфейс java.util.function.DoubleUnaryOperator.
* Его метод applyAsDouble() принимает значение аргумента и возвращает значение функции в заданной точке.
*
* Интервал интегрирования задается его конечными точками a и b, причем a<=b.
* Для получения достаточно точного результата используйте шаг сетки не больше 10−6
 */
public class IntegrateFunction {
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double sum = 0;
        double h = 1e-7;
        for (int i = 0; a <= b; a += h) {
            sum += f.applyAsDouble(a);
        }
        return sum * h;
    }

    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 10));
        System.out.println(integrate(x -> x + 2, 0, 10));//70.0
        System.out.println(integrate( x -> Math.sin(x) / x , 1, 5));//0.603848
    }
}
