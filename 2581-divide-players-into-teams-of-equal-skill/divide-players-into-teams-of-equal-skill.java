class Solution {
    public long dividePlayers(int[] skill) {
        long ans = 0;
        int n = skill.length;

        Arrays.sort(skill);

        int i = 0;
        int j = n-1;
        int reqSum = skill[0] + skill[n-1];

        while(i < j){
            if(skill[i] + skill[j] != reqSum){
                return -1;
            }

            ans += skill[i] * skill[j];
            i++;
            j--;
        }

        return ans;
    }
}