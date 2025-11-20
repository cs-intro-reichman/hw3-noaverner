// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		System.out.println(plus(2, 3)); // 2 + 3
		System.out.println(minus(7, 2)); // 7 - 2
		System.out.println(minus(2, 7)); // 2 - 7
		System.out.println(times(3, 4)); // 3 * 4
		System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
		System.out.println(pow(5, 3)); // 5^3
		System.out.println(pow(3, 5)); // 3^5
		System.out.println(div(12, 3)); // 12 / 3
		System.out.println(div(5, 5)); // 5 / 5
		System.out.println(div(25, 7)); // 25 / 7
		System.out.println(mod(25, 7)); // 25 % 7
		System.out.println(mod(120, 6)); // 120 % 6
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int result = x1;
		if (x2 >= 0) {
			while (x2 != 0) {
				result++;
				x2--;
			}
		} else {
			while (x2 != 0) {
				result--;
				x2++;
			}
		}
		return result;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		return plus(x1, -x2);
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int result = 0;
		boolean negative = false;

		if (x2 < 0) {
			x2 = -x2;
			negative = true;
		}

		while (x2 != 0) {
			result = plus(result, x1);
			x2--;
		}

		if (negative) {
			result = -result;
		}
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int result = 1;
		while (n != 0) {
			result = times(result, x);
			n--;
		}
		return result;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		if (x2 == 0)
			throw new ArithmeticException("Division by zero");
		int quotient = 0;
		boolean negative = false;

		if (x1 < 0) {
			x1 = -x1;
			negative = !negative;
		}
		if (x2 < 0) {
			x2 = -x2;
			negative = !negative;
		}

		while (x1 >= x2) {
			x1 = minus(x1, x2);
			quotient++;
		}

		if (negative)
			quotient = -quotient;
		return quotient;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x2 == 0)
			throw new ArithmeticException("Modulo by zero");
		int quotient = div(x1, x2);
		int product = times(quotient, x2);
		return minus(x1, product);
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		if (x < 0)
			throw new ArithmeticException("Square root of negative number");
		int result = 0;
		while (times(result, result) <= x) {
			result++;
		}
		return --result; // step back once
	}
}
