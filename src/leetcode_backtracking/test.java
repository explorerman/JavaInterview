package leetcode_backtracking;

public class test {
    public static void main(String[] args) {
        DFS(0);
    }

    private static void DFS(int index) {
        if(index == 6){
            System.out.println(index);
            return;
        }
        for (int i = 0; i != 4 ; i++) {
            DFS(index + 1);
        }

    }

}
