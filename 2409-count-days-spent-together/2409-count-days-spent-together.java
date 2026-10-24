class Solution {
    int[] days  = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int getDay(String date){
        int month = Integer.valueOf(date.substring(0, 2));
        int day = Integer.valueOf(date.substring(3, 5));
        int total = day;
        for(int i = 0; i < month - 1; i++){
            total += days[i];
        }
        return total;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        int aliceStart = getDay(arriveAlice);
        int aliceLeave = getDay(leaveAlice);
        int bobStart = getDay(arriveBob);
        int bobLeave = getDay(leaveBob);
        int start = Math.max(aliceStart, bobStart);
        int end = Math.min(aliceLeave, bobLeave);
        if(start > end){
            return 0;
        }
        return end - start + 1;
    }
}