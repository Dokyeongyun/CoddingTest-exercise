package Programmers.Truck;

import java.util.ArrayList;

/*
문제 설명
트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다.
모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 트럭은 1초에 1만큼 움직이며,
다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.

※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.

예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
 */
public class Truck {
    static ArrayList<Integer> timeList = new ArrayList<>();
    static int count = 0;
    static int currentWeight = 0;

    public static void main(String[] args) {

        int ans = solution(2, 10, new int[]{7, 4, 5, 6});
        System.out.println(ans);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        int time = 0;

        int index = 0;
        while (true) {
            time++;

            boolean check = false;
            if (count == truck_weights.length) {
                break;
            }

            if (currentWeight + truck_weights[index] <= weight) {
                currentWeight += truck_weights[index];
                if (index + 1 != truck_weights.length) {
                    index++;
                }
                timeList.add(bridge_length);
                check = true;
            } else {
                timePass(truck_weights,timeList.size());
            }

            if (check) {
                timePass(truck_weights,timeList.size()-1);
            }
        }
        return time;
    }

    public static void timePass(int[] truck_weights, int size) {
        for (int i = 0; i < size; i++) {
            int temp = timeList.get(i) - 1;

            if (temp == 1) {
                currentWeight -= truck_weights[i];
                count++;
                timeList.set(i, -1);
            } else if (temp > 0) {
                timeList.set(i, temp);
            }
        }
    }
}
