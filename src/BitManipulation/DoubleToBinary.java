package BitManipulation;

/**
 * Given a Double number between 0 and 1, print the binary representation.
 * If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR."
 */
public class DoubleToBinary {

    public static void main(String[] args) {
        double num = 0.625;
        System.out.println("Decimal Number to binary");
        System.out.println(num + " -> " + doubleToBinary(num));
    }

    public static String doubleToBinary(double num) {
        if (num <= 0 || num >= 1)
            return "Error";
        StringBuilder result = new StringBuilder("0.");
        double fract = 0.5;
        while (num > 0) {
            if (result.length() > 32)
                return "Error";
            if (num >= fract) {
                result.append("1");
                num -= fract;
            } else {
                result.append("0");
            }
            fract /= 2;
        }
        return result.toString();
    }

}


