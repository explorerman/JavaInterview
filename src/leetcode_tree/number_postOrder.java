package leetcode_tree;

public class number_postOrder {
    public boolean VerifySquenceOfBST(int [] sequence){
          int length = sequence.length;
          if(length <= 0) return false;
          return VerifySquenceOfBST2(sequence,0,length -1);
    }
    public boolean VerifySquenceOfBST2(int[] sequence,int start,int end){
        if(end <= start) return true;
        int i = start;
        for(; i<end; i++){
            if(sequence[i] > sequence[end]){
                break;
            }
        }
        for(int right = i; right < end; right++){
            if(sequence[right] < sequence[end]){
                return false;
            }
        }
        return VerifySquenceOfBST2(sequence,start,i-1) && VerifySquenceOfBST2(sequence, i,end-1);
    }

}
