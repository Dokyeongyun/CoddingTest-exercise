package Programmers.SkillTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
문제 설명
선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.

예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.

위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다.
따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.

선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.

제한 조건
스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
스킬 순서와 스킬트리는 문자열로 표기합니다.
예를 들어, C → B → D 라면 CBD로 표기합니다
선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
skill_trees는 길이 1 이상 20 이하인 배열입니다.
skill_trees의 원소는 스킬을 나타내는 문자열입니다.
skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
 */
public class SkillTree {
    public static void main(String[] args) {

        String skill = "CBD";
        String[] skill_trees = new String[]{/*"BACDE", "CBADE", "AECB", "BDA", "AQWER", */"CXF", "CEFD"};
//        String[] skill_trees = new String[]{"CDB"};

        int ans = solution(skill, skill_trees);
        System.out.println(ans);
    }

    // 방법1
    /*
    public static int solution(String skill, String[] skill_trees) {

        String[] skillOrder = skill.split("");

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < skillOrder.length; i++) {
            map.put(skillOrder[i], i);
        }
        int count = 0;

        for (int i = 0; i < skill_trees.length; i++) {

            String[] skillTreeSplit = skill_trees[i].split("");

            boolean check = true;
            boolean check2 = false;

            for (int j = 0; j < skillTreeSplit.length; j++) {

                // map 에 포함되어있지 않은 문자는 패스
                if (map.containsKey(skillTreeSplit[j])) {

                    // 포함되어 있으면 해당 문자 뒤에 우선순위가 더 높은 문자가 있는지 확인
                    int priority = map.get(skillTreeSplit[j]);
                    if (priority == 0) {
                        for (int k = j + 1; k < skillTreeSplit.length; k++) {
                            if (map.containsKey(skillTreeSplit[k])) {
                                int priority2 = map.get(skillTreeSplit[k]);

                                if (priority > priority2) {
                                    check = false;
                                    break;
                                }
                                priority = priority2;
                            }

                            if(k==skillTreeSplit.length-1){
                                check2 = true;
                            }
                        }
                    } else {
                        check = false;
                        break;
                    }
                }

                if(check2){
                    break;
                }
            }

            if (check) {
                count++;
            }
        }

        return count;
    }
*/

    // 방법2
    public static int solution(String skill, String[] skill_trees) {
        int count = 0;

        String[] skillOrder = skill.split("");

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < skillOrder.length; i++) {
            map.put(skillOrder[i], i);
        }


        for (int i = 0; i < skill_trees.length; i++) {

            String[] skillTreeSplit = skill_trees[i].split("");
            Queue<String> que = new LinkedList<>();

            for (int j = 0; j < skillTreeSplit.length; j++) {
                if (map.containsKey(skillTreeSplit[j])) {
                    que.add(skillTreeSplit[j]);
                }
            }

            System.out.println(que);
            boolean check = true;

            for (int k = 0; k < que.size(); k++) {
                if (map.get(que.element()) == k) {
                } else {
                    check = false;
                    break;
                }
                que.poll();
                que.offer("");
            }

            if (check) {
                count++;
            }
        }

        return count;
    }

}
