package test;

public class MaxSumSequence {


	 public static int solution(int[] seq) {
	        
	        int maxHere = 0;
	        int maxSoFar = 0;
	        
	        for(int i = 0; i < seq.length; i++) {
	            
	            maxHere = 0 > (maxHere + seq[i]) ? 0 : (maxHere + seq[i]);
	            
	            System.out.println(maxHere + " , " + seq[i]);
	            maxSoFar = maxHere > maxSoFar ? maxHere : maxSoFar;
	            
	     
	        }
	        
	        return maxSoFar;
	    }
	
	public static void main(String[] args) {
		
		int[] seq = new int[8];
		seq[0] = 2;
		seq[1] = -6;
		seq[2] = 4;
		seq[3] = 5;
		seq[4] = -2;
		seq[5] = 6;
		seq[6] = 2;
		seq[7] = -1;
		
		int max = MaxSumSequence.solution(seq);
		
		System.out.println(max);

	}
	
}
