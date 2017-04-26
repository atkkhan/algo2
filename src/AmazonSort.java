import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/*
Q. Sort EC2 instance classes for dropdown menu
input:
[
  "t2.large",
  "m3.large",
  "t1.large",
  "t1.small",
  "m3.small",
  "t2.micro"
]

String format "<type>.<size>",
type order = t2, m3, t1
size order = micro, small, large

Expected output:
[
  "t2.micro",
  "t2.large",
  "m3.small",
  "m3.large",
  "t1.small",
  "t1.large",
]

*/
public class AmazonSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		map.put("t2", 100);
		map.put("m3", 200);
		map.put("t1", 300);
		map.put("micro", 10);
		map.put("small", 20);
		map.put("large", 30);		
		
		String[] ar = {
		                "t2.large",
		                "m3.large",
		                "t1.large",
		                "t1.small",
		                "m3.small",
		                "t2.micro"
		              };
		printAr(ar);
		Arrays.sort(ar, new Comparator<String>(){
			@Override
			public int compare(String obj1, String obj2) {

				//System.out.println(obj1 + " " + obj2);
				String[] os1 = obj1.split("\\.");
				String[] os2 = obj2.split("\\.");
				
				if(map.get(os1[0]) < map.get(os2[0]))
					return -1;
				
				if(map.get(os1[0]) > map.get(os2[0]))
					return 1;
				else{
					if(map.get(os1[1]) < map.get(os2[1])){
						return -1;
					}
					else if(map.get(os1[1]) > map.get(os2[1])){
						return 1;
					}
					else return 0;
				}
					
			}
		});
		
		System.out.println();
		printAr(ar);
		
//		Arrays.sort(ar, new Comparator<String>(){
//			@Override
//			public int compare(String obj1, String obj2) {
//
//				
//				//System.out.println(obj1 + " " + obj2);
//				String[] os1 = obj1.split("\\.");
//				String[] os2 = obj2.split("\\.");
//				
//				if(os1[0].equals(os2[0])){
//					if(map.get(os1[1]) < map.get(os2[1])){
//						return -1;
//					}
//					else if(map.get(os1[1]) > map.get(os2[1])){
//						return 1;
//					}
//					else return 0;
//				}
//				else
//					return 0;
//			}
//
//		});
		System.out.println();
		printAr(ar);
	}
	public static void printAr(String[] ar){
		for(int i = 0; i < ar.length; ++i)
			System.out.print(ar[i] + ", ");
	}
}
