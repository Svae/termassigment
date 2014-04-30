package termassigment.genericmapuitestclient.component;

import com.bitreactive.library.mqtt.MQTTConfigParam;
import com.bitreactive.library.mqtt.mqtt2.MQTT2.Message;

import no.ntnu.item.arctis.runtime.Block;

public class Component extends Block {

	public MQTTConfigParam config() {
		MQTTConfigParam p = new MQTTConfigParam("broker.mqttdashboard.com", 1883);
		return p;
	}

	public Message createMessage(String payload) {
		Message m = new Message(payload.getBytes(), "generic-map-ui");
		return m;
	}
}