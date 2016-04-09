import java.util.*;
import java.io.*;
public class CountingSheep {
  public static final String outputFile = "output_file.txt";
	public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Name of Input File (w/ extension): ");
    String inputFile = scan.nextLine();
    ArrayList<Integer> problems = getProblems(inputFile);
    ArrayList<String> solutions = new ArrayList<>();
    for (int p : problems) {
      long s = solveProblem(p);
      if (s == -1) solutions.add("INSOMNIA");
      else solutions.add("" + s);
    }
    writeSolutions(solutions);
	}
  public static long solveProblem(int n) {
    if (n == 0) return -1;
    int[] freqs = new int[10];
    long currSheep = 0;
    for (int i = 1; !isFilled(freqs); i++) {
      currSheep = n * i;
      String sheepStr = "" + currSheep;
      for (int j = 0; j < sheepStr.length(); j++) {
        int index = Character.getNumericValue(sheepStr.charAt(j));
        freqs[index]++;
      }
    }
    return currSheep;
  }
  public static boolean isFilled(int[] a) {
    for (int i : a) {
      if (i == 0) return false;
    }
    return true;
  }
	public static ArrayList<Integer> getProblems(String inputFile) {
		ArrayList<Integer> problems = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			br.readLine(); //ignore number of cases line
			String line;
			while ((line = br.readLine()) != null) {
				problems.add(Integer.parseInt(line));
			}
      br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return problems;
	}
public static void writeSolutions (ArrayList<? extends Object> solutions) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
			for (int i = 0; i < solutions.size(); i++) {
				bw.write("Case #" + (i+1) + ": ");
				bw.write(solutions.get(i).toString());
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
