
//For only small alphabets (a-z)
import java.util.Scanner;
public class PermutationPalindrome {

    public boolean checkPermutation(String input){
        try {
            int alpha[] = new int[26];
            int countOddChar = 0;
            for (int i = 0; i < input.length(); i++) {
                alpha[((int) input.charAt(i)) - 97]++;
            }
            for (int i = 0; i < alpha.length; i++) {
                if (alpha[i] % 2 != 0) {
                    countOddChar++;
                }
            }
            System.out.println(countOddChar);
            if (countOddChar > 1) {
                return false;
            } else {
                return true;
            }
        }
        catch (Exception e)
        {
            System.out.println("Characters other than small alpahabets are not allowed");
            return false;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        String input = sc.nextLine();

        PermutationPalindrome obj = new PermutationPalindrome();
        System.out.println("Is given string has permutation palindrome : "+obj.checkPermutation(input));
    }
}
