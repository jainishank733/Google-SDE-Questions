class Coord{
    int i, j;
    Coord(int i, int j){
        this.i = i;
        this.j = j;
    }
    
    static Coord from(int i, int j){
        return new Coord(i, j);
    }
}

class Solution
{
    final int di[] = {0, 1, 0, -1}, dj[] = {1, 0, -1, 0};
    
    boolean outSideGrid(int i, int j, int N, int M){
        return  i < 0 || i >= N || j < 0 || j >= M;
    }
    
    void bfs(int arr[][], int N, int M, boolean visited[][], int cmp){
        Queue<Coord> q = new LinkedList<>();
        
        // Blue lake
        if(cmp == 1){
            for(int i = 0; i < N; i++){
                q.add(Coord.from(i, 0));
                visited[i][0] = true;
            }
            for(int i = 0; i < M; i++){
                q.add(Coord.from(0, i));
                visited[0][i] = true;
            }
        }else{
            for(int i = 0; i < N; i++){
                q.add(Coord.from(i, M - 1));
                visited[i][M - 1] = true;
            }
            for(int i = 0; i < M; i++){
                q.add(Coord.from(N - 1, i));
                visited[N - 1][i] = true;
            }
        }
        
        while(!q.isEmpty()){
            Coord c = q.poll();
            int i = c.i, j = c.j;
            for(int k = 0; k < 4; k++){
                int ni = di[k] + i, nj = dj[k] + j;
                if(outSideGrid(ni, nj, N, M) || visited[ni][nj])
                    continue;
                int cmpVal = Integer.compare(arr[i][j], arr[ni][nj]);
                if(cmpVal <= 0 && !visited[ni][nj]){
                    visited[ni][nj] = true;
                    q.add(Coord.from(ni, nj));
                }
            }
        }
    }
    
    int countCells(int A[][], int N, int M){
	      // Your code here	
	      boolean red[][] = new boolean[N][M], blue[][] = new boolean[N][M];
	      bfs(A, N, M, blue, 1);
	      bfs(A, N, M, red, -1);
	      int res = 0;
	      for(int i = 0; i < N; i++){
	          for(int j = 0; j < M; j++){
	              if(red[i][j] && blue[i][j]){
	                  //System.out.println(i + " " + j);
	                ++res;
	              }
	          }
	      }
	      return res;
    }
}
