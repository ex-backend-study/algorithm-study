package leeyuna.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BackJoon4949 {

    public static void main(String[] args) throws IOException {
//        solution();
        solution2();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String example = br.readLine();
            if (example.equals(".")) {
                break;
            }

            example = example.replaceAll("[.a-zA-Z ]", "");
            if (isValid(example)) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean isValid(String example) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : example.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.addLast(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.getLast() != '(') {
                    return false;
                } else {
                    stack.removeLast();
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.getLast() != '[') {
                    return false;
                } else {
                    stack.removeLast();
                }
            }
        }
        return stack.isEmpty();
    }

    // 값을 실시간으로 처리하는 게 메모리, 시간에서 전부 다 유리
    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String example = br.readLine();
            if (example.equals(".")) {
                break;
            }

            Deque<Character> stack = new ArrayDeque<>();
            boolean isValid = true;

            for (char c : example.toCharArray()) {
                if (c == '(' || c == '[') stack.addLast(c);
                if (c == ')') {
                    if (stack.isEmpty() || stack.getLast() != '(') {
                        isValid = false;
                        break;
                    } else {
                        stack.removeLast();
                    }
                }
                if (c == ']') {
                    if (stack.isEmpty() || stack.getLast() != '[') {
                        isValid = false;
                        break;
                    } else {
                        stack.removeLast();
                    }
                }
            }

            if (isValid && stack.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }

        System.out.println(sb);
    }
}
