package com.johncnstn.problem.robotcontrol.demo;

import com.johncnstn.problem.robotcontrol.model.Direction;
import com.johncnstn.problem.robotcontrol.model.Robot;
import com.johncnstn.problem.robotcontrol.service.RobotService;

public class Main {

    private static final RobotService robotService = new RobotService();

    public static void main(String[] args) {
        Robot robot = new Robot(1, 2, Direction.DOWN);
        // imagine it's spring service..
        robotService.moveRobot(robot, 5, 1);
        System.out.println("x: " + robot.getX() + ", y: " + robot.getY());
    }
}
