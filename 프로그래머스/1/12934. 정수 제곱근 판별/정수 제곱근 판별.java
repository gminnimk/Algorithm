class Solution {
  public long solution(long n) {
      
      /*
      if 문을 사용하여 입력으로 받은 n이 어떤 정수의 제곱인지 확인! 
      Math.sqrt(n)는 n의 제곱근을 구하는 함수이고, Math.pow((int)Math.sqrt(n), 2)는 제곱근을 구한 뒤에 정수로 형변환하여 다시 제곱을 한 값. 
      이 값이 원래의 n과 같으면, n은 어떤 정수의 제곱이라는 뜻입니다.
      */ 
      
      if (Math.pow((int)Math.sqrt(n), 2) == n) {
          /*
          위 조건이 참일 경우, 다음 큰 정수의 제곱을 반환 
          Math.sqrt(n)는 n의 제곱근을 구하고, 그에 1을 더한 후 다시 제곱하여 반환
          이렇게 함으로써 n보다 크면서 가장 가까운 정수의 제곱을 구할 수 있습니다. 
          */ 
            return (long) Math.pow(Math.sqrt(n) + 1, 2);
        }
        return -1; // -1을 반환하는 건 'n'이 어떤 정수의 제곱이 아니라는 뜻
  }
}