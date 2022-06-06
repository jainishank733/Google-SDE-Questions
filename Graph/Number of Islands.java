import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution {
    
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if(row == 0){
            return 0;
        }
        int countIslands = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    helper(grid, i, j, row, col);
                    countIslands++;
                }
            }
        }
        return countIslands;
    }
    
    public static void helper(char[][] grid, int i, int j, int row, int col){
        if(i<0 || j<0 || i>=row || j>=col || grid[i][j]!='1'){
            return;
        }
        grid[i][j] = '2';
        helper(grid, i-1, j, row, col);
        helper(grid, i+1, j, row, col);
        helper(grid, i, j-1, row, col);
        helper(grid, i, j+1, row, col);
        helper(grid, i-1, j-1, row, col);
        helper(grid, i+1, j+1, row, col);
        helper(grid, i+1, j-1, row, col);
        helper(grid, i-1, j+1, row, col);
    }
    
}
