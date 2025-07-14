package com.johncnstn.problem.robotcontrol;

class RobotControl {

    enum Direction {
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

        public Direction turnLeft() {
            return switch (this) {
                case UP -> LEFT;
                case DOWN -> RIGHT;
                case LEFT -> DOWN;
                case RIGHT -> UP;
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

    static class Robot {
        private int x;
        private int y;
        private Direction direction;

        public Robot(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public void turnLeft() {
            direction = direction.turnLeft();
        }

        public void turnRight() {
            direction = direction.turnRight();
        }

        public void stepForward() {
            x += direction.dx();
            y += direction.dy();
        }

        public Direction getDirection() {
            return direction;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        if (robot.getX() < toX) {
            while (robot.getDirection() != Direction.RIGHT) {
                robot.turnRight();
            }
            while (robot.getX() != toX) {
                robot.stepForward();
            }
        } else if (robot.getX() > toX) {
            while (robot.getDirection() != Direction.LEFT) {
                robot.turnLeft();
            }
            while (robot.getX() != toX) {
                robot.stepForward();
            }
        }

        if (robot.getY() < toY) {
            while (robot.getDirection() != Direction.UP) {
                robot.turnRight();
            }
            while (robot.getY() != toY) {
                robot.stepForward();
            }
        } else if (robot.getY() > toY) {
            while (robot.getDirection() != Direction.DOWN) {
                robot.turnLeft();
            }
            while (robot.getY() != toY) {
                robot.stepForward();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        RobotControl.Robot robot = new RobotControl.Robot(1, 2, RobotControl.Direction.DOWN);
        RobotControl.moveRobot(robot, 5, 1);
        System.out.println("x: " + robot.getX() + ", y: " + robot.getY());
    }
}