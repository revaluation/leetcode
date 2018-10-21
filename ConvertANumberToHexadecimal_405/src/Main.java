public class Main {

    public static void main(String[] args) {
	    var solution = new Solution();
	    var num = 26;
	    System.out.println("" + num + " is 0x" + solution.toHex(num));
        num = -26;
        System.out.println("" + num + " is 0x" + solution.toHex(num));
        num = -(1 << 30);
        System.out.println("" + num + " is 0x" + solution.toHex(num));
        num = -2;
        System.out.println("" + num + " is 0x" + solution.toHex(num));
        num = -(1 << 31);
        System.out.println("" + num + " is 0x" + solution.toHex(num));
    }
}
