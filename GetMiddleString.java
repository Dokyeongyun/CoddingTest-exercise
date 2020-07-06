package Programmers.GetMiddleString;

/*
        단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요.
        단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
*/

public class GetMiddleString {
    public static void main(String[] args) {
        String ans = middleString("abcde");
        System.out.println(ans);
    }

    public static String middleString(String s) {
        String[] array_s;
        array_s = s.split("");

        String answer = "";

        if (array_s.length % 2 == 1) {
            answer = array_s[(array_s.length / 2)];
        } else {
            answer = array_s[(array_s.length / 2)-1] + array_s[array_s.length / 2];
        }

        return answer;
    }
}

