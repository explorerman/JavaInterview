package JUC_pv;

public class JoinExample {
    private class A extends Thread {
        private int i = 1;
        @Override
        public void run() {
            try {
                int count = count();
                System.out.printf("A"+"_count_"+count);
//                throw new Exception("A发生了错误");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public int count(){
            return i+2;
        }
    }

    private class B extends Thread {
        private A a;
        B(A a){
            this.a = a;
        }
        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("B");
        }
    }

    public void test(){
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }

    public static void main(String[] args) {
        JoinExample joinExample = new JoinExample();
        joinExample.test();
    }
}
