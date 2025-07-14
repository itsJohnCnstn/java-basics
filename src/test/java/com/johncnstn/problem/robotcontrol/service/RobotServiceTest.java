package com.johncnstn.problem.robotcontrol.service;

import com.johncnstn.problem.robotcontrol.model.Robot;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.johncnstn.problem.robotcontrol.model.Direction.UP;

class RobotServiceTest {

    private RobotService robotService;

    @BeforeEach
    void setUp() {
        robotService = new RobotService();
    }

    @Test
    void moveRobot_shouldMoveRobot() {
        // Given
        Robot robot = new Robot(0, 0, UP);

        // When
        int toX = 3;
        int toY = 0;
        robotService.moveRobot(robot, toX, toY);

        // Then
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(robot.getX()).isEqualTo(toX);
            softAssertions.assertThat(robot.getY()).isEqualTo(toY);
        });
    }

    @Test
    void moveRobot_shouldMoveRobotWithNegativeY() {
        // Given
        Robot robot = new Robot(1, 1, UP);

        // When
        int toX = 0;
        int toY = -1;
        robotService.moveRobot(robot, toX, toY);

        // Then
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(robot.getX()).isEqualTo(toX);
            softAssertions.assertThat(robot.getY()).isEqualTo(toY);
        });
    }

}