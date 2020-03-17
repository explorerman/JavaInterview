package LeetCode_greedy;

public class number605 {
     //flowerbed = [1,0,0,0,1], n = 1  [1,0,0,0,0,1]  [0,0,1,0,0] [0,0,0,1]
     //1
     //1
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n >= flowerbed.length || flowerbed.length == 0) return false;
        if(flowerbed.length == 1) return true;
        for (int i = 0; i < flowerbed.length; i=i+1){
            if(n == 0) return true;
            if(flowerbed[i] == 0){
                int pre = (i == 0 ? 0 : flowerbed[i - 1]);
                int next = (i == flowerbed.length - 1 ? 0 : flowerbed[i + 1]);
                if(pre + next == 0){
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }
}
