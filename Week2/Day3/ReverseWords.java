import java.util.*;
class ReverseWords {
    public  void reverse(char[] input,int start,int end)
    {
        while(start<end)
        {
            char temp=input[start];
            input[start]=input[end];
            input[end]=temp;
            start++;
            end--;
        }

    }
    public String reverseWords(char[] input)
    {
        int word_begin=0;
        int index=1;
        while(index<input.length)
        {
            if(input[index]==' ')
            {
                reverse(input,word_begin,index-1);
                word_begin=index+1;
            }
            else if(index==input.length-1)
                reverse(input,word_begin,index);
            index++;
        }

        reverse(input,0,input.length-1);

        return String.valueOf(input);
    }

    public String reverseWords(String input){
        String arr[] = input.split(" ");
        //System.out.println(arr);
        String temp;
        for (int i = 0; i < arr.length/2; i++ ) {
            temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        input = String.join(" ",arr);

        return input;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        String input = sc.nextLine();

        ReverseWords obj = new ReverseWords();

        System.out.println(obj.reverseWords(input));
        char[] words=input.toCharArray();
        System.out.println(obj.reverseWords(words));
    }
}