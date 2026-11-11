class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long buyIndividually = (long) need1 * cost1 + (long) need2 * cost2;

        long buyAllCombo = (long) costBoth * Math.max(need1, need2);

        int overlap = Math.min(need1, need2);
        long buyMixed = (long) costBoth * overlap 
                      + (long) (need1 - overlap) * cost1 
                      + (long) (need2 - overlap) * cost2;

        return Math.min(buyIndividually, Math.min(buyAllCombo, buyMixed));
    }
}