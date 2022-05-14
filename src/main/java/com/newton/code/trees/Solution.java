package com.newton.code.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 4};
        int[] b = {4, 1, 3, 5};
        Graph2 cyclicGraph = new Graph2(a.length);
        System.out.println(new Solution().solution(a, b));
    }

    public boolean solution(int[] A, int[] B) {

        Graph2 cyclicGraph = new Graph2(A.length + B.length + 1);

        for (int i = 0; i < A.length; i++) {
            cyclicGraph.addEdge(A[i], B[i]);
        }

        boolean[] visited = new boolean[A.length + B.length + 1];
        boolean[] recStack = new boolean[A.length + B.length + 1];

        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < A.length; i++) {
            if (cyclicGraph.isCyclicUtil(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }
}

class Graph2 {
    private final int V;
    private final List<List<Integer>> adj;

    public Graph2(int V) {
        this.V = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new LinkedList<>());
        }
    }

    public void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    public boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {

        if (recStack[i]) {
            return false;
        }

        if (visited[i]) {
            return false;
        }

        visited[i] = true;

        List<Integer> children = adj.get(i);

        for (Integer c : children) {
            recStack[c] = true;
            if (isCyclicUtil(c, visited, recStack)) {
                return true;
            }
        }


        for (int i1 = 0; i1 < recStack.length; i1++) {
            if (recStack[i] != true) {
                return false;
            }
        }

        return true;
    }
}
