/*
 * Copyright (c) 2024 Newport Robotics Group. All Rights Reserved.
 *
 * Open Source Software; you can modify and/or share it under the terms of
 * the license file in the root directory of this project.
 */
package frc.robot.subsystems;

import static frc.robot.Constants.RobotConstants.CAN.TalonFX.CLIMBER_LEFT_PORT;
import static frc.robot.Constants.RobotConstants.CAN.TalonFX.CLIMBER_RIGHT_PORT;

import com.ctre.phoenix6.hardware.TalonFX;
import com.nrg948.preferences.RobotPreferences;
import com.nrg948.preferences.RobotPreferencesLayout;
import com.nrg948.preferences.RobotPreferencesValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

@RobotPreferencesLayout(groupName = "Climber", column = 0, row = 1, height = 3, width = 1)
public class ClimberSubsystem extends SubsystemBase {
  @RobotPreferencesValue
  public static final RobotPreferences.BooleanValue ENABLED =
      new RobotPreferences.BooleanValue("Climber", "Enabled", false);

  @RobotPreferencesValue
  public static final RobotPreferences.DoubleValue WIND_VOLTAGE =
      new RobotPreferences.DoubleValue("Climber", "Winch Wind Voltage", 3.0);

  @RobotPreferencesValue
  public static final RobotPreferences.DoubleValue UNWIND_VOLTAGE =
      new RobotPreferences.DoubleValue("Climber", "Winch Unwind Voltage", -1.5);

  private final TalonFX winchLeftMotor = new TalonFX(CLIMBER_LEFT_PORT);
  private final TalonFX winchRightMotor = new TalonFX(CLIMBER_RIGHT_PORT);

  /** Creates a new ClimberSubsystem. */
  public ClimberSubsystem() {
    winchLeftMotor.setInverted(true);
  }

  public void setVoltage(double voltage) {
    winchLeftMotor.setVoltage(voltage);
    winchRightMotor.setVoltage(voltage);
  }

  public void wind() {
    setVoltage(WIND_VOLTAGE.getValue());
  }

  public void unwind() {
    setVoltage(UNWIND_VOLTAGE.getValue());
  }

  public void stopMotors() {
    winchLeftMotor.stopMotor();
    winchRightMotor.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
