class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skillTree : skill_trees) {
            int idx = 0, preIdx = 0;
            boolean check = true;
            for (int j = 0; j < skill.length(); j++) {
                idx = skillTree.indexOf(skill.charAt(j));
                if (idx == -1) idx = 27;
                if (preIdx > idx) {
                    check = false;
                    break;
                }
                preIdx = idx;
            }

            if (check) answer ++;
        }
        return answer;
    }
}