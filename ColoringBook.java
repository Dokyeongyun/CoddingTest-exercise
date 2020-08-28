package Programmers.KaKao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {

    static int[][] arr;
    static int rowMax;
    static int colMax;
    static ArrayList<Integer> countList = new ArrayList<>();

    public static void main(String[] args) {

        int m = 13;
        int n = 16;
        //   int[][] picture = new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[][] picture = new int[][]{{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0}, {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}};

        int[] answer = solution(m, n, picture);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static int[] solution(int m, int n, int[][] picture) {
        rowMax = m;
        colMax = n;
        arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = picture[i][j];
            }
        }

        int value = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != value && arr[i][j] != 0) {
                    bfs(i, j, arr[i][j]);
                }
            }
        }
        Collections.sort(countList);

        for (int i = 0; i < countList.size(); i++) {
            if (countList.get(i) != 0) {
                int temp = countList.get(i);
                countList.set(i, temp - 1);
            }
        }
        return new int[]{countList.size(), countList.get(countList.size() - 1)};
    }

    public static void bfs(int x, int y, int value) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        int count = 0;

        while (!que.isEmpty()) {
            Node temp = que.poll();
            count++;

            if (temp.y + 1 < colMax && arr[temp.x][temp.y + 1] == value) {
                que.add(new Node(temp.x, temp.y + 1));
                arr[temp.x][temp.y + 1] = 0;
            }
            if (temp.x - 1 >= 0 && arr[temp.x - 1][temp.y] == value) {
                que.add(new Node(temp.x - 1, temp.y));
                arr[temp.x - 1][temp.y] = 0;
            }
            if (temp.y - 1 >= 0 && arr[temp.x][temp.y - 1] == value) {
                que.add(new Node(temp.x, temp.y - 1));
                arr[temp.x][temp.y - 1] = 0;
            }
            if (temp.x + 1 < rowMax && arr[temp.x + 1][temp.y] == value) {
                que.add(new Node(temp.x + 1, temp.y));
                arr[temp.x + 1][temp.y] = 0;
            }
        }

        countList.add(count);
    }

    public static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
