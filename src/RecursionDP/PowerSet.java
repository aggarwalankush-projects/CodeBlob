package RecursionDP;

import java.util.ArrayList;

/**
 * Find Power set of a set
 */
public class PowerSet {

    public static void main(String[] args) {
        ArrayList<Character> set = new ArrayList<>();
        set.add('a');
        set.add('b');
        set.add('c');
        System.out.println("Input set: " + set);
        System.out.println("Power set:" + findPowerSet(set));
    }

    /**
     * Time Complexity: O(2^N)
     */
    public static ArrayList<ArrayList<Character>> findPowerSet(ArrayList<Character> set) {
        return findPowerSet(set, 0);
    }

    private static ArrayList<ArrayList<Character>> findPowerSet(ArrayList<Character> set, int index) {
        ArrayList<ArrayList<Character>> powerset;
        if (index == set.size()) {
            //Add empty set
            powerset = new ArrayList<>();
            powerset.add(new ArrayList<>());
        } else {
            powerset = findPowerSet(set, index + 1);
            char item = set.get(index);
            ArrayList<ArrayList<Character>> curPowerSet = new ArrayList<>();
            for (ArrayList<Character> myset : powerset) {
                ArrayList<Character> curSet = new ArrayList<>(myset);
                curSet.add(item);
                curPowerSet.add(curSet);
            }
            powerset.addAll(curPowerSet);
        }
        return powerset;
    }
}
