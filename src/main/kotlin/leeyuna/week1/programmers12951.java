package leeyuna.week1;

public class programmers12951 {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution(" 3people unFollowed me "));
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        // split에 -1을 쓰면, 빈 문자열도 포함해서 배열로 반환 가능
        String[] words = s.split(" ", -1);

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!word.isEmpty()) {
                sb.append(Character.toUpperCase(word.charAt(0)));
                for (int j = 1; j < word.length(); j++) {
                    sb.append(Character.toLowerCase(word.charAt(j)));
                }
            }
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
