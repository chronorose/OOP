package ru.nsu;

import java.util.ArrayList;
import java.util.stream.IntStream;

class AdjMatrixGraph implements Graph {
    private ArrayList<ArrayList<Boolean>> graph;

    AdjMatrixGraph() {
        graph = new ArrayList<>(); 
    }

    private void ensureSize(int size) {
        size++;
        if (graph.size() >= size) {
            return;
        }
        for (int i = graph.size(); i < size; i++) {
            graph.add(new ArrayList<>(size));
        }
        for (int i = 0; i < size; i++) {
            ArrayList<Boolean> xs = graph.get(i);
            for (int j = xs.size(); j < size; j++) {
                xs.add(false);
            }
        }
    }

    public void removeVertex(Integer v) {
        if (v == graph.size() - 1) {
            int size = graph.size() - 1;
            graph.remove(size);
            for (int i = 0; i < graph.size(); i++) {
                graph.get(i).remove(size);
            }
            return;
        }
        for (int i = 0; i < graph.size(); i++) {
            graph.get(i).set(v, false);
            graph.get(v).set(i, false);
        }
    }

    public void removeEdge(Integer from, Integer to) {
        ensureSize(from);
        ensureSize(to);
        graph.get(from).set(to, false);
        graph.get(to).set(from, false);
    }

    public void addVertex(Integer v) {
        ensureSize(v);
    }

    public void addEdge(Integer from, Integer to) {
        ensureSize(from);
        ensureSize(to);
        graph.get(from).set(to, true);
        graph.get(to).set(from, true);

    }
    public Integer[] getNeighbours(Integer v) {
        if (v >= graph.size()) {
            return new Integer[] {};
        } 
        return (Integer[])graph.get(v).toArray();
    }
    
    @Override
    public String toString() {
        StringBuilder strout = new StringBuilder();
        IntStream.range(0, graph.size()).forEach((i) -> {
            strout.append("Vertex ");
            strout.append(i);
            strout.append(", edges: ");
            IntStream.range(0, graph.size()).forEach(j -> {
                if (graph.get(i).get(j)) {
                    strout.append(" " + j);
                }  
            });
            strout.append('\n');
        });
        return strout.toString();
    }
}
