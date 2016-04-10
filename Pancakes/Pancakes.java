import java.util.*;
import java.io.*;
public class Pancakes {
    public static final String inputFile = "B-small-attempt0.in.txt";
    public static final String outputFile = "B_output.txt";
    public static void main(String[] args) {
        System.out.println("\f");
        ArrayList<String> problems = getProblems(inputFile);
        ArrayList<Integer> solutions = new ArrayList<>();
        for (String p : problems) {
            int s = solveProblem(p);
            solutions.add(s);
        }
        writeSolutions(solutions);
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

    public static ArrayList<String> getProblems(String inputFile) {
        ArrayList<String> problems = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            br.readLine(); //ignore number of cases line
            String line;
            while ((line = br.readLine()) != null) {
                problems.add(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return problems;
    }

    public static void writeSolutions (ArrayList<Integer> solutions) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
            for (int i = 0; i < solutions.size(); i++) {
                int s = solutions.get(i);
                bw.write("Case #" + (i+1) + ": " + s);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
