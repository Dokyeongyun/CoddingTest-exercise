package Programmers;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }
    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> sum = new HashMap<>();
        Map<String, List<Node>> index = new HashMap<>();

        for(int i=0; i<genres.length; i++){
            if(!sum.containsKey(genres[i])){
                sum.put(genres[i], plays[i]);
                List<Node> temp = new ArrayList<>();
                temp.add(new Node(i, plays[i]));
                index.put(genres[i], temp);
            }else{
                sum.put(genres[i], sum.get(genres[i]) + plays[i]);
                List<Node> temp = index.get(genres[i]);
                temp.add(new Node(i, plays[i]));
                index.put(genres[i], temp);
            }
        }

        System.out.println(sum);
        System.out.println(index);

        List<Map.Entry<String, Integer>> entries = new LinkedList<>(sum.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // SUM 내림차순으로 정렬
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        System.out.println(result);

        ArrayList<Integer> answer2 = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            String key   = entry.getKey();

            if(index.get(key).size() == 1){
                answer2.add(index.get(key).get(0).index);
                continue;
            }

            List<Node> temp = index.get(key);
            Collections.sort(temp);
            System.out.println(temp);

            answer2.add(temp.get(0).index);
            answer2.add(temp.get(1).index);
        }

        int[] answer = new int[answer2.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = answer2.get(i);
        }
        return answer;
    }

    static class Node implements Comparable<Node>{
        int index;
        int plays;
        Node(int index, int plays){
            this.index = index;
            this.plays = plays;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", plays=" + plays +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            if(plays > o.plays){
                return -1;
            }else if(plays < o.plays){
                return 1;
            }else{
                if(index >= o.index){
                    return -1;
                }else{
                    return 1;
                }
            }
        }
    }
}
