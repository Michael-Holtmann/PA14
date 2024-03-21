public static void main(String[] args)
    {
        // create expample matrices
        double[][] A = { {1,2,3}, {2,5,3}, {1,0,8 } }; // nicely invertible
        double[][] B = { {5}, { 3}, {17} }; // nice system ax=b.
        double[][] C = { {2, -5}, {-1, 3} };   // nicely invertible
        double[][] D = { {2,2,3}, {2,5,3}, {2, -1, 5} }; // (a-d) not invertible.
        double[][] E = { {3, 1}, {-1,4}, {2, 5} };
        
        // Display the inital matrices
        print("A", A);
        print("B", B);
        print("C", C);
        print("D", D);
        print("E", D);
        
        // (1) Scalar Multiplication
        System.out.printf("\nScalar Multiplication:\n");
        double[][] result = mul(A, 2.0);
        print("2*A", result );
        
        // (2) Addition and Subtraction
        System.out.printf("\nMatrix Addition:\n");
        result = add( A, D);
        if( result != null)
            print("A+D", result );
        else
            System.out.printf("A + D undefined. Matrices not of the same dimension.\n");
            
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
        
        // (7) submatrix
        System.out.printf("\nsubmatrix:\n");
        result = submatrix(A, 1, 2);
        print("submatrix(A,1,2)", result);
        
        result = submatrix(A, 1, 1);
        print("submatrix(A,1,1)", result);
        
        // (8) minor and cofactor
        System.out.printf("\nMinor and Cofactor:\n");
        System.out.printf("minor(A, 1, 2) is %.3f\n", minor(A, 1, 2) );
        System.out.printf("cofactor(A, 1, 2) is %.3f\n", cofactor(A, 1, 2) );
        System.out.printf("minor(A, 1, 1) is %.3f\n", minor(A, 1, 1) );
        System.out.printf("cofactor(A, 1, 1) is %.3f\n", cofactor(A, 1, 1) );
        
        // OPTIONAL METHODS - EXTENDING ASSIGNMENT
        
        // (9) the adjoint
        System.out.printf("\nAdjoint Matrices:\n");
        result = adj(A);
        print("adj(A)", result);
        result = adj(B);
        if( result == null )
           System.out.printf("B has no adjoint; it is not square.\n");
        else
           print("adj(B)", result);
           
        // (10) Inverse method
        System.out.printf("\nInverse Matrices:\n");
        result = inverse(A);
        print("inverse(A)", result);
        // Verify result!
        if( equals( mul(A, result), id( A.length ) ) )
           System.out.printf("The inverse(A) is correct since A * inverse(A) = I.\n");
        else
           System.out.printf("The inverse(A) is not correct since A * inverse(A) != I.\n");
           
        result = inverse( sub(A, D) );
        if( result == null)
           System.out.printf("(A-D) does NOT have an inverse since det(A-D)=0.\n");
        else
           print("inverse(A-D)", result);
           
    }
