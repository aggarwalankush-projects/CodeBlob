package BitManipulation;

/**
 * Find the number of bits required to convert integer A to integer B.
 */
public class BitsToConvertAIntoB {

    public static void main(String[] args) {
        int A = 40;
        int B = 54;
        System.out.println("A: " + Integer.toBinaryString(A));
        System.out.println("B: " + Integer.toBinaryString(B));
        System.out.println("Bits to convert A into B -> " + countBitsToConvert(A, B));
    }

    public static int countBitsToConvert(int A, int B) {
        int count = 0;
        //i&(i-1) clears the LSB
        for (int i = A ^ B; i != 0; i &= (i - 1))
            count++;
        return count;
    }

}


