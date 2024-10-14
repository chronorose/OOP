package ru.nsu;

public interface Graph {
    void addVertex(Integer vertex);
    void removeVertex(Integer vertex);
    void addEdge(Integer from, Integer to);
    void removeEdge(Integer from, Integer to);
    Integer[] getNeighbours(Integer vertex);
}
