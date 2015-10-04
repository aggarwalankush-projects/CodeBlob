package ArraysStrings;

public class ValidRotationString {

    public static void main(String[] args) {
        System.out.println("Valid Rotation of String:");
        System.out.println("ballvolley is rotation of volleyball -> " + validRotation("ballvolley", "volleyball"));
        System.out.println("JAVA is rotation of AAVJ -> " + validRotation("JAVA", "AAVJ"));
    }

    public static boolean validRotation(String first, String second) {
        if (first == null || second == null || first.length() != second.length())
            return false;
        String doubleFirst = first + first;
        return doubleFirst.contains(second);
    }

}
