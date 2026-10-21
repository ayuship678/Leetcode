import java.util.*;

class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int i = 1;
        boolean k = false;

        while (i < n) {
            if (s.charAt(i-1) > s.charAt(i)) {
                k = true;
                break;
            }
            i++;
        }

        if (!k) return 0;

        HashMap<Character, Integer> d = new HashMap<>();
        for (char c : s.toCharArray()) {
            d.put(c, d.getOrDefault(c, 0) + 1);
        }

        if (n <= 2) return -1;

        char m1 = Collections.min(d.keySet());
        char m2 = Collections.max(d.keySet());

        if (m1 == s.charAt(n-1) && m2 == s.charAt(0)) {
            if (d.get(s.charAt(0)) == 1 && d.get(s.charAt(n-1)) == 1)
                return 3;
            else
                return 2;
        }

        if (m1 == s.charAt(0) || m2 == s.charAt(n-1))
            return 1;
        else
            return 2;
    }
}