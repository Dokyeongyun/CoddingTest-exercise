package Programmers.FindKim;


/*
        String형 배열 seoul의 element중 Kim의 위치 x를 찾아,
        김서방은 x에 있다는 String을 반환하는 함수, solution을 완성하세요.
        seoul에 Kim은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.
*/

import java.util.Arrays;

public class FindKim {
    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};
        String answer = solution(seoul);
        System.out.println(answer);

    }
    public static String solution(String[] seoul) {

        /*
        List<String> seoulList = Arrays.asList(seoul);

        int x=0;
        for(int i=0; i<seoulList.size(); i++){
            if(seoulList.get(i).equals("Kim")){
                x = i;
            }
        }
        */

        int x = Arrays.asList(seoul).indexOf("Kim");

        return "김서방은 "+x+"에 있다";
    }
}
