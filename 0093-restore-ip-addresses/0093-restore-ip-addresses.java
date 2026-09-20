class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        backtrack(0, curr, s, res);

        return res;
    }

    private void backtrack(
        int idx,
        List<String> curr,
        String s,
        List<String> res
    ) {
        if (curr.size() == 4) {
            if (idx == s.length()) {
                res.add(
                    curr.get(0) + "." + curr.get(1) + "." + curr.get(2) + "." + curr.get(3)
                );
            }

            return;
        }

        for (int i = idx; i < s.length(); i++) {
            String octet = s.substring(idx, i + 1);

            if (octet.length() > 1 && octet.charAt(0) == '0') break;
            if (Integer.parseInt(octet) > 255) break;

            curr.add(octet);
            backtrack(i + 1, curr, s, res);
            curr.remove(curr.size() - 1);
        }
    }
}