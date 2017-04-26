
public class ReplWithNum {
    public static void main(String []args){
        //System.out.println(replace("10305"));
        System.out.println(replace("1005"));
     }
     
     public static int replace(String str){
         int integer = Integer.parseInt(str);
         int r = 0;
         int m = 10;
         int index = 0;

         do{
            index++;
            //int curr = integer;
            r = (integer - r) % (int)Math.pow(new Double(m), new Double(index));
            System.out.println(index + ":" + r + ":" + (int)Math.pow(new Double(m), new Double(index)) + "");
            if(r == 0){
                integer = integer + (5 * (int)Math.pow(new Double(m), new Double(index - 1)));
                r = (integer % (int)Math.pow(new Double(m), new Double(index)));
            }
         }while(index < str.length());         
         return  integer;
     }
}