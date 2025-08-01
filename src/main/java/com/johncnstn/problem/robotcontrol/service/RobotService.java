package com.johncnstn.problem.robotcontrol.service;

import com.johncnstn.problem.robotcontrol.model.Direction;
import com.johncnstn.problem.robotcontrol.model.Robot;

public class RobotService {

    //region refactored using functional decomposition

    public void moveRobot(Robot robot, int toX, int toY) {
        moveX(robot, toX);
        moveY(robot, toY);
    }

    private void moveX(Robot robot, int toX) {
        if (robot.getX() < toX) {
            moveRobotRight(robot, toX);
        } else if (robot.getX() > toX) {
            moveRobotLeft(robot, toX);
        }
    }

    private void moveRobotRight(Robot robot, int toX) {
        turnRobot(robot, Direction.RIGHT);
        moveRobot(robot, toX);
    }

    private void moveRobotLeft(Robot robot, int toX) {
        turnRobot(robot, Direction.LEFT);
        moveRobot(robot, toX);
    }

    private void turnRobot(Robot robot, Direction targetDirection) {
        // TODO implement optimal turning strategy
        while (robot.getDirection() != targetDirection) {
            robot.turnRight();
        }
    }

    private void moveRobot(Robot robot, int toX) {
        while (robot.getX() != toX) {
            robot.stepForward();
        }
    }

    //endregion

    //region unrefactored

    private void moveY(Robot robot, int toY) {
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

    //endregion

}