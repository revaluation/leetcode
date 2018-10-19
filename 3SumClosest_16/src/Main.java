import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        var solution = new Solution();
        var arr = new int[] { 10, 1, 3, 2 };
        var target = 10;
        var closest = solution.threeSumClosest(arr, target);
        System.out.println(Arrays.toString(arr) + ", target = " + target + ": closest is " + closest);

        arr = new int[] { 10, 1, 0, 2 };
        target = 12;
        closest = solution.threeSumClosest(arr, target);
        System.out.println(Arrays.toString(arr) + ", target = " + target + ": closest is " + closest);

        arr = new int[] { 5, 5, 5 };
        target = 15;
        closest = solution.threeSumClosest(arr, target);
        System.out.println(Arrays.toString(arr) + ", target = " + target + ": closest is " + closest);

        arr = new int[] { 5, 5, 5 };
        target = 14;
        closest = solution.threeSumClosest(arr, target);
        System.out.println(Arrays.toString(arr) + ", target = " + target + ": closest is " + closest);

        arr = new int[] { -1, 2, 1, -4};
        target = 1;
        closest = solution.threeSumClosest(arr, target);
        System.out.println(Arrays.toString(arr) + ", target = " + target + ": closest is " + closest);
    }
}
