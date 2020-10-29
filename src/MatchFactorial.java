import java.util.*;

public class MatchFactorial {
    public static final int START = 0;
    public static final int DIGITS = 1;
    public static final int FACTORIAL = 2;

    public static void main(String[] args) {
        // Добавляем в integers цифры
        List<Character> digits = Arrays.asList('0', '1', '2', '3','4','5','6','7','8','9');


        // описываем состояния автомата
        Set<Integer> endStates = Collections.singleton(FACTORIAL);
        StateMachine sm = new StateMachine(START, endStates);
        sm.add(START, digits, DIGITS);
        sm.add(DIGITS, digits, DIGITS);
        sm.add(DIGITS, '!', FACTORIAL);
        sm.add(FACTORIAL, digits, DIGITS);

        //Ввод строки пользователем и поиск в ней факториала
        String str;
        System.out.println("Введите строку: ");
        Scanner in = new Scanner(System.in);
        str = in.nextLine();
        sm.findAll(str);
        in.close();
    }
}
