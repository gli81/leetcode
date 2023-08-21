
public class GasStationJava {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0;
        int len = gas.length;
        while (i < len) {
            int tank = gas[i];
            for (int j = 1; j <= len; j++) {
                int cur = (i + j) % len;
                int cur_1 = (i + j - 1) % len;
                tank -= cost[cur_1];
                if (tank < 0) {
                    if (cur_1 < i) {
                        return -1;
                    }
                    i = cur_1;
                    break;
                }
                if (j == len) return i;
                tank += gas[cur];
            }
            i++;
        }
        return -1;
    }


    public static void main(String[] args) {
        GasStationJava test = new GasStationJava();
        System.out.println(test.canCompleteCircuit(
            new int[]{1, 2, 3, 4, 5},
            new int[]{3, 4, 5, 1, 2}));    
    }
}
