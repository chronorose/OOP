package ru.nsu.game;

enum PlayerInput {
    Continue(1),
    Stop(0);
    final int val;

    PlayerInput(int val) {
        this.val = val;
    }

    int toInt() {
        return val;
    }
}

