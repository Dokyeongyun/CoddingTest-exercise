package Programmers.StringDescSort;

/*
        문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
        s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringDescSort {
    public static void main(String[] args) {

        String s = "Zbcdeafg";
        String answer = solution(s);

    }

    public static String solution(String s) {

        byte[] byteText = s.getBytes();

        Arrays.sort(byteText);

        List<Integer> a = new ArrayList<>();
        for(int i=0; i<byteText.length; i++){
            a.add((int) byteText[i]);
        }

        Collections.reverse(a);

        StringBuilder answer = new StringBuilder();

        for (Integer integer : a) {
            answer.append((char) (int) integer);
        }

        return answer.toString();
    }
}
