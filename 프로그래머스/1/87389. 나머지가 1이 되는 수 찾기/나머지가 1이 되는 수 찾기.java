class Solution {
    public int solution(int n) {
        int answer = 0; //'answer'라는 변수를 선언하고, 초기값으로 0을 할당. 
        for(int i = 1; i<n; i++)
        {
            if(n%i ==1) //if문으로 n을 i로 나누었을때 나머지가 1인지? 
            {
                return i;
            }
        }
        return answer;
    }
}