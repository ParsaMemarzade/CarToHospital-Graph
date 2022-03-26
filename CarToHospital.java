

import java.util.*;
public class CarToHospital {

    
     int minDistance(int dist[], Boolean sptSet[],int V)
    {
        
        int min = Integer.MAX_VALUE, min_index = -1;
  
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
  
        return min_index;
    }
 
    
    void dijkstra(int graph[][], int src,int V,int[] h)
          {
             int dist[] = new int[V]; 
             int[] parent=new int[V];
        
            Boolean sptSet[] = new Boolean[V];
  
            for (int i = 0; i < V; i++) {
                 dist[i] = Integer.MAX_VALUE;
                 parent[i]=Integer.MAX_VALUE;
                 sptSet[i] = false;
            }
  
        
        dist[src] = 0;
        
        
        for (int count = 0; count < V - 1; count++) {
           
            int u = minDistance(dist, sptSet,V);
            sptSet[u] = true;
 
             for (int v = 0; v < V; v++)
                 if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]){
                         dist[v] = dist[u] + graph[u][v];
                         parent[v]=u;
               }
        }
        
        
        int min= Integer.MAX_VALUE;
        int index=-1;  
        for(int j=0;j<h.length;j++){  
            for(int i=0;i<V;i++){
                if(h[j]==i && min>dist[i] ){
                   min=dist[i];
                    index=i;
              }
          }
      }
      
      
         int t=0;
         int index2=index;
         while(index!=src){
                 t++;
                 index=parent[index];
           }
      
      
         int[] x=new int[t];
         int[] y=new int[t];
         int i=0;
         while(index2!=src){
                 x[i]=parent[index2];
                 y[i]=index2;
                 i++;
                 index2=parent[index2];
              }
      
      
         for(int j=t-1;j>=0;j--){
              System.out.println(x[j]+" to "+y[j]);
             }
      
      }

    public static void main(String[] args) {
        
        Scanner s=new Scanner(System.in);
        System.out.print("Numb of hospital : ");
        int h=s.nextInt();
        
        int[] th=new int[h];
      for(int i=0;i<h;i++){
               System.out.print("location of hospital numb "+(i+1)+" : ");  
                 th[i]=s.nextInt();
                 }
      
            System.out.print("location of Car : ");
            int c=s.nextInt();
            System.out.print("size of Node : ");
            int v=s.nextInt();
            System.out.print("size of edge : ");
            int e=s.nextInt();
      
      int[][] t=new int[v][v];
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                 System.out.print("cost of "+(i)+" "+(j)+" : ");
                     t[i][j]=s.nextInt();
                 }
               }
     
      Project_1 p=new Project_1();
      p.dijkstra(t, c, v,th);
      
 }
}