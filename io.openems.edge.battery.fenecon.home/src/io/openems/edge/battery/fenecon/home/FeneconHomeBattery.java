package io.openems.edge.battery.fenecon.home;

import io.openems.common.channel.AccessMode;
import io.openems.common.channel.Level;
import io.openems.common.channel.Unit;
import io.openems.common.types.OpenemsType;
import io.openems.edge.battery.api.Battery;
import io.openems.edge.battery.fenecon.home.enums.BmsControl;
import io.openems.edge.battery.fenecon.home.statemachine.StateMachine.State;
import io.openems.edge.common.channel.Channel;
import io.openems.edge.common.channel.Doc;
import io.openems.edge.common.channel.value.Value;
import io.openems.edge.common.component.OpenemsComponent;
import io.openems.edge.common.startstop.StartStop;
import io.openems.edge.common.startstop.StartStoppable;

public interface FeneconHomeBattery extends Battery, OpenemsComponent, StartStoppable {

	/**
	 * Gets the Channel for {@link ChannelId#BMS_CONTROL}.
	 * 
	 * @return the Channel
	 */
	public default Channel<BmsControl> getBmsControlChannel() {
		return this.channel(ChannelId.BMS_CONTROL);
	}

	/**
	 * Gets the BmsControl, see {@link ChannelId#BMS_CONTROL}.
	 * 
	 * @return the Channel {@link Value}
	 */
	public default BmsControl getBmsControl() {
		return this.getBmsControlChannel().value().asEnum();
	}

	/**
	 * Internal method to set the 'nextValue' on {@link ChannelId#BMS_CONTROL}
	 * Channel.
	 * 
	 * @param value the next value
	 */
	public default void _setBmsControl(BmsControl value) {
		this.getBmsControlChannel().setNextValue(value);
	}

	/**
	 * Gets the target Start/Stop mode from config or StartStop-Channel.
	 * 
	 * @return {@link StartStop}
	 */
	public StartStop getStartStopTarget();

	public static enum ChannelId implements io.openems.edge.common.channel.ChannelId {
		// EnumWriteChannels
		RACK_PRE_ALARM_CELL_OVER_VOLTAGE(Doc.of(OpenemsType.BOOLEAN) //
				.text("Rack Cell Over Voltage Alarm")), //
		RACK_PRE_ALARM_CELL_UNDER_VOLTAGE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Cell Under Voltage Alarm")), //
		RACK_PRE_ALARM_OVER_CHARGING_CURRENT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Over Charging Current Alarm")), //
		RACK_PRE_ALARM_OVER_DISCHARGING_CURRENT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Over Discharging Current Alarm")), //
		RACK_PRE_ALARM_OVER_TEMPERATURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Over Temperature Alarm")), //
		RACK_PRE_ALARM_UNDER_TEMPERATURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Under Temperature Alarm")), //
		RACK_PRE_ALARM_CELL_VOLTAGE_DIFFERENCE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Cell VOltage Difference Alarm")), //
		RACK_PRE_ALARM_BCU_TEMP_DIFFERENCE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack BCU Temp Difference Alarm")), //
		RACK_PRE_ALARM_UNDER_SOC(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Under SOC Alarm")), //
		RACK_PRE_ALARM_UNDER_SOH(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Under SOH Alarm")), //
		RACK_PRE_ALARM_OVER_CHARGING_POWER(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Over Charging Alarm")), //
		RACK_PRE_ALARM_OVER_DISCHARGING_POWER(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Over Discharging Alarm")), //
		RACK_LEVEL_1_CELL_OVER_VOLTAGE(Doc.of(OpenemsType.BOOLEAN) //
				.text("Rack Cell Over Voltage warning")), //
		RACK_LEVEL_1_CELL_UNDER_VOLTAGE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Cell Under Voltage warning")), //
		RACK_LEVEL_1_OVER_CHARGING_CURRENT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Over Charging Current warning")), //
		RACK_LEVEL_1_OVER_DISCHARGING_CURRENT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Over Discharging Current warning")), //
		RACK_LEVEL_1_OVER_TEMPERATURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Over Temperature warning")), //
		RACK_LEVEL_1_UNDER_TEMPERATURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Under Temperature warning")), //
		RACK_LEVEL_1_CELL_VOLTAGE_DIFFERENCE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Cell VOltage Difference warning")), //
		RACK_LEVEL_1_BCU_TEMP_DIFFERENCE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack BCU Temp Difference warning")), //
		RACK_LEVEL_1_UNDER_SOC(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Under SOC warning")), //
		RACK_LEVEL_1_UNDER_SOH(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Under SOH warning")), //
		RACK_LEVEL_1_OVER_CHARGING_POWER(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Over Charging warning")), //
		RACK_LEVEL_1_OVER_DISCHARGING_POWER(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Over Discharging warning")), //
		RACK_LEVEL_2_CELL_OVER_VOLTAGE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Cell Over Voltage Fault")), //
		RACK_LEVEL_2_CELL_UNDER_VOLTAGE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Cell Under Voltage Fault")), //
		RACK_LEVEL_2_OVER_CHARGING_CURRENT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Over Charging Current Fault")), //
		RACK_LEVEL_2_OVER_DISCHARGING_CURRENT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Over Discharging Current Fault")), //
		RACK_LEVEL_2_OVER_TEMPERATURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Over Temperature Fault")), //
		RACK_LEVEL_2_UNDER_TEMPERATURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Under Temperature Fault")), //
		RACK_LEVEL_2_CELL_VOLTAGE_DIFFERENCE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Cell Voltage Difference Fault")), //
		RACK_LEVEL_2_BCU_TEMP_DIFFERENCE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack BCU Temp Difference Fault")), //
		RACK_LEVEL_2_CELL_TEMPERATURE_DIFFERENCE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Cell Temperature Difference Fault")), //
		RACK_LEVEL_2_INTERNAL_COMMUNICATION(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Internal Communication Fault")), //
		RACK_LEVEL_2_EXTERNAL_COMMUNICATION(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack External Communication Fault")), //
		RACK_LEVEL_2_PRE_CHARGE_FAIL(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Pre Charge Fault")), //
		RACK_LEVEL_2_PARALLEL_FAIL(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Parallel Fault")), //
		RACK_LEVEL_2_SYSTEM_FAIL(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack System Fault")), //
		RACK_LEVEL_2_HARDWARE_FAIL(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_ONLY) //
				.text("Rack Hardware Fault")), //
		ALARM_POSITION_BCU_1(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Alarm BCU 1 Position ")), //
		ALARM_POSITION_BCU_2(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Alarm BCU 2 Position ")), //
		ALARM_POSITION_BCU_3(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Alarm BCU 3 Position ")), //
		ALARM_POSITION_BCU_4(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Alarm BCU 4 Position ")), //
		ALARM_POSITION_BCU_5(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Alarm BCU 5 Position ")), //
		ALARM_POSITION_BCU_6(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Alarm BCU 6 Position ")), //
		ALARM_POSITION_BCU_7(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Alarm BCU 7 Position ")), //
		ALARM_POSITION_BCU_8(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Alarm BCU 8 Position ")), //
		ALARM_POSITION_BCU_9(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Alarm BCU 9 Position ")), //
		ALARM_POSITION_BCU_10(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Alarm BCU 10 Position ")), //
		WARNING_POSITION_BCU_1(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Warning BCU 1 Position ")), //
		WARNING_POSITION_BCU_2(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Warning BCU 2 Position ")), //
		WARNING_POSITION_BCU_3(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Warning BCU 3 Position ")), //
		WARNING_POSITION_BCU_4(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Warning BCU 4 Position ")), //
		WARNING_POSITION_BCU_5(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Warning BCU 5 Position ")), //
		WARNING_POSITION_BCU_6(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Warning BCU 6 Position ")), //
		WARNING_POSITION_BCU_7(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Warning BCU 7 Position ")), //
		WARNING_POSITION_BCU_8(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Warning BCU 8 Position ")), //
		WARNING_POSITION_BCU_9(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Warning BCU 9 Position ")), //
		WARNING_POSITION_BCU_10(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Warning BCU 10 Position ")), //
		FAULT_POSITION_BCU_1(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Fault BCU 1 Position ")), //
		FAULT_POSITION_BCU_2(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Fault BCU 2 Position ")), //
		FAULT_POSITION_BCU_3(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Fault BCU 3 Position ")), //
		FAULT_POSITION_BCU_4(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Fault BCU 4 Position ")), //
		FAULT_POSITION_BCU_5(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Fault BCU 5 Position ")), //
		FAULT_POSITION_BCU_6(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Fault BCU 6 Position ")), //
		FAULT_POSITION_BCU_7(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Fault BCU 7 Position ")), //
		FAULT_POSITION_BCU_8(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Fault BCU 8 Position ")), //
		FAULT_POSITION_BCU_9(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Fault BCU 9 Position ")), //
		FAULT_POSITION_BCU_10(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Fault BCU 10 Position ")), //
		BATTERY_RACK_VOLTAGE(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.VOLT) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Battery Rack Voltage")), //
		BATTERY_RACK_CURRENT(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.MILLIAMPERE) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Battery Rack Current")), //
		BATTERY_RACK_SOC(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.PERCENT) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Battery Rack State Of Charge")), //
		BATTERY_RACK_SOH(Doc.of(OpenemsType.INTEGER)//
				.unit(Unit.PERCENT) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Battery Rack State Of Health")), //
		CELL_VOLTAGE_MIN(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.MILLIVOLT) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Min Cell Voltage of All Module")), //
		ID_OF_CELL_VOLTAGE_MIN(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.NONE) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Id. (Min Cell Voltage)")), //
		CELL_VOLTAGE_MAX(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.MILLIVOLT) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Cell Voltage MAX")), //
		ID_OF_CELL_VOLTAGE_MAX(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.NONE) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Id. (Max Cell Voltage)")), //
		MIN_TEMPERATURE(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.DEGREE_CELSIUS) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Min Temperature of Battery Rack")), //
		ID_OF_MIN_TEMPERATURE(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.NONE) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Id. (Min Temp)")), //
		MAX_TEMPERATURE(Doc.of(OpenemsType.INTEGER) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Max Temperature of Battery Rack")), //
		ID_OF_MAX_TEMPERATURE(Doc.of(OpenemsType.INTEGER) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Id. (Max Temp)")), //
		MAX_CHARGE_CURRENT(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.AMPERE) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Battery Rack DC Charge Current Limit")), //
		MAX_DISCHARGE_CURRENT(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.AMPERE) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Battery Rack DC Discharge Current Limit")),
		MAX_DC_CHARGE_CURRENT_LIMIT_PER_BCU(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.AMPERE) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Max Charge Current Limit Per BCU")), //
		MAX_DC_DISCHARGE_CURRENT_LIMIT_PER_BCU(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.AMPERE) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Max Discharge Current Limit Per BCU")),
		RACK_NUMBER_OF_BATTERY_BCU(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.NONE) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Count Of The Connected BCU")),
		RACK_NUMBER_OF_CELLS_IN_SERIES_PER_MODULE(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.NONE) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack Number Of Cells in  Series Per Module")),
		RACK_MAX_CELL_VOLTAGE_LIMIT(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.MILLIVOLT) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack Upper Cell Voltage Border -> System will stop charging if a cell reaches this voltage value")),
		RACK_MIN_CELL_VOLTAGE_LIMIT(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.MILLIVOLT) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack Lower Cell Voltage Border -> System will stop discharging if a cell reaches this voltage value")),
		RACK_HW_AFE_COMMUNICATION_FAULT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack HW AFE Communication Fault")),
		RACK_HW_ACTOR_DRIVER_FAULT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack HW Actor Driver Fault")),
		RACK_HW_EEPROM_COMMUNICATION_FAULT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack HW EEPROM Communication Fault")),
		RACK_HW_VOLTAGE_DETECT_FAULT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack HW Voltage Detect Voltage")),
		RACK_HW_TEMPERATURE_DETECT_FAULT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack HW Temperature Detect Fault")),
		RACK_HW_CURRENT_DETECT_FAULT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack HW Current Detect Fault")),
		RACK_HW_ACTOR_NOT_CLOSE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack HW Actor Not Close")),
		RACK_HW_ACTOR_NOT_OPEN(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack HW Actor Not Open")),
		RACK_HW_FUSE_BROKEN(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack HW Fuse Broken")),
		RACK_SYSTEM_AFE_OVER_TEMPERATURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack System AFE Over Temperature")),
		RACK_SYSTEM_AFE_UNDER_TEMPERATURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack System AFE Under Temperature")),
		RACK_SYSTEM_AFE_OVER_VOLTAGE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack System AFE Over Voltage")),
		RACK_SYSTEM_AFE_UNDER_VOLTAGE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack System AFE Over Temperature")),
		RACK_SYSTEM_HIGH_TEMPERATURE_PERMANENT_FAILURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack System High Temperature Permanent Failure")),
		RACK_SYSTEM_LOW_TEMPERATURE_PERMANENT_FAILURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack System  Low Temperature Permanent Failure")),
		RACK_SYSTEM_HIGH_CELL_VOLTAGE_PERMANENT_FAILURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack System  High Cell Voltage Permanent Failure")),
		RACK_SYSTEM_LOW_CELL_VOLTAGE_PERMANENT_FAILURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack System  Low Cell Voltage Permanent Failure")),
		RACK_SYSTEM_SHORT_CIRCUIT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Rack System Low Cell Voltage Permanent Failure")),
		UPPER_VOLTAGE(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.VOLT) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("CV Point")),
		BCU_2_BMS_SOFTWARE_VERSION(Doc.of(OpenemsType.INTEGER) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Bcu 2 Bms Software Version")),
		BCU_3_BMS_SOFTWARE_VERSION(Doc.of(OpenemsType.INTEGER) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Bcu 3 Bms Software Version")),
		BCU_BMS_HARDWARE_VERSION(Doc.of(OpenemsType.INTEGER) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Bcu Bms Hardware Version")),
		
		//BCU Status Flags
		STATUS_ALARM(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Status Alarm")),
		STATUS_WARNING(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Status WARNNG")),
		STATUS_FAULT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Status BCU Status Fault")),
		STATUS_PFET(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Status Pre-Charge FET On/Off")),
		STATUS_CFET(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Status Charge FET On/Off")),
		STATUS_DFET(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Status Discharge FET On/Off")),
		STATUS_BATTERY_IDLE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Status Battery Idle")),
		STATUS_BATTERY_CHARGING(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Status Battery Charging")),
		STATUS_BATTERY_DISCHARGING(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Status Battery Discharging")),
		
		//Bcu Alarm Flags
		PRE_ALARM_CELL_OVER_VOLTAGE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Alarm Cell Over Voltage")),
		PRE_ALARM_CELL_UNDER_VOLTAGE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Alarm Cell Under Voltage")),
		PRE_ALARM_OVER_CHARGING_CURRENT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Alarm Over Charging Current")),
		PRE_ALARM_OVER_DISCHARGING_CURRENT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Alarm Over Discharging Current")),
		PRE_ALARM_OVER_TEMPERATURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Alarm Over Temperature")),
		PRE_ALARM_UNDER_TEMPERATURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Alarm Under Temperature")),
		PRE_ALARM_CELL_VOLTAGE_DIFFERENCE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Alarm Cell Voltage Difference")),
		PRE_ALARM_BCU_TEMP_DIFFERENCE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Alarm BCU Temperature Difference")),
		PRE_ALARM_UNDER_SOC(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Alarm Under SOC")),
		PRE_ALARM_UNDER_SOH(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Alarm Under SOH")),
		PRE_ALARM_OVER_CHARGING_POWER(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Alarm Over Charging Power")),
		PRE_ALARM_OVER_DISCHARGING_POWER(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Alarm Over Discharging Power")),
		
		//Bcu Warning Flags
		LEVEL_1_CELL_OVER_VOLTAGE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Warning Cell Over Voltage")),
		LEVEL_1_CELL_UNDER_VOLTAGE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Warning Cell Under Voltage")),
		LEVEL_1_OVER_CHARGING_CURRENT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Warning Over Charging Current")),
		LEVEL_1_OVER_DISCHARGING_CURRENT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Warning Over Discharging Current")),
		LEVEL_1_OVER_TEMPERATURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Warning Over Temperature")),
		LEVEL_1_UNDER_TEMPERATURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Warning Under Temperature")),
		LEVEL_1_CELL_VOLTAGE_DIFFERENCE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Warning Cell Voltage Difference")),
		LEVEL_1_BCU_TEMP_DIFFERENCE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Warning BCU Temperature Difference")),
		LEVEL_1_UNDER_SOC(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Warning Under SOC")),
		LEVEL_1_UNDER_SOH(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Warning Under SOH")),
		LEVEL_1_OVER_CHARGING_POWER(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Warning Over Charging Power")),
		LEVEL_1_OVER_DISCHARGING_POWER(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Warning Over Discharging Power")),
		
		//Bcu Fault Flags
		LEVEL_2_CELL_OVER_VOLTAGE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Fault Cell Over Voltage")),
		LEVEL_2_CELL_UNDER_VOLTAGE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Fault Cell Under Voltage")),
		LEVEL_2_OVER_CHARGING_CURRENT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Fault Over Charging Current")),
		LEVEL_2_OVER_DISCHARGING_CURRENT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Fault Over Discharging Current")),
		LEVEL_2_OVER_TEMPERATURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Fault Over Temperature")),
		LEVEL_2_UNDER_TEMPERATURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Fault Under Temperature")),
		LEVEL_2_CELL_VOLTAGE_DIFFERENCE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Fault Cell Voltage Difference")),
		LEVEL_2_BCU_TEMP_DIFFERENCE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Fault BCU Temperature Difference")),
		LEVEL_2_TEMPERATURE_DIFFERENCE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Fault BCU Temperature Difference")),
		LEVEL_2_INTERNAL_COMMUNICATION(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Fault Internal Communication")),
		LEVEL_2_EXTERNAL_COMMUNICATION(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Fault External Communication")),
		LEVEL_2_PRECHARGE_FAIL(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Fault Pre-Charge Fail")),
		LEVEL_2_PARALLEL_FAIL(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Fault Parallel Fail")),
		LEVEL_2_SYSTEM_FAIL(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Fault System Fault")),
		LEVEL_2_HARDWARE_FAIL(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Fault Hardware Fault")),
		
		//Bcu HW Fault Detail
		HW_AFE_COMMUNICAITON_FAULT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU HW AFE Communication Fault")),
		HW_ACTOR_DRIVER_FAULT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU HW Actor Driver Fault")),
		HW_EEPROM_COMMUNICATION_FAULT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU HW EEPROM Communication Fault")),
		HW_VOLTAGE_DETECT_FAULT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU HW Voltage Detect Fault")),
		HW_TEMPERATURE_DETECT_FAULT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU HW Temperaure Detect Fault")),
		HW_CURRENT_DETECT_FAULT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU HW Current Detect Fault")),
		HW_ACTOR_NOT_CLOSE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU HW Actor Not Close Fault")),
		HW_ACTOR_NOT_OPEN(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU HW Actor Not Open")),
		HW_FUSE_BROKEN(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU HW Fuse Broken Fault ")),
		
		//Bcu System Fault Detail
		SYSTEM_AFE_OVER_TEMPERATURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE)//
				.text("BCU System AFE Over Temperature Fault")),
		SYSTEM_AFE_UNDER_TEMPERATURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU System AFE Under Temperature Fault")),
		SYSTEM_AFE_OVER_VOLTAGE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU System AFE Over Voltage Fault")),
		SYSTEM_AFE_UNDER_VOLTAGE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU System AFE Under Voltage Fault")),
		SYSTEM_HIGH_TEMPERATURE_PERMANENT_FAILURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU System High Temperature Permanent Fault")),
		SYSTEM_LOW_TEMPERATURE_PERMANENT_FAILURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU System Low Temperature Permanent Fault")),
		SYSTEM_HIGH_CELL_VOLTAGE_PERMANENT_FAILURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU System High Cell Voltage Permanent Fault")),
		SYSTEM_LOW_CELL_VOLTAGE_PERMANENT_FAILURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU System Low Cell Voltage Permanent Fault")),
		BCU_SYSTEM_LOW_CELL_VOLTAGE_FAILURE(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU System Low Cell Voltage Permanent Fault")),
		SYSTEM_SHORT_CIRCUIT(Doc.of(OpenemsType.BOOLEAN) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU System Short Circuit Fault")),
		
		//Rest of the Bcu registers
		TOWER_SOC(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.PERCENT) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU SOC")),
		BCU_SOH(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.PERCENT) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU SOH")),
		BCU_VOLTAGE(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.VOLT) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Battery BCU Voltage")),
		BCU_CURRENT(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.AMPERE) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Battery BCU Current")),
		BCU_MIN_CELL_VOLTAGE(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.MILLIVOLT) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Min Cell Voltage")),
		BCU_MAX_CELL_VOLTAGE(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.MILLIVOLT) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Maxc Cell Voltage")),
		AVERAGE_CELL_VOLTAGE(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.MILLIVOLT) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Average Of All Cell Voltages")),
		BCU_MAX_CHARGE_CURRENT(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.AMPERE) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU DC Charge Current Limit")),
		MIN_CHARGE_CURRENT(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.AMPERE) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU DC Discharge Current Limit")),
		BMS_SERIAL_NUMBER(Doc.of(OpenemsType.INTEGER) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BMS Serial Number")),
		NO_OF_CYCLES(Doc.of(OpenemsType.INTEGER) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Number Of Full charged/discharged cycles")),
		DESIGN_CAPACITY(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.AMPERE_HOURS) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Design Capacity Of the Module")),
		USEABLE_CAPACITY(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.AMPERE_HOURS) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Useable Cpacity Of The Module")),
		REMAINING_CAPACITY(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.AMPERE_HOURS) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Remaning Cpacity Of The Module")),
		MAX_CELL_VOLTAGE_LIMIT(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.MILLIVOLT) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Max Cell Voltage Limit")),
		MIN_CELL_VOLTAGE_LIMIT(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.MILLIVOLT) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BCU Min Cell Voltage Limit")),
		BMU_NUMBER(Doc.of(OpenemsType.INTEGER) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Bmu Number")),
		BMU_SOFTWARE_VERSION(Doc.of(OpenemsType.INTEGER) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BMU Software Version")),
		BMU_HARDWARE_VERSION(Doc.of(OpenemsType.INTEGER) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("BMU Hardware Version")),
		BMU_MAX_CELL_VOLTAGE(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.MILLIVOLT)//
				.accessMode(AccessMode.READ_WRITE) //
				.text("BMU Max Cell Voltage")),
		BMU_MIN_CELL_VOLTAGE(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.MILLIVOLT)//
				.accessMode(AccessMode.READ_WRITE) //
				.text("BMU Min Cell Voltage")),
		BMU_MAX_TEMPERATURE(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.DEGREE_CELSIUS)//
				.accessMode(AccessMode.READ_WRITE) //
				.text("Max BMU Temperature")),
		BMU_MIN_TEMPERATURE(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.DEGREE_CELSIUS)//
				.accessMode(AccessMode.READ_WRITE) //
				.text("Min BMU Temperature")),
		SUM_VOLTAGE(Doc.of(OpenemsType.INTEGER) //
				.unit(Unit.VOLT)//
				.accessMode(AccessMode.READ_WRITE) //
				.text("BMU Sum Voltage")),
		BMS_CONTROL(Doc.of(BmsControl.values()) //
				.text("BMS CONTROL(1: Shutdown, 0: no action, 2: Ignore)")),
		KEEP_FET_OPEN(Doc.of(OpenemsType.INTEGER) //
				.accessMode(AccessMode.READ_WRITE) //
				.text("Keep FET Open (Disconnect the relay; 1:Keep open, 0: normal operation)")),
		STATE_MACHINE(Doc.of(State.values()) //
				.text("Current State of State-Machine")), //
		RUN_FAILED(Doc.of(Level.FAULT) //
				.text("Running the Logic failed")), //
		;

		private final Doc doc;

		private ChannelId(Doc doc) {
			this.doc = doc;
		}

		@Override
		public Doc doc() {
			return this.doc;
		}
	}
}
