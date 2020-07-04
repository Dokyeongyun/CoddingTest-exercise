package Programmers.Year2016;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*

        2016년 1월 1일은 금요일입니다.
        2016년 a월 b일은 무슨 요일일까요?
        두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
        요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT
        입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요.

                *제한조건
                2016년은 윤년입니다.
                2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
*/
public class Year2016 {
    public static void main(String[] args) throws ParseException {

        String ans = solution(5, 24);
    }

    public static String solution(int a, int b) throws ParseException {
        String answer = "";

        String Year = "2016-" + a + "-" + b;

        System.out.println(Year);
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Date mDate = date.parse(Year);

        Calendar cal = Calendar.getInstance();
        cal.setTime(mDate);

        System.out.println(cal.get(Calendar.DAY_OF_WEEK));

        switch (cal.get(Calendar.DAY_OF_WEEK)){
            case 1:
                answer = "SUN"; break;
            case 2:
                answer = "MON"; break;
            case 3:
                answer = "TUE"; break;
            case 4:
                answer = "WED"; break;
            case 5:
                answer = "THU"; break;
            case 6:
                answer = "FRI"; break;
            case 7:
                answer = "SAT"; break;
        }

        return answer;
    }

}
