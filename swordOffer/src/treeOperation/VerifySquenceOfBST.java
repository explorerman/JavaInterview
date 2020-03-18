package treeOperation;

public class VerifySquenceOfBST {

	public boolean VerifySquenceOfBST(int[] sequence){
		int size = sequence.length;
		if(0 == size) return false;
		int i = 0;
		while(--size > 0){ //先做--，放置size越界
			while(sequence[i++] < sequence[size] && i < size);
			while(sequence[i++] > sequence[size] && i < size);
			
			if(i < size) return false;
			i = 0;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
