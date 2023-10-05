/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */


import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Cheemscake
 */

public class Infix-Eval-GUI 
{
    public static int order(char ch)
    {
    if(ch=='+' || ch=='-')
    return 1;
    else if(ch == '^'|| ch=='*' || ch=='/')
    return 2;       
    return 0;
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
    while(operators.size()>0 && operators.peek()!='(' && order(ch) <= order(operators.peek()))
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


    public static StringBuilder convertToPreFix(String expression){

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

          
            if(order(c)>0){
                while(stack.isEmpty()==false && order(stack.peek())>=order(c)){
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
              
                result.append(c);
            }
        }

        for (int i = 0; i <=stack.size() ; i++) {
            result.append(stack.pop());
        }
        return result.reverse();
    }

     public static void main(String args[])
    { 
    String infixExpression = JOptionPane.showInputDialog( "Enter your Infix Expression");
    String Postfix = convertToPostfix(infixExpression);
    JOptionPane.showMessageDialog(null, "The Postfix of the Infix Expression is:" + Postfix);
    JOptionPane.showMessageDialog(null, "The Prefix of the Infix Expression is:" + convertToPreFix(infixExpression));
       }
}
