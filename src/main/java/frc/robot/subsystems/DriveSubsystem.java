// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.*;
import frc.robot.commands.*;

public class DriveSubsystem extends SubsystemBase {

  // Victor, Talon
  PWMSparkMax frontRight = new PWMSparkMax(RobotMap.frontRight);
  PWMSparkMax frontLeft = new PWMSparkMax(RobotMap.frontLeft);
  PWMSparkMax backRight = new PWMSparkMax(RobotMap.backRight);
  PWMSparkMax backLeft = new PWMSparkMax(RobotMap.backLeft);

  MotorControllerGroup left = new MotorControllerGroup(frontLeft, backLeft);
  MotorControllerGroup right = new MotorControllerGroup(frontRight, backRight);

  DifferentialDrive drive;

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    frontLeft.setInverted(false);
    backLeft.setInverted(false);
    frontRight.setInverted(false);
    backRight.setInverted(false);
    drive = new DifferentialDrive(left, right);
  }

  public void drive(double straight, double turn) {
    drive.arcadeDrive(straight, turn);
  }

  public void stop() {
    drive.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new DriveCommand());
  }
}
