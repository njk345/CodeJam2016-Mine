import java.util.*;
public class Tester {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter Stack: ");
    String stack = s.nextLine();
    System.out.println(solveProblem(stack));
  }
  public static int solveProblem(String stack) {
    char top = stack.charAt(0);
    if (stack.length() == 1 && top == '+') return 0;
    char bottom = stack.charAt(stack.length() - 1);
    if (bottom == '+') return solveProblem(stack.substring(0, stack.length() - 1));
    if (top == '+') {
      String topFlipped = "-" + stack.substring(1);
      return 1 + solveProblem(topFlipped);
    } else {
      String wholeFlipped = flip(stack);
      return 1 + solveProblem(wholeFlipped);
    }
  }
  public static String flip(String s) {
    String flipped = "";
    for (int i = 0; i < s.length(); i++) {
      flipped += s.charAt(s.length() - 1 - i) == '+'? '-' : '+';
    }
    return flipped;
  }
}
