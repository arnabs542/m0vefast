//using matrix O(n^2+mlgn),      using list: O(m+n)lgn
void Dijkstra(int graph[v][v], int source){
     int dis[v];                //arr[distance of source to v]
     bool finalize[v];          //if shortest path to v is finalized 
     
     for(int i = 0; i < graph.size(); i++){   //initialize the variable
          dis[i] = INT_MAX;
          finalize[i] = false;
     }
     dis[source] = 0;                         
     for(int i = 0; i < v - 1; i++){
                        //-1: already count source v 
          //min is the childindex from parent to child with min distance 
          int min = minDistance(dis, finalize); 
          finalize[min] = true;
          for(int j = 0; j < v; j++){          //loop through dis[]
               if(!finalize[j]                //has not been finalize
                    && graph[min][j]          //there is an edge from minChild to j
                    && dis[min] != INT_MAX    //dis has been initialize  
                    && dis[min] + graph[min][j] < dis[j]   //path from s->min->j <= cur dis[j]
                    )
                    dis[min] = dis[min] + graph[min][j];    //update
          }
     }
}
int minDistance(int dis[], bool finalize[]){
     int min = INT_MAX;   //global min
     int min_index;
     for(int i = 0; i < dis.size(); i++){
          if(finalize[i] == false 
               && dis[i] <= min){
               min = dis[i];
               min_index = i;
          }     
     }
     return min_index;
}
