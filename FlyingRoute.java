package Programmers.FlyingRoute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
문제 설명
주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 ICN 공항에서 출발합니다.

항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
모든 공항은 알파벳 대문자 3글자로 이루어집니다.
주어진 공항 수는 3개 이상 10,000개 이하입니다.
tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
주어진 항공권은 모두 사용해야 합니다.
만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
 */
public class FlyingRoute {
    static List<String> list = new ArrayList<>();
    static String route = "";
    static boolean[] visit;

    public static void main(String[] args) {
        String[][] tickets = new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
       // String[][] tickets = new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        String[] ans = solution(tickets);

        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }
    }

    public static String[] solution(String[][] tickets) {

        for(int i = 0; i < tickets.length; i++) {
            visit = new boolean[tickets.length];
            String department = tickets[i][0];
            String destination = tickets[i][1];

            if(department.equals("ICN")) {
                route = department + ",";
                visit[i] = true;
                dfs(tickets, destination, 1);
            }
        }

        Collections.sort(list);

        return list.get(0).split(",");
    }

    public static void dfs(String[][] tickets, String destination, int count) {
        route += destination + ",";

        if(count == tickets.length) {
            list.add(route);
            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            String s = tickets[i][0];
            String e = tickets[i][1];
            if(s.equals(destination) && !visit[i]) {
                visit[i] = true;
                dfs(tickets, e, count + 1);
                visit[i] = false;
                route = route.substring(0, route.length()-4);
            }
        }
    }

    // 오답
    /*
            Map<String, ArrayList<String>> map = new HashMap<>();
        for(int i=0; i<tickets.length; i++){
            ArrayList<String> temp;
            if(!map.containsKey(tickets[i][0])){
                temp = new ArrayList<>();
            }else{
                temp = map.get(tickets[i][0]);
            }
            temp.add(tickets[i][1]);
            map.put(tickets[i][0], temp);
        }

        for(String key : map.keySet()) {
            ArrayList<String> value = map.get(key);
            Collections.sort(value);
        }

        Queue<String> que = new LinkedList<>();

        que.add("ICN");
        answer[0] = "ICN";
        int index = 1;

        while(!que.isEmpty()){
            String cur = que.peek();
            if(map.containsKey(cur)&& map.get(que.peek()).size()!=0){
                cur = map.get(que.poll()).remove(0);
                answer[index++] = cur;
            }else{
                break;
            }

            que.add(cur);
        }

     */
}
