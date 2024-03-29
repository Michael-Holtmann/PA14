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
    int[][] A = { {1,2,3},
                  {2,5,3}, 
                  {1,0,8}};
  
    int[][] B = { {5}, 
                  {3}, 
                  {17} }; // nice system ax=b.
  
    int[][] D = { {2,2,3}, 
                  {2,5,3}, 
                  {2,-1,5} }; // (a-d) not invertible.
  
    int[][] E = { {3, 1}, 
                  {-1,4}, 
                  {2, 5} };
    
    // Display the inital matrices
    // print("A", A);
    // print("B", B);
    // print("D", D);
    // print("E", E);
    
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
    result = add( A, D);
    
    if( result != null)
      print("A+D", result );
      
    else
      System.out.printf("A + D undefined. Matrices not same dimension.\n");
    
    result = add( A, B);
    if( result != null)
      print("A+B", result );
      
    else
      System.out.printf("A + B undefined. Matrices not of the same dimension.\n");
    
    System.out.printf("\nMatrix Subtraction:\n");
    result = sub(A, D);
    
    print("A-D", result );

    
    // (3) Matrix equality
    System.out.printf("\nMatrix Equality:\n");
    if( equals( A, A ) )
      System.out.printf("Matrices A and A are equal!\n");
      
    else
      System.out.printf("Matrices A and A are NOT equal.\n");
    
    if( equals( A, B ) )
      System.out.printf("Matrices A and B are equal!\n");
      
    else
      System.out.printf("Matrices A and B are NOT equal.\n");
    
        
    // (4) Matrix multiplication    
    System.out.printf("\nMatrix Multiplication:\n");
    result = mul(A,B);
    
    if( result != null)
      print("A*B", result);
      
    else
      System.out.printf("The product A*B is not defined.\n");
    
    result = mul(B,A);
    if( result != null)
      print("B*A", result);
      
    else
      System.out.printf("The product B*A is not defined.\n");
  
  
    // (5) Identity Matrix   
    System.out.printf("\nIdentity Matrix:\n");
    result = id(5);
    
    print("I(5)", result);
    
    result = id( -4 );
    if( result != null)
      print("I(-4)", result);
      
    else
      System.out.printf("There is no I(-4) identity matrix.\n");
  
    // (6) Transposition
    System.out.printf("\nTranspose:\n");
    result = transpose( E );
    
    print("transpose(E)", result);
    
    result = transpose( B );
    
    print("transpose(B)", result);
         
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
        int[][] sum = new int[a.length][a[0].length];

        if (a.length != b.length || a[0].length != b[0].length) {
          return null;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }

    return sum;
    }
    private static int[][] sub(int[][] a, int[][] b){
        int[][] difference = new int[a.length][a[0].length];

        if (a.length != b.length || a[0].length != b[0].length) {
          return null;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                difference[i][j] = a[i][j] - b[i][j];
            }
        }

    return difference;
    }
        
    // (3) Matrix Equality - equals method

    private static boolean equals(int[][] a, int[][] b){
      if (a.length != b.length || a[0].length != b[0].length) return false;

      for (int i = 0; i < a.length; i++){
        for (int j = 0; j < a[0].length; j++){
          if (a[i][j] != b[i][j]) return false;
        }
      }

      return true;
    }
    // (4) Matrix Multiplication - mul method
    // overloaded method
    private static int[][] mul(int[][] a, int b[][]){
        if (a[0].length != b.length) return null;

        int[][] resultant = new int[a.length][b[0].length];

        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < b[0].length; j ++){
                int sum = 0;
                for (int d = 0; d < b.length; d++){
                    sum += (a[i][d] * b[d][j]);
                }
                resultant[i][j] = sum;
            }
        }


        return resultant;
    }
      
    // (5) Identity Matrix - id method
  private static int[][] id(int n){
    if (n < 1) return null;
    
    int[][] result = new int[n][n];

    for (int i = 0; i < n; i++){
      for (int j = 0; j<n; j++){
        if (i == j) result[i][j] = 1;
        else result[i][j] = 0;
      }
    }
      

    return result;
  }

    // (6) Transposition - transpose method

  private static int[][] transpose(int[][] a){
    int[][] result = new int[a[0].length][a.length];
    
    for (int i = 0; i < a.length; i++) {
      for(int j = 0; j < a[0].length; j++){
        result[j][i] = a[i][j];
      }
    }

    return result;
  }
   
     
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

