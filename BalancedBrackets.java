
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        String input1 = "( [ [ { } ] ] )";
        String input2 = "( [ [ { } ] ] ) )";
        if(checkBalancedBrackets(input1) == true)
        {
          System.out.println("The entered String has Balanced Brackets");
        }
        else
        {
           System.out.println("The entered Strings do not contain Balanced Brackets"); 
        }
        
        if(checkBalancedBrackets(input2) == true)
        {
          System.out.println("The entered String has Balanced Brackets");
        }
        else
        {
           System.out.println("The entered Strings do not contain Balanced Brackets"); 
        }
        
    }

    public static boolean checkBalancedBrackets(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char topChar = stack.pop();

                if (ch == ')' && topChar != '(') {
                    return false;
                } else if (ch == '}' && topChar != '{') {
                    return false;
                } else if (ch == ']' && topChar != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
