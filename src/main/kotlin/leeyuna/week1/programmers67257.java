package leeyuna.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class programmers67257 {
    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
    }


    private static final String[][] operators = new String[][]{
            {"*", "+", "-"},
            {"*", "-", "+"},
            {"+", "*", "-"},
            {"+", "-", "*"},
            {"-", "*", "+"},
            {"-", "+", "*"},
    };


    public static long solution(String expression) {
        // new StringTokenizer("문자열", "구분자", "구분자도 st에 포함할것인지");
        StringTokenizer st = new StringTokenizer(expression, "*+-", true);
        List<String> tokens = new ArrayList<>();

        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }

        long max = Integer.MIN_VALUE;

        for (String[] operator : operators) {
            // 바로 tokens를 전달하면 안되는 이유는 연산자 우선순위에 반복해서 적용해야 하므로 -> 리스트를 복사해서 전달해줘야 함
            long num = Math.abs(calculate(new ArrayList<>(tokens), operator));
            if (num > max) max = num;
        }

        return max;
    }

    // 연산자 우선순위로 계산
    private static long calculate(List<String> tokens, String[] operator) {
        for (String op : operator) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long num1 = Long.parseLong(tokens.get(i - 1));
                    long num2 = Long.parseLong(tokens.get(i + 1));
                    long result = calculate(num1, num2, op);

                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);

                    tokens.add(i - 1, String.valueOf(result));
                    i -= 2;
                }
            }
        }

        return Long.parseLong(tokens.get(0));
    }


    private static long calculate(long num1, long num2, String op) {
        return switch (op) {
            case "*" -> num1 * num2;
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            default -> 0;
        };
    }

}
