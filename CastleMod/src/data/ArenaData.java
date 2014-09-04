package data;

import java.util.ArrayList;

import net.marcinpsp.cm.Main;

public class ArenaData {
	
public int id;
public String name;
public ArrayList<String> blueTeam = new ArrayList<>();
public ArrayList<String> redTeam = new ArrayList<>();
public Main plugin;
public ArenaStatus ast;

public ArenaData(){
this.plugin = Main.getPlugin();}

public ArenaData(String name, int id){
this.name = name;
this.id = id;

}

public boolean isName(String name){
if (Main.arens.containsKey(name)){
return true;}
return false;}

public int getId(){
return this.id;}

public String getName(){
return this.name;}

public ArenaStatus getArenaStatus(){
return this.ast;}

public void setArenaStatus(ArenaStatus ast){
this.ast = ast;}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public enum ArenaStatus{
CL, ON, OFF, RES, IN, P, F;
}

}
