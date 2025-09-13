package hot100;

public class NumIslands {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int num=0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='1') {
                    num++;
                    dfs(grid,i,j);
                }
            }
        }
        return num;
    }

    public void dfs(char[][]grid,int i,int j){
        int m=grid.length,n=grid[0].length;
        if(i<0 || i>=m || j<0 || j>=n)
            return;
        if(grid[i][j]!='1')
            return;
        grid[i][j]='2';
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
    }

    public static void main(String[] args) {
        char[][]grid=new char[][]{
                {'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'1','1','1','0','1'}};
        new NumIslands().numIslands(grid);
    }
}
