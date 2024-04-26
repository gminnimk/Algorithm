class Solution {
    public static int solution(int age) {
        int yearOfBirth = 2022 - age;
        return yearOfBirth;
    }

    public static void main(String[] args) {
        // Example usage
        int age1 = 40;
        int age2 = 23;

        int result1 = solution(age1);
        int result2 = solution(age2);

        System.out.printf("2022년 기준 %d살이므로 %d년생입니다.\n", age1, result1);
        System.out.printf("2022년 기준 %d살이므로 %d년생입니다.\n", age2, result2);
    }
}