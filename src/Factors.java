public class Factors {
    public static void main(String[] args){
        System.out.println(allFactors(9));
    }
    
    public static int allFactors(int n){
        int count = 0;
        int r = (int)Math.ceil(Math.sqrt(new Double(n)));
        System.out.println(">" + r);
        int[] f = new int[2 * r];
        int index = 0;
        for(int i = 1; i <= r; ++i){
            if((n % i) == 0 && i != r){
                count += 2;
                f[index++] = i;
                if(i == 1)
                    f[index++] = n;
                else
                    f[index++] = i * i;
            }
            else if((n % i) == 0){
                ++count;
                f[index++] = i;
            }    
        }
        int j = 0;
        while(j < index){
            System.out.print(f[j] + ", ");
            ++j;
        }
        System.out.println("");
        return count;
    }
    
}
