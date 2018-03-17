package com.civclassic.ihatemaxopoly;

import org.bukkit.Location;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;

public class LightningPacketAdapter extends PacketAdapter {

	public LightningPacketAdapter(IHateMaxopoly plugin) {
		super(plugin, ListenerPriority.NORMAL, PacketType.Play.Server.SPAWN_ENTITY_WEATHER);
	}
	
	public void onPacketSending(PacketEvent event) {
		Location playerLoc = event.getPlayer().getLocation();
		StructureModifier<Integer> coords = event.getPacket().getIntegers();
		Location lightningLoc = new Location(playerLoc.getWorld(),
				coords.read(0) / 32, coords.read(1) / 32, coords.read(2) / 32);
		if(playerLoc.distance(lightningLoc) > 48) {
			event.setCancelled(true);
		}
	}
}
