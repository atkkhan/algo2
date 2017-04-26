import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class NestedIntegerSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NestedInteger ni1_1 = new NestedInteger(1);
		NestedInteger ni2_1 = new NestedInteger(1);
		List<NestedInteger> lst1 = new ArrayList<>();
		lst1.add(ni1_1);
		lst1.add(ni2_1);
		NestedInteger lst1_1 = new NestedInteger(lst1);
		
		NestedInteger ni3_1 = new NestedInteger(1);
		NestedInteger ni4_1 = new NestedInteger(1);
		List<NestedInteger> lst2 = new ArrayList<>();
		lst2.add(ni3_1);
		lst2.add(ni4_1);
		NestedInteger lst2_2 = new NestedInteger(lst2);
		
		NestedInteger ni5_2 = new NestedInteger(2);
		List<NestedInteger> lst3 = new ArrayList<>();
		lst3.add(lst1_1);
		lst3.add(ni5_2);
		lst3.add(lst2_2);
		
		//
		NestedInteger ni1_01 = new NestedInteger(1);
		NestedInteger ni1_02 = new NestedInteger(4);
		NestedInteger ni1_03 = new NestedInteger(6);
			
		NestedInteger master = new NestedInteger(lst3);
		StringBuilder sb = new StringBuilder();
		System.out.println(master.printNi(master, sb));
		System.out.println(depthSumInverse(lst3));
		System.out.println(depthSumInverseRecursive(lst3,0));
	}
	
	public static int depthSumInverseRecursive(List<NestedInteger> nestedList, int unweighted) {
		if(nestedList.isEmpty()) return 0;
		
		ListIterator<NestedInteger> li = nestedList.listIterator();
		List<NestedInteger> nextLevel = new ArrayList<>();
		while(li.hasNext()){
			NestedInteger ni = li.next();
			if(ni.isInteger()){
				li.remove();
				unweighted += ni.getInteger();
			}
			else
				nextLevel.addAll(ni.getList());
		}
		return unweighted + depthSumInverseRecursive(nextLevel, unweighted);
	}	
	
	
	
	
	public static int depthSumInverse(List<NestedInteger> nestedList) {
	    int unweighted = 0, weighted = 0;
	    while (!nestedList.isEmpty()) {
	        List<NestedInteger> nextLevel = new ArrayList<>();
	        for (NestedInteger ni : nestedList) {
	            if (ni.isInteger())
	                unweighted += ni.getInteger();
	            else
	                nextLevel.addAll(ni.getList());
	        }
	        weighted += unweighted;
	        nestedList = nextLevel;
	    }
	    return weighted;
	}
}

class NestedInteger {
    private List<NestedInteger> list;
    private Integer integer;
    
    public NestedInteger(List<NestedInteger> list){
        this.list = list;
    }
    
    public void add(NestedInteger nestedInteger) {
        if(this.list != null){
            this.list.add(nestedInteger);
        } else {
            this.list = new ArrayList();
            this.list.add(nestedInteger);
        }
    }

    public void setInteger(int num) {
        this.integer = num;
    }

    public NestedInteger(Integer integer){
        this.integer = integer;
    }

    public NestedInteger() {
        this.list = new ArrayList();
    }

    public boolean isInteger() {
        return integer != null;
    }

    public Integer getInteger() {
        return integer;
    }

    public List<NestedInteger> getList() {
        return list;
    }
    
    public String printNi(NestedInteger thisNi, StringBuilder sb){
        if(thisNi.isInteger()) {
            sb.append(thisNi.integer);
            sb.append(",");
        }
        sb.append("[");
        for(NestedInteger ni : thisNi.list){
            if(ni.isInteger()) {
                sb.append(ni.integer);
                sb.append(",");
            }
            else {
                printNi(ni, sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}