package Programmers.MockTest;

/*
        수포자는 수학을 포기한 사람의 준말입니다.
        수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
        수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

        1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
        2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
        3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

        1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
        가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

        *제한 조건
        시험은 최대 10,000 문제로 구성되어있습니다.
        문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
        가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockTest {
    public static void main(String[] args) {
        int[] answers = {1, 3, 2, 4, 2};
//        int[] answers = {1, 2, 3, 4, 5};

        int[] returns = solution(answers);
    }

    public static int[] solution(int[] answers) {

        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (one[i % 5] == answers[i]) {
                cnt1++;
            }
            if (two[i % 8] == answers[i]) {
                cnt2++;
            }
            if (three[i % 10] == answers[i]) {
                cnt3++;
            }
        }

        int[] cnt = {cnt1, cnt2, cnt3};
        int[] max = {cnt1, cnt2, cnt3};
        Arrays.sort(max);

        List<Integer> answerList = new ArrayList<>();

        if (max[2] != max[1]) {
            for (int i = 0; i < 3; i++) {
                if (max[2] == cnt[i]) {
                    answerList.add(i + 1);
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                if (max[2] == cnt[i]) {
                    answerList.add(i + 1);
                }
            }
        }

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
