package Programmers.Camouflage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
문제 설명
스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.

예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면
다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.

종류	이름
얼굴	동그란 안경, 검정 선글라스
상의	파란색 티셔츠
하의	청바지
겉옷	긴 코트

스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항
clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
같은 이름을 가진 의상은 존재하지 않습니다.
clothes의 모든 원소는 문자열로 이루어져 있습니다.
모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
스파이는 하루에 최소 한 개의 의상은 입습니다.
 */
public class Camouflage {
    public static void main(String[] args) {

        String[][] clothes = new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        // String[][] clothes = new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        int ans = solution(clothes);
        System.out.println(ans);
    }

    public static int solution(String[][] clothes) {

        // 1. 각 종류별로 몇개의 의상이 있는지 체크
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (!map.containsKey(clothes[i][1])) {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(clothes[i][0]);
                map.put(clothes[i][1], temp);
            } else {
                ArrayList<String> temp = map.get(clothes[i][1]);
                temp.add(clothes[i][0]);
                map.put(clothes[i][1], temp);
            }
        }

        // 2. 경우의 수 계산
        int answer = 1;
        for (String key : map.keySet()) {
            answer *= map.get(key).size() + 1;
        }

        return answer-1;
    }
/*    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] strings : clothes) {
            int p = 0;
            String key = strings[1];
            if(map.containsKey(key)){
                p = map.get(key);
            }
            map.put(key, p+1);
        }
        Collection<Integer> values = map.values();
        Integer[] counts = new Integer[values.size()];
        values.toArray(counts);

        for(int i=0; i<counts.length; i++){
            System.out.println(counts[i]);
        }
        int[][] dp = new int[values.size()][2];
        dp[0][0] = 1;
        dp[0][1] = counts[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0] * counts[i] + dp[i-1][1] * counts[i];
        }

        return dp[dp.length-1][0] + dp[dp.length-1][1] -1;
    }*/
}
