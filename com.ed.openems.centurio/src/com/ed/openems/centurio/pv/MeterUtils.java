package com.ed.openems.centurio.pv;

import java.util.Arrays;
import java.util.stream.Stream;

import com.ed.openems.centurio.ess.CenturioErrorChannel;
import com.ed.openems.centurio.ess.CenturioEss;

import io.openems.edge.common.channel.AbstractReadChannel;
import io.openems.edge.common.channel.FloatReadChannel;
import io.openems.edge.common.channel.IntegerReadChannel;
import io.openems.edge.common.channel.IntegerWriteChannel;
import io.openems.edge.common.channel.StateCollectorChannel;
import io.openems.edge.common.component.OpenemsComponent;
import io.openems.edge.meter.api.AsymmetricMeter;
import io.openems.edge.meter.api.SymmetricMeter;
import io.openems.edge.pvinverter.api.SymmetricPvInverter;

public class MeterUtils {

	public static Stream<? extends AbstractReadChannel<?>> initializeChannels(CenturioPVMeter c) {
		// TODO Auto-generated method stub
		return Stream.of(Arrays.stream(OpenemsComponent.ChannelId.values()).map(channelId -> {
			switch (channelId) {
			case STATE:
				return new StateCollectorChannel(c, channelId);
			}
			return null;
		}), Arrays.stream(SymmetricMeter.ChannelId.values()).map(channelId -> {
			switch (channelId) {
			case ACTIVE_POWER:
			case MAX_ACTIVE_POWER:
			case MIN_ACTIVE_POWER:
			case REACTIVE_POWER:
			case CURRENT:
			case VOLTAGE:
			case FREQUENCY:
			case ACTIVE_PRODUCTION_ENERGY:
			case ACTIVE_CONSUMPTION_ENERGY:
				return new IntegerReadChannel(c, channelId);

			}
			return null;
		}), Arrays.stream(SymmetricPvInverter.ChannelId.values()).map(channelId -> {
			switch (channelId) {
			case ACTIVE_POWER_LIMIT:
				return new IntegerWriteChannel(c, channelId);

			}
			return null;
		}), Arrays.stream(AsymmetricMeter.ChannelId.values()).map(channelId -> {
			switch (channelId) {
			case ACTIVE_POWER_L1:
			case ACTIVE_POWER_L2:
			case ACTIVE_POWER_L3:

			case CURRENT_L1:
			case CURRENT_L2:
			case CURRENT_L3:

			case REACTIVE_POWER_L1:
			case REACTIVE_POWER_L2:
			case REACTIVE_POWER_L3:
			case VOLTAGE_L1:
			case VOLTAGE_L2:
			case VOLTAGE_L3:
				return new IntegerReadChannel(c, channelId, 0);

			}
			return null;
		}), Arrays.stream(CenturioPVMeter.ChannelId.values()).map(channelId -> {
			switch (channelId) {
			
			case PV_VOLTAGE0:
			case PV_VOLTAGE1:
				return new FloatReadChannel(c, channelId);
			default:
				break;
			}
			return null;
		})).flatMap(channel -> channel);
	}

}
