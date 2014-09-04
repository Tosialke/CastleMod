package net.marcinpsp.cm;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BungeeTeleport {
	
private HashSet<String> connPlayer = new HashSet<String>();

public BungeeTeleport(){
Bukkit.getMessenger().registerOutgoingPluginChannel(Main.getPlugin(), "BungeeCord");}

public void sendAllPlayer(String serverName){
for (Player player : Bukkit.getOnlinePlayers()){
sendPlayerServer(player, serverName);}}

public void sendPlayerServer(final Player player, String nameServer){
if (this.connPlayer.contains(player.getName())) {
return;}
ByteArrayOutputStream b = new ByteArrayOutputStream();
DataOutputStream out = new DataOutputStream(b);
try{
out.writeUTF("Connect");
out.writeUTF(nameServer);
}catch (IOException localIOException1){
try{
out.close();
}catch (IOException e){
e.printStackTrace();}}
finally{
try{
out.close();
}catch (IOException e){
e.printStackTrace();}}
player.sendPluginMessage(Main.getPlugin(), "BungeeCord", b.toByteArray());
this.connPlayer.add(player.getName());

Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable(){
public void run(){
BungeeTeleport.this.connPlayer.remove(player.getName());}}
, 40L);}

}
