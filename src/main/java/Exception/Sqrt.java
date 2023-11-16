package Exception;
/*
Реализуйте метод sqrt(), вычисляющий квадратный корень числа. В отличие от Math.sqrt(),
это метод при передаче отрицательного параметра должен бросать исключение java.lang.IllegalArgumentException
с сообщением "Expected non-negative number, got ?",
где вместо вопросика будет подставлено фактически переданное в метод число.
 */
public class Sqrt {
    public static double sqrt(double x) {
        if (x < 0.0){
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }
        double result = Math.sqrt(x);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(4.0));
        try {
            System.out.println(sqrt(-4.0));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
