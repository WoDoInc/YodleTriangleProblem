package yodle.triangle.graph;

/**
 * For the sake of comparison, this class is created for a potential graphical solution.
 * Currently this class is unused.
 * 
 * @author Alex Kaszczuk
 */
public class Graph {

    private int value, id;

    /**
     * 
     * Constructor
     * @param a
     * @param b 
     */
    public Graph(int a, int b) {
        value = a;
        id = b;
    }

    public int getID() {
        return id;
    }
    
   public int getValue() {
       return value;
   }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}