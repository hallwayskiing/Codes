package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class CanFinish {
    List<List<Integer>>edges;
    int[]inDegree;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        inDegree=new int[numCourses];

        for(int[]prerequisite:prerequisites){
            edges.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        Queue<Integer>queue=new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i]==0)
                queue.add(i);
        }

        int visited=0;
        while (!queue.isEmpty()){
            visited++;
            int u=queue.poll();
            for (int v:edges.get(u)){
                inDegree[v]--;
                if(inDegree[v]==0)
                    queue.add(v);
            }
        }

        return visited==numCourses;
    }

}
