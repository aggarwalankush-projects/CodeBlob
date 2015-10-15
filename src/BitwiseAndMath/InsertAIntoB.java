package BitwiseAndMath;

/**
 * Given two 32-bit numbers,A and B, and two bit positions, i and j.
 * Write a method to insert A into B such that A starts at bit j and ends at bit i.
 */
public class InsertAIntoB {

    public static void main(String[] args) {
        int A = Integer.parseInt("1101", 2);
        int B = Integer.parseInt("1000000", 2);
        int i = 1, j = 4;
        System.out.println("A: " + Integer.toBinaryString(A));
        System.out.println("B: " + Integer.toBinaryString(B));
        System.out.println("Insertion Index: (" + j + ", " + i + ")");
        System.out.println("Inserted A into B: " + insert(A, B, j, i));
    }

    public static String insert(int A, int B, int j, int i) {
        int allOnes = ~0;
        int leftMask = allOnes << (j + 1);
        int rightMask = (1 << i) - 1;
        int mask = leftMask | rightMask;
        int clearedB = B & mask;
        int shiftedA = A << i;
        int result = clearedB | shiftedA;
        return Integer.toBinaryString(result);
    }

}


