package leetcode_backtracking;

public class test {
    public static void main(String[] args) {
        DFS(0);
    }

    private static void DFS(int index) {
        System.out.println(index);
        if(index == 2){
            return;
        }
        for (int i = 0; i < 3 ; i++) {
            if(i == 2) break;
            DFS(++index);
        }

    }

}
