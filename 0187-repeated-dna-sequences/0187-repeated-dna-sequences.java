class Solution 
{
    public List<String> findRepeatedDnaSequences(String s) 
    {
        int n=s.length();
        List<String> ans = new ArrayList<>();
        Map<String,Integer> mpp = new HashMap<>();
        int l=0;
        int r=0;
        StringBuilder curr = new StringBuilder();
        while(r<n)
        {
            curr=curr.append(s.charAt(r));
            while(r-l+1==10)
            {
                mpp.put(curr.toString(),mpp.getOrDefault(curr.toString(),0)+1);
                if(mpp.get(curr.toString())==2)
                {
                    ans.add(curr.toString());
                }
                curr=curr.deleteCharAt(0);
                l++;
            }
            r++;
        }
        return ans;
    }
}