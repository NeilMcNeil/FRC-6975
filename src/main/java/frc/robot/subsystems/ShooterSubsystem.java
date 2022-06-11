// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class ShooterSubsystem extends SubsystemBase {
  PWMSparkMax topMotor = new PWMSparkMax(RobotMap.topShooterPort);
  PWMSparkMax bottomMotor = new PWMSparkMax(RobotMap.bottomShooterPort);
  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    topMotor.setInverted(false);
    bottomMotor.setInverted(true);
  }

  public void shoot(){
    topMotor.set(1);
    bottomMotor.set(1);
  }

  public void stop(){
    topMotor.stopMotor();
    bottomMotor.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
