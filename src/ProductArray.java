
public class ProductArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 3, 5, 6, 2};
		int[] prdArr = new int[arr.length];
		
		prdArray(arr, 0, prdArr, 1);
		for(int i = 0 ; i < prdArr.length; i++){
			System.out.println(prdArr[i] +  ", ");
		}
	}
		
	public static int prdArray(int[] arr, int index, int[] prdArr, int prd){
		if(index == arr.length)
			return 1;		
		int r = prdArray(arr, index + 1, prdArr, arr[index] * prd);
		prdArr[index] = prd * r;
		return r * arr[index];
	}

}
