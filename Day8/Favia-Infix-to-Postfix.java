import java.util.*;
import java.util.Scanner;
public class Favia-Infix-to-Postfix
{
public static int precedence(char ch)
{
if(ch=='+' || ch=='-')
return 1;
else if(ch == '^'|| ch=='*' || ch=='/')
return 2;       
  return 0;
}


    static StringBuilder infixToPreFix(String expression){

        StringBuilder result = new StringBuilder();
        StringBuilder input = new StringBuilder(expression);
        input.reverse();
        Stack<Character> stack = new Stack<Character>();

        char [] charsExp = new String(input).toCharArray();
        for (int i = 0; i < charsExp.length; i++) {

            if (charsExp[i] == '(') {
                charsExp[i] = ')';
                i++;
            }
            else if (charsExp[i] == ')') {
                charsExp[i] = '(';
                i++;
            }
        }
        for (int i = 0; i <charsExp.length ; i++) {
            char c = charsExp[i];

            //check if char is operator or operand
            if(precedence(c)>0){
                while(stack.isEmpty()==false && precedence(stack.peek())>=precedence(c)){
                    result.append(stack.pop());
                }
                stack.push(c);
            }else if(c==')'){
                char x = stack.pop();
                while(x!='('){
                    result.append(x);
                    x = stack.pop();
                }
            }else if(c=='('){
                stack.push(c);
            }else{
                //character is neither operator nor "("
                result.append(c);
            }
        }

        for (int i = 0; i <=stack.size() ; i++) {
            result.append(stack.pop());
        }
        return result.reverse();
    }

public static String convertToPostfix(String exp)
{
Stack<Character> operators = new Stack<>();
Stack<String> postFix = new Stack<>();
for(int i=0;i<exp.length();i++)
{
  char ch=exp.charAt(i);         
  if(ch=='(')
   operators.push(ch);

  else if((ch>='0' && ch<='9') || (ch>='0' && ch<='9'))
   postFix.push(ch+"");
  else if(ch==')')
  {
   while(operators.peek()!= '(')
   {
    char op = operators.pop();
    String first = postFix.pop();          
    String second = postFix.pop();
    String new_postFix = second+first+op;  
    postFix.push(new_postFix);     
   }
   operators.pop();    
  }
  else if(ch=='+' || ch=='-' || ch== '*' || ch== '/'|| ch=='^')
  {
   while(operators.size()>0 && operators.peek()!='(' && precedence(ch) <= precedence(operators.peek()))
   {
   char op = operators.pop();
 
   String first = postFix.pop();
   String second = postFix.pop();
 
   String new_postFix = second+first+op;
 
   postFix.push(new_postFix);
   }
 
  operators.push(ch);
  }
}
while(operators.size()>0)
{
  char op = operators.pop();
 
  String first = postFix.pop();
  String second = postFix.pop();
 
  String new_postFix = second+first+op;
 
  postFix.push(new_postFix);
  }
 
  return postFix.pop();       
}
public static void main(String args[])
{
  Scanner input= new Scanner(System.in);  
  System.out.println("Enter your Infix Expression");
  String infixExpression =input.nextLine(); 
  System.out.println("The Infix Expression is: "+infixExpression);
  String result = convertToPostfix(infixExpression);
  System.out.println("The Postfix of the given Infix Expression is: "+result);
 
}
}
 