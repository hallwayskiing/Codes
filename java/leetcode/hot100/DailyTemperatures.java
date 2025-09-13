package hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[]res=new int[n];
        Deque<Integer>deque=new ArrayDeque<>();
        Deque<Integer>indexes=new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int t=temperatures[i];
            while (!deque.isEmpty() && t > deque.peekLast()) {
                int index = indexes.removeLast();
                res[index] = i - index;
                deque.removeLast();
            }
            deque.addLast(t);
            indexes.addLast(i);
        }

        return res;
    }

    public static void main(String[] args) {
        new DailyTemperatures().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
}
