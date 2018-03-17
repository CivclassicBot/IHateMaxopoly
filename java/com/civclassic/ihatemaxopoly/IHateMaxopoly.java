package com.civclassic.ihatemaxopoly;

import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.ProtocolLibrary;

public class IHateMaxopoly extends JavaPlugin {

	public void onEnable() {
		ProtocolLibrary.getProtocolManager().addPacketListener(new LightningPacketAdapter(this));
	}
}
