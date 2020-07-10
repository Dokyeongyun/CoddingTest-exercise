package Programmers.DescendingSort;

/*
        함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
        예를들어 n이 118372면 873211을 리턴하면 됩니다.

            * 제한 조건
                n은 1이상 8000000000 이하인 자연수입니다.
 */
public class DescendingSort {
    public static void main(String[] args) {
        long answer = solution(118372);
        System.out.println(answer);
    }

    public static long solution(long n) {
        /*
        // <방법1>
        String number = String.valueOf(n);      // 입력값을 String으로 변환
        String[] arr = number.split("");        // 한 자리씩 쪼개어 배열로 저장
        Arrays.sort(arr);                       // 크기순으로 나열
        StringBuilder s = new StringBuilder();  // 거꾸로 저장
        for(int i=arr.length-1; i>=0; i--){
            s.append(arr[i]);
        }
        return Long.parseLong(String.valueOf(s));
        */

        // <방법2> : 람다식을 이용한 방법
        var ref = new Object() {
            String res = "";
        };

        Long.toString(n).chars().sorted().forEach(c -> ref.res = (char) c + ref.res);
        return Long.parseLong(ref.res);
    }
}
