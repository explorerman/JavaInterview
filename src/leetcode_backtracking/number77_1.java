package leetcode_backtracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class number77_1 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0 || k == 0) return res;
        combineDFS(res,new ArrayList<>(),n,k);
        return res;
    }
    public void combineDFS(List<List<Integer>> result, ArrayList<Integer> level, int n, int k){
//        if(level.size() == k && isSorted(level)){
        if(level.size() == k){
            result.add(new ArrayList<>(level));
            return;
        }
        for (int i = 1; i <= n; i++){
            if(level.contains(i)){
                continue;
            }
            if(level.size() != 0 && level.get(level.size() - 1) > i ){
                continue;
            }else{
                level.add(i);
            }
            combineDFS(result,level,n,k);
            level.remove(level.size() -1);
        }
    }
  /*  private boolean isSorted(List<Integer> listOfStrings) {
        return isSorted(listOfStrings, listOfStrings.size());
    }

    private boolean isSorted(List<Integer> listOfStrings, int index) {
        if (index < 2) {
            return true;
        } else if (listOfStrings.get(index - 2).compareTo(listOfStrings.get(index - 1)) > 0) {
            return false;
        } else {
            return isSorted(listOfStrings, index - 1);
        }
    }*/
  public static boolean isSorted(List<Integer> listOfStrings) {
      if (listOfStrings.size() < 2) {
          return true;
      }
      Iterator<Integer> iter = listOfStrings.iterator();
      Integer current, previous = iter.next();
      while (iter.hasNext()) {
          current = iter.next();
          if (previous.compareTo(current) > 0) {
              return false;
          }
          previous = current;
      }
      return true;
  }
    public static void main(String[] args) {
        new number77().combine(4,2);
    }
}
