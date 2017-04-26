import java.util.HashMap;
import java.util.Map;

class Point {
	int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
 }
public class MaxPointOnaLine {

	/*
	7
	6
	5
	4
	3
	2
	1
	0 1 2 3 4 5 6 7
	
	*/
	public static void main(String[] args){
		
		Point p1 = new Point(0,1);
		Point p2 = new Point(2,3);
		Point p3 = new Point(4,6);
		Point[] points = {p1, p2, p3};
		System.out.println(maxPoints(points));
	}
	
	
	public static int maxPoints(Point[] points) {
    	if (points==null) return 0;
    	if (points.length<=2) return points.length;
    	
    	Map<Integer,Map<Integer,Integer>> map = new HashMap<Integer,Map<Integer,Integer>>();
    	int result=0;
    	for (int i=0;i<points.length;i++){ 
    		map.clear();
    		int overlap=0,max=0;
    		for (int j=i+1;j<points.length;j++){
    			int x = points[j].x - points[i].x;
    			int y = points[j].y-points[i].y;
    			if (x==0 && y==0){
    				overlap++;
    				continue;
    			}
    			int gcd=generateGCD(x,y);
    			if (gcd!=0){
    				x/=gcd;
    				y/=gcd;
    			}
    			
    			if (map.containsKey(x)){
    				if (map.get(x).containsKey(y)){
    					map.get(x).put(y, map.get(x).get(y)+1);
    				}else{
    					map.get(x).put(y, 1);
    				}   					
    			}else{
    				Map<Integer,Integer> m = new HashMap<Integer,Integer>();
    				m.put(y, 1);
    				map.put(x, m);
    			}
    			max=Math.max(max, map.get(x).get(y));
    		}
    		result=Math.max(result, max+overlap+1);
    	}
    	return result;
    	
    	
    }
    private static int generateGCD(int a,int b){

    	if (b==0) return a;
    	else return generateGCD(b,a%b);
    	
    }
}
