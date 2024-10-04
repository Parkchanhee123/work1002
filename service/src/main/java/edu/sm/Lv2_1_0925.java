package edu.sm;
import java.util.*;

public class Lv2_1_0925 {
    class Solution {
        public int solution(int k, int[] tangerine) {
            int result = 0;

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int size : tangerine) {
                map.put(size, map.getOrDefault(size, 0) + 1);
            }

            List<Integer> keySet = new ArrayList<>(map.keySet());
            keySet.sort((size1, size2) -> map.get(size2) - map.get(size1));

            for (Integer size : keySet) {
                k -= map.get(size);
                result++;
                if (k <= 0) {
                    break;
                }
            }
            return result;
        }
    }
}
