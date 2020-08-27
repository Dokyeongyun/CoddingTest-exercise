package Programmers.SkillCheck2;

import java.util.ArrayList;
import java.util.HashSet;

public class SkillCheck2 {

    /**
     * 2번 문제에 필요한 변수
     */
    static String[] huboArr;
    static boolean[] visit;
    static int[] arr;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        /**
         * 1번 문제
         */
      /*  int ans = solution(5000);
        System.out.println(ans);*/

        /**
         * 2번 문제
         */
        String numbers = "17";
        int ans = solution(numbers);
        System.out.println(ans);
    }

    /**
     * 1번 문제 답안
     */
  /*  public static int solution(int n) {
        int ans = 0;


        // N / 2 가 홀수면 -1을 한 후, count ++
        //
        int temp = n;

        while (temp != 0) {

            if (temp % 2 == 1) {
                temp--;
                ans++;
            } else {

                while (temp % 2 != 1) {
                    temp = temp / 2;
                }

                temp--;
                ans++;

            }
        }

        return ans;
    }
*/

    /**
     * 2번 문제 답안
     * @param numbers
     * @return
     */
    public static int solution(String numbers) {
        int answer = 0;
        // 1. 주어진 숫자로 만들 수 있는 모든 경우의 수
        // 2. 각 수가 소수인지 판별
        // 3. 소수의 개수 카운트
        // 4. 출력

        huboArr = numbers.split("");

        visit = new boolean[huboArr.length + 1];
        for (int i = 0; i < huboArr.length; i++) {
            arr = new int[i + 1];
            dfs(huboArr.length, i + 1, 0);
        }


        HashSet<Integer> arr2 = new HashSet<>(list);
        ArrayList<Integer> arr3 = new ArrayList<>(arr2);

        for (int i = 0; i < arr3.size(); i++) {
            boolean check = false;
            if (arr3.get(i) == 1 || arr3.get(i) == 0) {

            } else {
                for (int j = 2; j < arr3.get(i); j++) {
                    if (arr3.get(i) % j == 0) {
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    answer++;
                }
            }
        }

        System.out.println(arr3);
        return answer;
    }

    public static void dfs(int n, int m, int d) {
        if (d == m) {
            String temp = "";
            for (int i = 0; i < arr.length; i++) {
                temp += arr[i];
            }
            list.add(Integer.parseInt(temp));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[d] = Integer.parseInt(huboArr[i]);
                dfs(n, m, d + 1);
                visit[i] = false;
            }
        }
    }


}