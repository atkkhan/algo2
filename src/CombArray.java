
public class CombArray{
    public static void main(String []args){
        int a[] = {1,4,8,10};
        int b[] = {2,5,9};
        System.out.println(find(a, b, 3));
     }
    public static int find(int[] a, int[] b, int n){
        int indexa = 0;
        int indexb = 0;
        int index = 0;

        while(true){
            if(a[indexa] < b[indexb]){
                if(index == n)
                    return a[indexa];
                ++indexa;
                ++index;

            }
            else{
                if(index == n)
                    return b[indexb];
                ++indexb;
                ++index;

            }
        }
    }
}


