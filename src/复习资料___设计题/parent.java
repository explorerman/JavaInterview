package 复习资料___设计题;

public class parent {
    private final String namePrefix;
    parent(){
        namePrefix = "parent Name";
        System.out.println("parent" + namePrefix);
    }
    protected void compute(){
        int count = 1;
        for (int i = 0; i < 10; i++) {
            count += i;
        }
        System.out.println("parent" + count);
    }

    static class son extends parent{
        son(){
            super();
            System.out.println("son");
        }

        @Override
        protected void compute() {
            super.compute();
            System.out.println("son field");
        }

        public static void main(String[] args) {
            new son().compute();
        }
    }
}
