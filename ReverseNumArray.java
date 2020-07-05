package Programmers.ReverseNumArray;

/*
        자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
        예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
*/
public class ReverseNumArray {
    public static void main(String[] args) {
        int[] ans = solution(12345);
    }

    public static int[] solution(long n) {
        String s = String.valueOf(n);
        String reversS = new StringBuffer(s).reverse().toString();
        System.out.println(reversS);

        int[] answer = new int[reversS.length()];

        for(int i=0; i<reversS.length(); i++){
            answer[i]= Integer.parseInt(String.valueOf(reversS.charAt(i)));
        }

        for(int i=0; i<answer.length; i++){
            System.out.print(answer[i]+" ");
        }
        return answer;
    }
}
