package Programmers.Printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public static void main(String[] args) {
        int[] priorities = new int[]{1, 1, 9, 1, 1, 1};
        int location = 4;

        int ans = solution(priorities, location);

        System.out.println(ans);

    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
            list.add(priorities[i]);
        }

        int count = 0;

        while (!queue.isEmpty()) {
            list.sort(Collections.reverseOrder());
            if (queue.element().equals(list.get(0))) {
                System.out.println(queue.poll());
                list.remove(0);
                location--;
                count++;
                if (location == -1) {
                    answer = count;
                    break;
                }
            } else {
                int temp = queue.element();
                queue.poll();
                queue.offer(temp);
                location--;
                if (location == -1) {
                    location = queue.size() - 1;
                }
            }

        }


        return answer;
    }

}
