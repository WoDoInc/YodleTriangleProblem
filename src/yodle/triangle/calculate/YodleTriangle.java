package yodle.triangle.calculate;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class YodleTriangle {
	
	/** The resource file for the problem. */
	private final File file = new File("./resource/triangle.txt");
	
	/** We statically know that the maximum number of rows are 100. */
    private final int rows = 100;
    
    /** The number matrix for the triangle. */
    private final int[][] numbers = new int[rows][];

    /**
     * Parses the resource file, then returns the stored matrix of the triangle.
     * 
     * @throws IOException Thrown if unable to handle file properly.
     */
    public void parseFile() throws IOException {
    	final Scanner scanner = new Scanner(file);
    	scanner.useDelimiter(System.getProperty("line.separator"));
		for (int i = 0; i < rows; i++) {
			numbers[i] = new int[i + 1];
			String[] line = scanner.next().split(" ");
			for (int j = 0; j <= i; j++) {
				numbers[i][j] = Integer.parseInt(line[j]);
			}
		}
    	scanner.close();
    }
    
    /**
     * Finds the solution for the given matrix. Instead of working from top to bottom, which would require
     * a potentially more complicated data structure. Work from bottom to top.
     * 
     * @param numbers The triangle matrix to solve.
     * @return Returns the maximum total for the given triangle.
     */
    public int getSolution() {
    	for (int i = rows - 2; i >= 0; i-- ) {
			// Replace numbers with the sum of itself and the bigger adjacent number.
            for (int j = 0; j <= i; j++) {
            	if (numbers[i + 1][j] > numbers[i + 1][j + 1])
            		numbers[i][j] += numbers[i + 1][j];
                else
                	numbers[i][j] += numbers[i + 1][j + 1];
            }
        }
    	// Return the maximum calculated total (top value).
    	return numbers[0][0];
    }
    
    public static void main(String[] args) {
    	YodleTriangle triangle = new YodleTriangle();
    	try {
    		triangle.parseFile();
			System.out.println("Maximum Total: " + triangle.getSolution());
		} catch (IOException e) {
			System.err.println("Error handling file: " + e);
			e.printStackTrace();
			System.exit(1);
		}
    	System.exit(0);
    }
}
