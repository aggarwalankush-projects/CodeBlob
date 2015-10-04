package ArraysStrings;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverse1("ball"));
        System.out.println(reverse1("racket"));
        System.out.println(reverse2("ball"));
        System.out.println(reverse2("racket"));
    }

    public static String reverse1(String input){
        if (input == null || input.trim().length()==0)
            return input;
        return new StringBuilder(input).reverse().toString();
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static String reverse2(String input) {
        if (input == null || input.trim().length()==0)
            return input;
        char[] strArray=input.toCharArray();
        int start=0;
        int end=input.length()-1;
        while(start<end){
            swap(strArray,start,end);
            start++;
            end--;
        }
        input=String.valueOf(strArray);
        return input;
    }

    private static void swap(char[] strArray, int i, int j){
        char temp=strArray[i];
        strArray[i]=strArray[j];
        strArray[j]=temp;
    }

}
