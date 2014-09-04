package net.marcinpsp.cm;

import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import data.ArenaData;

public class Main extends JavaPlugin{
	
public static Main plugin= null;
public static HashMap<String, ArenaData> arens = new HashMap<>();

public void onEnable(){
plugin = this;
Config.prepareYamls(this);
Config.loadYamls();
BungeeTeleport bt = new BungeeTeleport();

}

public static void sendMessage(Level l, String msg){
Bukkit.getLogger().log(l, msg);}

public static Main getPlugin(){
return plugin;}

public static String getColors(String string) {
for (ChatColor cc : ChatColor.values())
string = string.replaceAll("&" + cc.getChar(), cc.toString());
return string;}

}
