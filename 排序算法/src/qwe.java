import java.util.Scanner;

public class qwe {
    private int target;

    public qwe() {
    }
    public long getTime(int target){
        return (long) (target * 3.5);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        qwe test = new qwe();
        System.out.println(test.getTime(x));
    }
}
