
import java.util.*;
class Postfix {

      StringTokenizer expression;
      Stack<Integer> numberStack = new Stack<Integer>();

      Postfix(String input) {
        this.expression = new StringTokenizer(input);
      }

      public int evaluate() {
        while(expression.hasMoreTokens()) {
          String token = expression.nextToken();
          if(token.equals("+")|| token.equals("-")||token.equals("*")||token.equals("/")) {
            //operator are to be evaluated
             BiEval(token.charAt(0));
          }
          else {
            //push number to stack
            numberStack.push(Integer.valueOf(token));
          }
        }
      return numberStack.pop();
      }

      private void BiEval(char operator) {
        int second = numberStack.pop();
        int first = numberStack.pop();
        int result=-1;
        switch(operator)  {
          case '+':
              result = first + second;
              break;
          case '-':
              result = first - second;
              break;
          case '*':
              result = first * second;
              break;
          case '/':
              result = first / second;
              break;
          // operator doesn't match any case constant (+, -, *, /)
          default:
              System.out.printf("Error! operator is not correct");
              return;
      }
      numberStack.push(result);
      }

      public static void main(String[] args )  {
        Postfix pf = new Postfix("1 2 3 4 5 * + * +");
        System.out.println(pf.evaluate());
      }
}
