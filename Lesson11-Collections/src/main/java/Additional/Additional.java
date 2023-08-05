package Additional;

import java.util.*;

public class Additional {
    public static void findDuplicates(int[] nums) {
        Map<Integer, Integer> table = new HashMap<>();

        for (int num : nums) {
            table.put(num, table.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        int answerNum = 0;
        for (int a : table.keySet()) {
            if (max < table.get(a)) {
                max = table.get(a);
                answerNum = a;
            }
        }
        System.out.println("Most frequent : " + answerNum);
    }

    public static void byArray(int[] nums) {
        int answer = 0;
        int allMatches;
        int mostMatches = 0;
        for (int i = 0; i < nums.length; i++) {
            allMatches = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    allMatches++;
                }
            }
            if (allMatches > mostMatches) {
                mostMatches = allMatches;
                answer = nums[i];
            }
        }
        System.out.println("Most frequent : " + answer);
    }

}
