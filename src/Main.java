/*Напишите класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов (их коды влезают в один байт) в массиве байт. По сравнению с классом String, хранящим каждый символ как char, AsciiCharSequence будет занимать в два раза меньше памяти.

Класс AsciiCharSequence должен:

реализовывать интерфейс java.lang.CharSequence;
иметь конструктор, принимающий массив байт;
определять методы length(), charAt(), subSequence() и toString()
Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или исходники).

В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры, поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.
*/
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        class AsciiCharSequence implements CharSequence {
            byte[] data;

            public AsciiCharSequence(byte[] data) {
                this.data = data;
            }

            @Override
            public int length() {
                return data.length;
            }

            @Override
            public char charAt(int index) {
                return (char) (data[index] & 0xff);
            }

            @Override
            public CharSequence subSequence(int start, int end) {
                int length = end - start;
                byte[] bytes = new byte[length];
                for (int i = 0, j = start; i < length; i++, j++) {
                    bytes[i] = data[j];
                }
                return new AsciiCharSequence(bytes);
            }

            @Override
            public String toString() {
                return new String(data);
            }
        }



        byte[] ex = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence an = new AsciiCharSequence(ex);
        System.out.println("Последовательность - " + an.toString());//Hello!
        System.out.println("Размер её - " + an.length());//6
        System.out.println("Символ под № 1 - " + an.charAt(1));//e
        System.out.println("Подпоследовательность - " + an.subSequence(1, 5));//ello
        System.out.println(an.toString());//Hello!
        ex[0] = 74;
        System.out.println(an.toString());//Jello!
    }

}
