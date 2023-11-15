package abstractInterface;

/*
Напишите класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов
(их коды влезают в один байт) в массиве байт. По сравнению с классом String, хранящим каждый символ как char,
AsciiCharSequence будет занимать в два раза меньше памяти.

Класс AsciiCharSequence должен:
реализовывать интерфейс java.lang.CharSequence;
иметь конструктор, принимающий массив байт;
определять методы length(), charAt(), subSequence() и toString()

Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или исходники).
В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры,
поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.
 */
public class AsciiCharSequence implements CharSequence{
    private byte[] sequence;

    public AsciiCharSequence(byte[] args) {
        byte[] array = new byte [args.length];
        for (int x = 0; x < args.length; x++) {
            array[x] = args[x];
        }
        this.sequence = array;
    }

    @Override
    public int length() {
        return sequence.length;
    }

    @Override
    public char charAt(int index) {
        return (char) sequence[index];
    }

    @Override
    public AsciiCharSequence subSequence(int start, int end) {
        byte[] seq = new byte[end - start];
        for(int i = 0; i < end - start; i++){
            seq[i] = (byte) this.charAt(start + i);
        }
        AsciiCharSequence result = new AsciiCharSequence(seq);
        return result;
    }

    @Override
    public String toString() {
        String str = new String(sequence);
        return str;
    }

    public static void main(String[] args) {
        byte[] example = {65, 66, 67, 68, 69, 70};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность: " + answer.toString());
        System.out.println("Размер последовательности: " + answer.length());
        System.out.println("Первый элемент последовательности: " + answer.charAt(1));
        System.out.println("Подпоследовательность: " + answer.subSequence(0, 4));
        System.out.println(answer.toString()); // ABCDEF
        example[0] = 74;
        System.out.println(answer.toString()); // JBCDEF

        byte[] example_ = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer2 = new AsciiCharSequence(example_);
        System.out.println("Последовательность - " + answer2.toString());//Hello!
        System.out.println("Размер её - " + answer2.length());//6
        System.out.println("Символ под № 1 - " + answer2.charAt(1));//e
        System.out.println("Подпоследовательность - " + answer2.subSequence(3, 5));//ello

//проверка на нарушение инкапсуляции private поля
        System.out.println(answer2.toString());//Hello!
        example_[0] = 74;
        System.out.println(answer2.toString());//Jello!

// ещё больше проверок (может быть лишних)
        System.out.println(answer2.subSequence(1, 2)); //e
        System.out.println(answer2.subSequence(5, 6)); //!
        System.out.println(answer2.subSequence(1, 3)); //el
        System.out.println("ello = " + answer2.subSequence(1, 5)); // Hello || Jello

        System.out.println(answer2.charAt(0)); // J
        System.out.println(answer2.charAt(1)); // e
        System.out.println(answer2.charAt(2)); // l
        System.out.println(answer2.charAt(3)); // l
        System.out.println(answer2.charAt(4)); // o
        System.out.println(answer2.charAt(5)); // !
    }
}
