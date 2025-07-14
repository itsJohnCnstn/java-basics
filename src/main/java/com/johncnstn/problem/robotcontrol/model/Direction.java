package com.johncnstn.problem.robotcontrol.model;

public enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /*
        Refactored the statement to an expression
        public Direction turnLeft() {
            switch (this) {
                case UP:
                    return LEFT;
                case DOWN:
                    return RIGHT;
                case LEFT:
                    return DOWN;
                case RIGHT:
                    return UP;
                default:
                    throw new IllegalStateException();
            }
        }
     */

    public Direction turnLeft() {
        return switch (this) {
            case UP -> LEFT;
            case DOWN -> RIGHT;
            case LEFT -> DOWN;
            case RIGHT -> UP;
            // no need default, because all enum constants are handled -> exhaustive switching
        };
    }

    public Direction turnRight() {
        return switch (this) {
            case UP -> RIGHT;
            case DOWN -> LEFT;
            case LEFT -> UP;
            case RIGHT -> DOWN;
        };
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}
