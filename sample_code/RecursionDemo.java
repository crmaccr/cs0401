import java.util.Scanner;

public class RecursionDemo {

    // A recursive method is one that calls itself.
    // Here is a toy recursive method.
    // Could this be done more easily with a loop
    // (iterative execution)?  Yup!  In Java, iterative
    // execution is MUCH faster than doing things recursively.

    // Why might this be?  Well, every time you call a method,
    // you are making an entirely new stack frame (remember
    // from class, like constructing a whole new "Narnia"
    // world).  This is computationally expensive.  Recursive
    // methods make many new stack frames.

    // ANY recursive method can be converted to an iterative
    // method, or vice-versa.  They are two sides of the same
    // coin.

    // Why would you want to do things recursively, then?
    // 1. It's often a much more elegant solution
    // 2. It's often much simpler & easier to understand
    // 3. Performance is not always the #1 priority
    // 4. Other languages (especially ones with tail-call
    //    optimization) do not have this issue!  Recursive
    //    solutions are as fast as iterative solutions.
    //    For example, Haskell doesn't even HAVE a concept
    //    of loops - you have to do recursion.
    // 5. It's an important concept to learn!
    
    public static void recursivePrint(int n) {
	if (n == 0) {
	    // BASE CASE - execution stops here
	    // NOTE no recursive call!
	    System.out.println("0");
	} else {
	    // RECURSIVE CASE - execution continues
	    // NOTE it has a recursive call!
	    System.out.println(n);
	    recursivePrint(n-1);
	}
    }

    
    //  Perhaps the simplest
    // example of an actual recursive method is calculating the triangular numbers,
    // 1, 3, 6, 10, 15, 21...  These numbers simulate making a "triangle" of
    // different size:
    //   1       2         3        4          5
    //   *       *         *        *          *
    //          * *       * *      * *        * *
    //                   * * *    * * *      * * *
    //                           * * * *    * * * *
    //                                     * * * * *
    //
    //   1       3         6        10        15
    //
    // Each time you add a row to the triangle, you increase by one more than
    // the previous amount you increased by (going from 1 to 2, you increase by 2;
    // going from size 2 to 3, you increase by 3; going from 3 to 4, you increase
    // by 4, etc.
    //
    // We can calculate this by making a recursive method.  If we have reached the
    // smallest amount, add 1.  Otherwise, add the current number + triangle(number - 1).
    // For example, asking for triangle(5) will expand to:
    //
    //   5 + (triangle(4))
    //
    // triangle(4) expands to: 4 + triangle(3), and triangle(3) expands to
    // (3 + triangle(2), etc., leaving us with:
    //
    //   5 + 4 + 3 + 2 + 1, or 15
    //
    // Recursive methods have a BASE CASE and one or more RECURSIVE CASES.
    // The base case does not recurse (call the same method); recursive cases do.
    
    public static int triangle(int num) {

	if (num == 1) {
	    // Base case - no recursion
	    // All recursive methods must have a base case!
	    // Otherwise it will never exit the method, just constantly recurse.
	    // Thread.dumpStack();
	    return 1;
	} else {
	    // Recursive case - recursion takes place here
	    return num + triangle(num - 1);
	}
    }

    // The Fibonacci Sequence is the series of numbers found by starting
    // with 0, 1, 1.. and the next number is the sum of the previous two numbers.
    // For example, 0 + 1 = 1, so the next number in the Fibonacci sequence is 1.
    // 1 + 1 is 2, so the third number is 2.  2 + 1 is 3, so the fourth number is 3.
    // etc. - 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, etc.

    // This can very easily be calculated recursively.  For the nth number, if n
    // is 1, then return 1.  Otherwise, return whatever the results of the
    // last two elements of the Fibonacci sequence are, by calling the Fibonacci
    // method again.
    
    public static long fibonacci(long num) {
	if (num <= 1) {
	    // BASE CASE
	    return num;
	} else {
	    // RECURSIVE CASE
	    System.out.println("Fib(" + num + ") = " +  fibonacci(num - 1) + " + " + fibonacci(num - 2));
	    return fibonacci(num - 1) + fibonacci(num - 2);
	}
    }
    
    public static void main(String[] args) {
	
	int num = -1;
	
	if (args.length >= 1) {
	    num = Integer.parseInt(args[0]);
	    if (num <= 0) {
		printErrorAndDie();
	    }
	} else {
	    printErrorAndDie();
	}

	recursivePrint(num);

	System.exit(0);
	
	long fib = fibonacci(num);

	int tri = triangle(num);

	System.out.println("Fib(" + num + ") = " + fib);
	System.out.println("Tri(" + num + ") = " + tri);
    }

    // Print error message and end program
    public static void printErrorAndDie() {
	System.out.println("Program requires one argument, a positive integer.");
	System.exit(1);
    }

    
}
