class Solution {
    public List<Integer> grayCode(int n) {
        
       List<Integer>list=new ArrayList<>();
       n=(int)Math.pow(2,n);
       for(int i=0;i<n;i++){
        int req=i^(i>>1);
        list.add(req);
       }

        return list;
    }

        
    
}