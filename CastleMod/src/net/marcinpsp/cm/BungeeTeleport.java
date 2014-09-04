package net.marcinpsp.cm;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BungeeTeleport {
	
private HashSet<String> connPlayer = new HashSet<String>();

public BungeeTeleport(){
Bukkit.getMessenger().registerOutgoingPluginChannel(Main.getPlugin(), "BungeeCord");}

public void sendAllPlayerServer(final Player player, String nameServer){
if (this.connPlayer.contains(player.getName())) {
return;}
ByteArrayOutputStream b = new ByteArrayOutputStream();
DataOutputStream out = new DataOutputStream(b);
}

}
