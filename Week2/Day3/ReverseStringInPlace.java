import java.util.Scanner;

public class ReverseStringInPlace {

    public String reverseString(String input){
        char arr[] = input.toCharArray();
        char temp;
        for (int i = 0; i < arr.length/2; i++ ) {
            temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        input = String.valueOf(arr);

        return input;

    }
    public String reverseString(char[] input)
    {
        int low=0;
        int high=input.length-1;
        while(low<high)
        {
            char temp=input[low];
            input[low]=input[high];
            input[high]=temp;
            low++;
            high--;
        }
        return String.valueOf(input);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        String input = sc.nextLine();

        ReverseStringInPlace obj = new ReverseStringInPlace();

        System.out.println(obj.reverseString(input));
        System.out.println(obj.reverseString(input.toCharArray()));
    }
}
