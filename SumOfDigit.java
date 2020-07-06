package Programmers.SumOfDigit;

/*
        자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
        예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
*/

public class SumOfDigit {
    public static void main(String[] args) {
        int ans = solution(123);
        System.out.println(ans);
    }

    public static int solution(int n) {
        int answer = 0;

        String nString = String.valueOf(n);
        char[] stringArr = new char[nString.length()];
        for(int i=0; i<nString.length(); i++){
            stringArr[i] = nString.charAt(i);
            answer+=Integer.parseInt(String.valueOf(stringArr[i]));
        }

        return answer;
    }
}
