package BitwiseAndMath;

/**
 * Implement the multiply, subtract, and divide operations for integers.
 * Use only the add operator.
 */
public class ImplementMulSubDiv {

    public static void main(String[] args) {
        int a = 15;
        int b = 4;
        System.out.println("A:" + a + ", B:" + b);
        System.out.println("A-B: " + subtract(a, b));
        System.out.println("A*B: " + multiply(a, b));
        System.out.println("A/B: " + divide(a, b));
    }

    public static int subtract(int a, int b) {
        return a + negate(b);
    }

    private static int negate(int num) {
        int result = 0;
        int a = num > 0 ? -1 : 1;
        while (num != 0) {
            result += a;
            num += a;
        }
        return result;
    }

    public static int multiply(int a, int b) {
        //Improve loop efficiency
        if (a < b)
            return multiply(b, a);
        int result = 0;
        int absB = Math.abs(b);
        for (int i = 0; i < absB; i++)
            result += a;
        return b > 0 ? result : negate(result);
    }

    /**
     * x = a/b can be written as a = x*b
     */
    public static Integer divide(int a, int b) {
        if (b == 0)
            return null;
        int x = 0, prod = 0;
        int absA = Math.abs(a);
        int absB = Math.abs(b);
        while (absB + prod <= absA) {
            prod += absB;
            x++;
        }
        if ((a < 0 && b < 0) || (a > 0 && b > 0))
            return x;
        else
            return negate(x);
    }

}


