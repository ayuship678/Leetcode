class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        gp(n , 0 , sb);
        return result;
    }
    public void gp(int n , int count , StringBuilder sb) {
        if (n == 0 && count == 0) {result.add(sb.toString()); return;}
        if (count == 0) {
            gp(n , count+1 , sb.append('('));
            sb.deleteCharAt(sb.length()-1);
        }
        else {
            // No Close
            if (count < n) {
                gp(n , count+1 , sb.append('('));
                sb.deleteCharAt(sb.length()-1);
            }
            // Close
            gp(n-1 , count-1 , sb.append(')'));
            sb.deleteCharAt(sb.length()-1);
        }
    }
}