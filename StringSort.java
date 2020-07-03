package Programmers.StringSort;

/*
문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
        예를 들어 strings가 [sun, bed, car]이고 n이 1이면 각 단어의 인덱스 1의 문자 u, e, a로 strings를 정렬합니다.
*/

public class StringSort {
    public static void main(String[] args) {

        String[] strings = {"abce", "abcd", "cdx", "abcc"};/* {"sun", "bed", "car"};*/

        int n = 1;

        String[] answer = solution(strings, n);

    }

    // 버블정렬을 이용한 풀이
    public static String[] solution(String[] strings, int n) {
        String[] answer;

        String temp;
        for (int i = strings.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (strings[j].substring(n, n + 1).compareTo(strings[j + 1].substring(n, n + 1)) > 0) {
                    temp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = temp;
                }
            }
        }

        for (int i = strings.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (strings[j].substring(n, n + 1).compareTo(strings[j + 1].substring(n, n + 1)) == 0) {
                    int compare = strings[j].compareTo(strings[j + 1]);
                    if (compare > 0) {
                        temp = strings[j];
                        strings[j] = strings[j + 1];
                        strings[j + 1] = temp;
                    }
                }
            }
        }

        answer = strings;
        return answer;
    }


}
