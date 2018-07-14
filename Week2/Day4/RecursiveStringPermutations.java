import java.util.HashSet;
import java.util.Scanner;

public class RecursiveStringPermutations {
    public HashSet<String> stringPermutations(String prefix, String s,HashSet<String> set){
        int n = s.length();
        if (n==0) {
            set.add(prefix);
        }
        else {
            for (int i=0; i<n; i++) {
                stringPermutations(prefix+s.charAt(i), s.substring(0,i) + s.substring(i+1,n),set);
            }
        }

        return set;
    }

    public HashSet<String> generatePermutations(String s,HashSet<String> set){
        return stringPermutations("",s,set);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        String input = sc.nextLine();
        System.out.println("String Permutaions are : ");
        HashSet<String> set = new HashSet<String>();
        RecursiveStringPermutations obj = new RecursiveStringPermutations();
        obj.generatePermutations(input,set);
        for(String s:set)
        {
            System.out.println(s);
        }
    }
}
