import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    var solution = new Solution();
	    var arr = new int[] { 3, 1, 5, -3, -1 };
	    var res = solution.threeSum(arr);
	    System.out.println(Arrays.toString(arr) + ": ");
	    for(var triple : res) {
            var tripleArr = new int[] { triple.get(0), triple.get(1), triple.get(2) };
            System.out.println("  " + Arrays.toString(tripleArr));
        }

        arr = new int[] { -3, -1, 0, 3, 0, 0, 5 };
        res = solution.threeSum(arr);
        System.out.println(Arrays.toString(arr) + ": ");
        for(var triple : res) {
            var tripleArr = new int[] { triple.get(0), triple.get(1), triple.get(2) };
            System.out.println("  " + Arrays.toString(tripleArr));
        }

        arr = new int[] {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        res = solution.threeSum(arr);
        System.out.println(Arrays.toString(arr) + ": ");
        for(var triple : res) {
            var tripleArr = new int[] { triple.get(0), triple.get(1), triple.get(2) };
            System.out.print(" " + Arrays.toString(tripleArr) + ",");
        }

        arr = new int[] {-1,0,1,2,-1,-4};
        res = solution.threeSum(arr);
        System.out.println(Arrays.toString(arr) + ": ");
        for(var triple : res) {
            var tripleArr = new int[] { triple.get(0), triple.get(1), triple.get(2) };
            System.out.print(" " + Arrays.toString(tripleArr) + ",");
        }
    }
}
