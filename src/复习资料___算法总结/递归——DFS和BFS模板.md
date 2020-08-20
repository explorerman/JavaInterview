DFS：depth-first-search

BFS：breadth-first-search

DFS用递归的形式，用到了栈结构，先进后出。

​	  BFS选取状态用队列的形式，先进先出。

​	   都是搜索的思想，穷竭列举所有的情况

​	   复杂度:DFS的复杂度与BFS的复杂度大体一致，不同之处在于遍历的方式与对于问题的解决出发点不同

​	  DFS适合于目标明确

​	  BFS适合大范围内的查找

```java
int goal_x = 9, goal_y = 9;     //目标的坐标，暂时设置为右下角
int n = 10 , m = 10;               //地图的宽高，设置为10 * 10的表格
int graph[n][m];        //地图
int used[n][m];         //用来标记地图上那些点是走过的
int px[] = {-1, 0, 1, 0};   //通过px 和 py数组来实现左下右上的移动顺序
int py[] = {0, -1, 0, 1};
int flag = 0;           //是否能达到终点的标志

void DFS(int graph[][], int used[], int x, int y)
{
    // 如果与目标坐标相同，则成功
    if (graph[x][y] == graph[goal_x][goal_y]) {     
        printf("successful");
        flag = 1;
        return ;
    }
    // 遍历四个方向
    for (int i = 0; i != 4; ++i) {    
        //如果没有走过这个格子          
        int new_x = x + px[i], new_y = y + py[i];
        if (new_x >= 0 && new_x < n && new_y >= 0 
            && new_y < m && used[new_x][new_y] == 0 && !flag) {
            
            used[new_x][new_y] = 1;     //将该格子设为走过

            DFS(graph, used, new_x, new_y);      //递归下去

            used[new_x][new_y] = 0;//状态回溯，退回来，将格子设置为未走过
        }
    }
}
```

```java
int n = 10, m = 10;                   //地图宽高
void BFS()
{
    queue que;              //用队列来保存路口
    int graph[n][m];          //地图
    int px[] = {-1, 0, 1, 0};   //移动方向的数组
    int py[] = {0, -1, 0, 1};
    que.push(起点入队);      //将起点入队
    while (!que.empty()) {    //只要队列不为空
        auto temp = que.pop();          //得到队列中的元素
        for (int i = 0; i != 4; ++i) {
            if(//可以走) {
                //标记当前格子
                //将当前状态入队列，等待下次提取
            }
        }
    } 
}
```

