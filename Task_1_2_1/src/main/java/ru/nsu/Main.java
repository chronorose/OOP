package ru.nsu;

class Main {
    public static void main(String[] args) {
        AdjMatrixGraph gh = new AdjMatrixGraph();
        for(int i = 0; i < 10; i++) {
            gh.addEdge(i, 10 + i);
        }
        System.out.println(gh.toString());
    }
}
