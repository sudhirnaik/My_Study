package practice.leetcode;

public class ReverseNumber {


        static  int result = 0;
        public static void main(String[] args) {
            int number = 1201;
            //123
            System.out.println(reverse(number));
            //System.out.println(reverseWhile(number));
        }

        public static int reverse (Integer num) {
            result = result+ num % 10;
            if (num/10 <1){
                return num;
            }
            result = result*10;
            reverse(num/10);
            return  result;
        }

        public static int reverseWhile(Integer num) {

            while(num > 9) {
                int digit = num%10;
                num = num/10;
                result = result + digit;
                result = result*10;
            }
            return result+num;
        }


}
