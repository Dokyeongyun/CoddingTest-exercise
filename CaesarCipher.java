package Programmers.CaesarCipher;

/*
        어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
        예를 들어 AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다. z는 1만큼 밀면 a가 됩니다.
        문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

             *제한 조건
            공백은 아무리 밀어도 공백입니다.
            s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
            s의 길이는 8000이하입니다.
            n은 1 이상, 25이하인 자연수입니다.
*/

public class CaesarCipher {
    public static void main(String[] args) {

//        String ans = solution("AB", 1);
//        String ans = solution("z", 1);
        String ans = solution("a B z", 4);

    }

    public static String solution(String s, int n) {
        String ASCII = "";

        // 65~90 대문자
        // 97~122 소문자
        // 32 공백

        int ASCIINum = 0;

        for (int i = 0; i < s.length(); i++) {
            ASCIINum = s.charAt(i);
            if (ASCIINum == 32) {
                ASCII += " ";
            } else if (ASCIINum >= 65 && ASCIINum <= 90) {
                if (ASCIINum + n >= 65 && ASCIINum + n <= 90) {
                    ASCIINum = ASCIINum + n;
                    ASCII += (char) ASCIINum;
                } else {
                    ASCIINum = ASCIINum + n - 90 + 64;
                    ASCII += (char) ASCIINum;
                }
            }else if( ASCIINum >=97 && ASCIINum <=122){
                if(ASCIINum +n >=97 && ASCIINum+n <=122){
                    ASCIINum = ASCIINum + n;
                    ASCII += (char) ASCIINum;
                }else{
                    ASCIINum = ASCIINum + n - 122 + 96;
                    ASCII += (char) ASCIINum;
                }
            }
        }

        return ASCII;
    }
}
