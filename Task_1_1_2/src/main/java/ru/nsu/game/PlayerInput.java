package ru.nsu.game;

/**
 * Enum that is used to get player's input.
 */
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

