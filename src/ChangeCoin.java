import java.util.ArrayList;

class Change{
	int demon;
	int count;
	public Change(int d, int c){
		this.demon = d;
		this.count = c;
	}
	public String toString(){
		return this.demon + "c x " + this.count; 
	}
}

public class ChangeCoin {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Change> changeCount = new ArrayList<>();
		int[] coins = {1,2,5};
		System.out.println(change(5, changeCount, coins, coins.length - 1));
		System.out.println(changedp(5, coins));
//		for(Change c : changeCount){
//			if(c.count != 0)
//			System.out.println(c.toString());
//		}
	}

	
    public static int changedp(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }
	
	public static int change(int n, ArrayList list, int[] coins, int ci){
		int denom = coins[ci];
		if(ci == 0 && n % coins[ci] > 0) return 0;
		if(ci == 0) return 1;			

		int countWays = 0;
		for(int i = 0; i * denom <= n; i++){
			countWays = countWays + change(n - i * denom, list, coins, ci - 1);
		}
		return countWays;
	}
	
}
