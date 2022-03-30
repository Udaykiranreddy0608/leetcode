package com.newton.code.strings;

import java.util.Stack;

public class AssignmentCalc {

  public static void main(String[] args) {

    System.out.println(solution("4 5 6 - 7 +"));
  }

  public static int solution(String S) {
    try {
      Stack<Integer> stack = new Stack<Integer>();
      String[] instructionsArray = S.split(" ");

      for (int i = 0; i < instructionsArray.length; i++) {
        switch (instructionsArray[i]) {
          case "DUP":
            stack.push(stack.peek());
            break;
          case "POP":
            stack.pop();
            break;
          case "+":
            int item = stack.pop() + stack.pop();
            if (item > Math.pow(2, 20) - 1) {
              stack.push(-1);
            } else {
              stack.push(item);
            }
            break;
          case "-":
            int t1 = stack.pop();
            int t2 = stack.pop();
            stack.push(t1 - t2);
            break;
          default:
            int itemToAdd = Integer.parseInt(instructionsArray[i]);
            stack.push(itemToAdd);
            break;
        }
      }
      return stack.peek();
    } catch (Exception e) {
      return -1;
    }
  }
}
