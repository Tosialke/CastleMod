package net.marcinpsp.cm;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
public static Main plugin= null;


public void onEnable(){
plugin = this;

}


public static Main getPlugin(){
return plugin;}

}
