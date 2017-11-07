package guangyu;

/**
 * @Description: 0,1背包问题，n个怪物，每个消耗时长为w[i],价值为c[i]，
 * 容量为40的背包，求可以放入背包的最大价值为多少
 * @param:
 * @return:
 */
class Monster {
    //打败花费的时间（分钟）
    int costMinTime;
    //掉落金币数量
    int coinNum;
    Monster(int costMinTime,int coinNum){
        this.costMinTime = costMinTime;
        this.coinNum = coinNum;
 }
}

public class SolutionTwo {
    public int wonMaxCoin(Monster[]monsters){
        int ans =0;
        int numbers = monsters.length;
        int time = 40; //打怪时长，背包容量
        int[]weight = new int[numbers]; //每件重量
        int[]value = new int[numbers]; //每件对应价值
        int[]dp = new int[time];

        //初始化内容
        for(int i=0;i<time; i++){
            dp[i] = 0;
        }
        for(int i=0;i<numbers;i++){
            weight[i] = monsters[i].costMinTime;
            value[i] = monsters[i].coinNum;
        }
        for(int i=0;i<numbers;i++){
            for(int v=time-1;v>=weight[i];v--){
                dp[v] = Math.max(dp[v],dp[v-weight[i]] + value[i]);
            }
        }

        for(int i=0;i<time;i++){
            ans = Math.max(ans,dp[i]);
        }

        return ans;
    }

    public static void main(String srgs[]){
        Monster[] mosters = new Monster[]{
                new Monster(12,24),
                new Monster(18,20),
                new Monster(19,20),
                new Monster(25,30),
                new Monster(10,23),
                new Monster(10,23)
	};
        SolutionTwo solutionTwo = new SolutionTwo();
        int ans = solutionTwo.wonMaxCoin(mosters);
        System.out.println(ans);
    }
}
