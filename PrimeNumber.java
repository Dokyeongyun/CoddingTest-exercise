package Programmers.PrimeNumber;

/*
            1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

            소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
            (1은 소수가 아닙니다.)
*/
public class PrimeNumber {
    public static void main(String[] args) {

        int ans = solution(10);
    }

    public static int solution(int n) {
        int answer = 0;

        boolean[] primeList = new boolean[n+1];
        for(int i=2; i<=n ; i++)
            primeList[i]=true;

        for(int i=2; i<Math.sqrt(n); i++){
            if(primeList[i]){
                for(int j=i; i*j<=n; j++){
                    primeList[i*j]=false;
                }
            }
        }
        for(int i =2; i<=n; i++) {
            if(primeList[i])
                answer++;
        }

        System.out.println(answer);
        return answer;

    }
}
