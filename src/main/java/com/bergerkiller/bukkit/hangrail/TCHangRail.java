package com.bergerkiller.bukkit.hangrail;

import org.bukkit.plugin.java.JavaPlugin;

import com.bergerkiller.bukkit.tc.rails.type.RailType;

public class TCHangRail extends JavaPlugin {
	private final RailTypeHanging hangingType = new RailTypeHanging();

	@Override
	public void onEnable() {
		RailType.register(hangingType, false);
	}

	@Override
	public void onDisable() {
		RailType.unregister(hangingType);
	}
}
