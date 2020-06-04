package JUC_pv;

public class Test {
    public int test(int n){
        if(n == 1) return 1;
         return n *= test(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Test().test(3));
    }
}
