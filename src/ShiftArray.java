import java.util.HashMap;

public class ShiftArray {
    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4, 5};
        int offset = 3;
        arrayLeftRotation(arr, arr.length, 2);
         for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }    }
    
    public static int[] arrayLeftRotation(int[] a, int n, int d) {
        System.out.println(gcd(n, d));
        for(int i = 0; i < gcd(n, d); i++){
            int j = i;
            int tmp = a[i];
            while(1 != 0){
                int k = (j + d);
                if(k >= n)
                	k %= n;
                if(k == i) break;
                a[j] = a[k];
                j = k;
            }
            a[j] = tmp;
        }
        return a;
    }
    private static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    
    }
