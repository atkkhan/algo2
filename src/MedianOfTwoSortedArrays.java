
public class MedianOfTwoSortedArrays {
	
	    private static final int ERROR_INVALID_INPUT = -1; // change value of this const as per your specific requirement
	     
	    public int max(int a, int b)
	    {
	        if (a > b) return a;
	        return b;
	    }
	      
	    public int min(int a, int b)
	    {
	        if (a < b) return a;
	        return b;
	    }
	      
	    private double findMedian(int[] array, int startIndex, int endIndex)
	    {
	        int indexDiff = (endIndex - startIndex);
	        if (indexDiff % 2 == 0) // we are looking at odd number of elements
	            return array[startIndex + (indexDiff/2)];
	        else
	            return 1.0*(array[startIndex + (indexDiff/2)] + array[startIndex + (indexDiff/2) + 1])/2;
	    }
	     
	    // a: 1,2,5,11,15  // b: 3 4 13 17 18
	    public double findMedianSortedArrays(int[] a, int[] b, int startIndexA, int endIndexA, int startIndexB, int endIndexB)
	    {
	        
	        if ((endIndexA - startIndexA < 0) || ((endIndexB - startIndexB < 0))){
	            System.out.println("Invalid Input.");
	            return ERROR_INVALID_INPUT;
	        }
	 
	        if ((endIndexA - startIndexA == 0) && ((endIndexB - startIndexB == 0))){
	            return (a[0] + b[0])/2;
	        }
	         
	        if ((endIndexA - startIndexA == 1) && ((endIndexB - startIndexB == 1))){
	            return (1.0*(max(a[startIndexA], b[startIndexB]) + min(a[endIndexA], b[endIndexB])))/2;
	        }
	          
	        double m1 = findMedian(a, startIndexA, endIndexA);
	        double m2 = findMedian(b, startIndexB, endIndexB);
	          
	        if (m2 == m1){
	            return m2;
	        }
	          
	        // since m1 <= median <= m2 narrow down search by eliminating elements less than m1 and elements greater than m2  
	        if (m1 < m2){
	            if ((endIndexA - startIndexA) % 2 == 0){ // we are looking at odd number of elements
	                startIndexA = startIndexA + (endIndexA - startIndexA) / 2;
	                endIndexB = startIndexB + (endIndexB - startIndexB) / 2;
	            }
	            else{
	                startIndexA = startIndexA + (endIndexA - startIndexA) / 2;
	                endIndexB = startIndexB + (endIndexB - startIndexB) / 2 + 1;                
	            }
	        }
	          
	        // since m2 <= median <= m1 narrow down search by eliminating elements less than m2 and elements greater than m1
	        else{ // m2 < m1
	        
	            if ((endIndexB - startIndexB) % 2 == 0){ // we are looking at odd number of elements	            
	                startIndexB = startIndexB + (endIndexB - startIndexB) / 2;
	                endIndexA = startIndexA + (endIndexA - startIndexA) / 2;
	            }
	            else{
	                startIndexB = startIndexB + (endIndexB - startIndexB) / 2;
	                endIndexA = startIndexA + (endIndexA - startIndexA) / 2 + 1;                
	            }
	        }
	        return findMedianSortedArrays(a, b, startIndexA, endIndexA, startIndexB, endIndexB);
	    }
	      
	    
	    public static double findMedianSortedArrays(int A[], int m, int B[], int n) {
	        if (m > n) return findMedianSortedArrays(B, n, A, m);
	        int minidx = 0, maxidx = m, i = 0, j = 0, num1 = 0, mid = (m + n + 1) / 2,num2;
	        while (minidx <= maxidx)
	        {
	          i = (minidx + maxidx) / 2;
	          j = mid - i;
	          if (i < m && j > 0 && B[j-1] > A[i]) 
	        	  minidx = i + 1;
	          else if (i > 0 && j < n && B[j] < A[i-1]) maxidx = i - 1;
	          else
	          {
	            if (i == 0) num1 = B[j-1];
	            else if (j == 0) num1 = A[i - 1];
	            else num1 = Math.max(A[i-1],B[j-1]);
	            break;
	          }
	        }
	        if (((m + n) % 2 == 1)) return num1;
	        if (i == m) num2 = B[j];
	        else if (j == n) num2 = A[i];
	        else num2 = Math.min(A[i],B[j]);
	        return (num1 + num2) / 2.;
	      }
	    
	    
	    
	    
	    public static void main(String[] args)
	    {
	      
	        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
	        
	        System.out.println("Case 1: When arrays have odd number of elements in them.");
	        int [] a = {1,2,3,4,5};
	        int [] b = {6,7,8,9,10};
	          
	        System.out.println("Median: " + solution.findMedianSortedArrays(a, b, 0, a.length-1, 0, b.length-1));
	        System.out.println(findMedianSortedArrays(a, a.length, b, b.length)); 
	        System.out.println("-----------------");
	         
	        System.out.println("Case 2: When arrays have even number of elements in them.");
	        int[] c = {1,2,99, 100};
	        int[] d = {4,5,101, 102};
	          
	        System.out.println("Median: " + solution.findMedianSortedArrays(c, d, 0, c.length-1, 0, d.length-1));
	        System.out.println(findMedianSortedArrays(c, c.length, d, d.length)); 
	        
	    }
	
	   
}
