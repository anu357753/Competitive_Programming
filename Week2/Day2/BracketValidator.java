import java.util.Scanner;

public class BracketValidator {

    public boolean validate(String input){
        Stack<Character> st = new Stack<>();
        for (int i =0; i<input.length(); i++) {
            if (input.charAt(i) =='('|| input.charAt(i) =='[' || input.charAt(i) =='{') {
                st.push(input.charAt(i));
            }

            if (input.charAt(i)==')') {
                if (st.pop()=='(') {
                    continue;
                }
                else {
                    return false;
                }
            }
            if (input.charAt(i)==']') {
                if (st.pop()=='[') {
                    continue;
                }
                else {
                    return false;
                }
            }
            if (input.charAt(i)=='}') {
                if (st.pop()=='{') {
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        if(st.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        String input = sc.nextLine();

        BracketValidator obj = new BracketValidator();

        System.out.println("Bracket validation result : "+obj.validate(input));
    }
}
