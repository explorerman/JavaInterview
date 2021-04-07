package 复习资料___设计题;

public class main {
    /*
     * 如果不使用多线程，使用main的话，不管是几个类，都是一个main线程来操作n多对象。
     */
    public static void main(String[] args) {
        System.out.println("main线程" + Thread.currentThread().getName() + Thread.currentThread().getId());
        new test().compute();
    }

    static class test {
        public void compute() {
            int count = 1;
            for (int i = 1; i < 10; i++) {
                count *= i;
            }
            System.out.println(count);
            System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId());
        }
    }
}
