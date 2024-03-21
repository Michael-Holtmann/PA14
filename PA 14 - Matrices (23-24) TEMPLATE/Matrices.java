/* 
 * Programming Assignment 15 (23-24)
 * Matrices - implements common matrix operations
 */
import java.util.*;

public class Matrices
{
    public static void main(String[] args)
    {
        // create expample matrices
        int[][] A = { {1,2,3}, {2,5,3}, {1,0,8 } }; // nicely invertible
        int[][] B = { {5}, { 3}, {17} }; // nice system ax=b.
        int[][] D = { {2,2,3}, {2,5,3}, {2, -1, 5} }; // (a-d) not invertible.
        int[][] E = { {3, 1}, {-1,4}, {2, 5} };
        
        // Display the inital matrices
        print("A", A);
        print("B", B);
        print("D", D);
        print("E", D);
        
        // The code for the complete main method is in the text box in the project window.
        // I encourage you to type and understand the code yourself and use the provided
        // code as a reference rather than simply copy and pasting!
        //
        
        // (1) Scalar Multiplication
        System.out.printf("\nScalar Multiplication:\n");
        int[][] result = mul(A, 2);
        print("2*A", result );
        
        // (2) Addition and Subtraction
        System.out.printf("\nMatrix Addition:\n");      
       
        System.out.printf("\nMatrix Subtraction:\n");
  
        // (3) Matrix equality
        System.out.printf("\nMatrix Equality:\n");
            
        // (4) Matrix multiplication    
        System.out.printf("\nMatrix Multiplication:\n");
 
        // (5) Identity Matrix   
        System.out.printf("\nIdentity Matrix:\n");

        // (6) Transposition
        System.out.printf("\nTranspose:\n");
           
    }
        
    // (1) Scalar Multiplication
    
    private static int[][] mul( int[][] A, int k)
    {
         int[][] result = new int[A.length][A[0].length];
         for( int r=0; r < A.length; r++)
         {
             for( int c = 0; c < A[r].length; c++)
             {
                result[r][c] = k * A[r][c];
             }
         }
         return result;
    }

    // (2) Addition and Subtraction
    
    private static int[][] add( int[][] a, int[][] b)
    {
        return null;  // change this
    }
        
    // (3) Matrix Equality - equals method
    
    // (4) Multiplication - mul method
      
    // (5) Identity Matrix - id method

    // (6) Transposition - transpose method
   
     
    // PROVIDED METHOD - print a matrix (DON'T CHANGE!)
    //   prints a matrix of ints and dislays a given name for the matrix
    //
    private static void print( String name, int[][] m )
    {
       if( !name.equals("") )
           System.out.printf("Matrix %s:\n" , name);
       
       for( int[] row : m)
       {
           System.out.printf(" |");
           for( int e : row )
           {
              System.out.printf("%4d", e );
           }
           System.out.printf(" |\n");
       }
    }
    
    private static void print1( String name, int[][] m )
    {
       if( !name.equals("") )
           System.out.printf("Matrix %s:\n" , name);
       
       for( int r=0; r < m.length; r++)
       {
           System.out.printf(" |");
           for( int c=0; c < m[0].length; c++)
           {
               System.out.printf("%4d", m[r][c] );
           }
           System.out.printf(" |\n");
       }
       
    }
}

