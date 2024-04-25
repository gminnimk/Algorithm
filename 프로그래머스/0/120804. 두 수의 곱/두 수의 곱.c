#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int num1, int num2) {
    return num1 * num2;
}

int main() { 
    int num1, num2;
    int answer;
    
    answer = solution(num1,num2);
        
    scanf("%d",&num1); 
    scanf("%d",&num2);
    
    printf("num1이 %d, num2가 %d이므로 %d * %d = %d를 return합니다.",num1,num2,num1,num2, answer);
    printf("num1이 %d, num2가 %d이므로 %d * %d = %d를 return합니다.",num1,num2,num1,num2, answer);
        

}