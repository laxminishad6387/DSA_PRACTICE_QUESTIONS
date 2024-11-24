//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

// ask in Flipkart Amazon Microsoft 
// Samsung MakeMyTrip Oracle  Goldman Sachs 
// Adobe BankBazaar Rockstand
// daily practice problem 
// graph preactice problem 
// time compexity : (v+e)

class Solution {
    
    public boolean isCycleDetection(ArrayList<ArrayList<Integer>> graph,
    boolean vis[], int curr, boolean stack[])
    {
        vis[curr]=true;
        stack[curr]=true;
        for(Integer nei : graph.get(curr))
        {
          
            if(stack[nei]==true)
              return true;
              else if(vis[nei]==false)
              {
                 if( isCycleDetection(graph,vis,nei,stack)){
                     return true;
                 }
              }
        }
        stack[curr]=false;
        return false;
    }
 
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> graph) {
        boolean vis[]=new boolean[V];
         boolean stack[]=new boolean[V];
         for(int i=0; i<V; i++)
         {
             if(!vis[i] && isCycleDetection(graph,vis,i,stack))
             {
                 return true;
                 
             }
         }
         return false;
    }
}