package StacksQueues;

/**
 * Solve Tower of Hanoi using Stacks
 */
public class TowerOfHanoi {

    public static void main(String[] args) {
        int n = 3;
        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++)
            towers[i] = new Tower(i);
        for (int i = n - 1; i >= 0; i--)
            towers[0].add(i);
        towers[0].moveDisks(n, towers[2], towers[1]);
    }
}

class Tower {
    private Stack<Integer> disks;
    private int index;

    public Tower(int index) {
        this.index = index;
        disks = new Stack<>();
    }

    public int getIndex() {
        return index;
    }

    public void add(int disk) {
        if (!disks.isEmpty() && disks.peek() <= disk)
            System.out.println("Error placing disk " + disk);
        else
            disks.push(disk);
    }

    public void moveTopTo(Tower tower) {
        int top = disks.pop();
        tower.add(top);
        System.out.println("Move disk " + top + " from tower " + getIndex() + " to " + tower.getIndex());
    }

    public void moveDisks(int n, Tower destination, Tower buffer) {
        if (n <= 0)
            return;
        moveDisks(n - 1, buffer, destination);
        moveTopTo(destination);
        buffer.moveDisks(n - 1, destination, this);
    }
}

