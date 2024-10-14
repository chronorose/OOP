package ru.nsu;

import java.util.ArrayList;
import java.util.HashMap;

class AdjListGraph implements Graph {
    private HashMap<Integer, ArrayList<Integer>> graph;

    AdjListGraph() {
        graph = new HashMap<>();
    }

    public void removeEdge(Integer from, Integer to) {
        if ((!graph.containsKey(from)) || (!graph.containsKey(to))) {
            return;
        }
        graph.get(from).remove(to);
        graph.get(to).remove(from);
    }

    public void addVertex(Integer v) {
        if (graph.containsKey(v)) {
            return;
        }
        graph.put(v, new ArrayList<>());
    }

    public void removeVertex(Integer v) {
        if (!graph.containsKey(v)) {
            return;
        }
        graph.remove(v);
        for (ArrayList<Integer> lists: graph.values()) {
            lists.remove(v);
        }
    }

    public void addEdge(Integer from, Integer to) {
        addVertex(from);
        addVertex(to);
        graph.get(from).add(to);
        graph.get(to).add(from);
    }

    public Integer[] getNeighbours(Integer v) {
        if (!graph.containsKey(v)) {
            return new Integer[] {};
        }
        return (Integer[])graph.get(v).toArray();
    }

    @Override 
    public String toString() {
        final StringBuilder strout = new StringBuilder();
        graph.forEach((k, v) -> {
            strout.append("Vertex: ");
            strout.append(k);
            strout.append(", edges: ");
            v.forEach((i) -> strout.append(" " + i));
            strout.append('\n');
        });
        return strout.toString();
    }
}
