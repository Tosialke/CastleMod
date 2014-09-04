package net.marcinpsp.cm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class Config {
	
public static File configFile;
public static File dataFile;
public static FileConfiguration cf;
public static FileConfiguration dt;

public static void prepareYamls(Plugin plugin){
configFile = new File(plugin.getDataFolder(), "config.yml");
dataFile = new File(plugin.getDataFolder(), "data.yml");
cf = new YamlConfiguration();
dt = new YamlConfiguration();
try{
if (!configFile.exists()){
configFile.getParentFile().mkdirs();
copy(plugin.getResource("config.yml"), configFile);}
if (!dataFile.exists()){
dataFile.getParentFile().mkdirs();
copy(plugin.getResource("data.yml"), dataFile);}
}catch (Exception e){
Main.sendMessage(Level.WARNING, e.getMessage());}}

public static void loadYamls(){
try{
cf.load(configFile);
dt.load(dataFile);
}catch (Exception e){
Main.sendMessage(Level.WARNING, e.getMessage());}}

public static MemorySection getConfig(){
return cf;}

public static MemorySection getData(){
return dt;}

public static void saveData(){
try{
cf.save(configFile);
dt.save(dataFile);
}catch (IOException e){
Main.sendMessage(Level.WARNING, e.getMessage());}}

public static String isMessage(String msg){
return Main.getColors(Config.getConfig().getString("Message." + msg));}

public static void reload() throws InvalidConfigurationException{
try{
cf.load(configFile);
dt.load(dataFile);
}catch (Exception e){
Main.sendMessage(Level.WARNING, e.getMessage());}}
	
public static void copy(final InputStream in, final File file){
try{
try (OutputStream out = new FileOutputStream(file)){
final byte[] buf = new byte[1_024];
int len;
while ((len = in.read(buf)) > 0){	
out.write(buf, 0, len);}}
in.close();
}catch (final Exception ex){
Main.sendMessage(Level.WARNING, ex.getMessage());}}

}
