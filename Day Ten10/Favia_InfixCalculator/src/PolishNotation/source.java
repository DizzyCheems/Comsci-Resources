/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PolishNotation;

/**
 *
 * @author favia-ju
 */
    import java.util.*;
    import java.util.Scanner;
public class source 
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

 public static int evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();
 
         // Stack for numbers: 'values'
        Stack<Integer> values = new
                              Stack<Integer>();
 
        // Stack for Operators: 'ops'
        Stack<Character> ops = new
                              Stack<Character>();
 
        for (int i = 0; i < tokens.length; i++)
        {
         
            if (tokens[i] == ' ')
                continue;
 
            if (tokens[i] >= '0' &&
                 tokens[i] <= '9')
            {
                StringBuffer sbuf = new
                            StringBuffer();
                 
                // There may be more than one
                // digits in number
                while (i < tokens.length &&
                        tokens[i] >= '0' &&
                          tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Integer.parseInt(sbuf.
                                      toString()));
               
        
                  i--;
            }
 
    
            else if (tokens[i] == '(')
                ops.push(tokens[i]);
 
           
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                  values.push(applyOp(ops.pop(),
                                   values.pop(),
                                 values.pop()));
                ops.pop();
            }
 
           
            else if (tokens[i] == '+' ||
                     tokens[i] == '-' ||
                     tokens[i] == '*' ||
                        tokens[i] == '/')
            {
  
                while (!ops.empty() &&
                       hasPrecedence(tokens[i],
                                    ops.peek()))
                  values.push(applyOp(ops.pop(),
                                   values.pop(),
                                 values.pop()));
 
                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }
 

        while (!ops.empty())
            values.push(applyOp(ops.pop(),
                             values.pop(),
                           values.pop()));
 
       
        return values.pop();
    }
 
 
    public static boolean hasPrecedence(
                           char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') &&
            (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
 

    public static int applyOp(char op,
                           int b, int a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException(
                      "Cannot divide by zero");
            return a / b;
        }
        return 0;
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
    Scanner input= new Scanner(System.in);  
    System.out.println("Enter your Infix Expression:");
    String infixExpression =input.nextLine(); 
    //System.out.println("The Infix Expression is: "+infixExpression);
    String Postfix = convertToPostfix(infixExpression);
    System.out.println("The Postfix of the Infix Expression is: "+Postfix);
    System.out.println("The Prefix of the Infix Expression is: " + convertToPreFix(infixExpression));
      System.out.println("Value of the Expression:" + source.evaluate(infixExpression));
        }
}
