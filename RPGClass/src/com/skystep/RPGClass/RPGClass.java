package com.skystep.RPGClass;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.skystep.RPGClass.Weapons.Weapons;

public class RPGClass extends JavaPlugin implements Listener
{
	/*
	 * This holds the configurations
	 * of the plugin in plugins/<plugins>/config.yml
	 */
	FileConfiguration config;

	/*
	 * This is an instance 
	 * of the plugin itself
	 */
	RPGClass plugin;

	/*
	 * This is what determines if
	 * messages with a level of 1
	 * importance are sent to the console
	 * 
	 *   ---->Message Levels<----
	 *      Level 1: Debugging
	 *      Level 2: Messages
	 *      Level 3: Info
	 *      Level 4: Errors
	 */
	boolean debugingMode;

	/*
	 * This.. i don't even
	 * know what im supposed 
	 * to do with this..
	 * i think it was just to
	 * initialize it as an object
	 */
	Weapons weapons;

	Logger BLogger;




	@EventHandler
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args)
	{
		return false;
	}
















	public void onEnable()
	{
		if(Init()){}
		else
			Bukkit.getPluginManager().disablePlugin(this);
	}



	public void onDisable(){}























	public boolean Init()
	{
		BLogger = Bukkit.getServer().getLogger();
		plugin = this;
		
		try
		{	
			loadConfiguration();
		}
		catch(Exception e)
		{
			log(1, "Could not load configurations file");
		}





		return true;
	}






	/* 
	 * this loads the configurations
	 * from the config.yml file
	 */
	public void loadConfiguration()
	{
		//Creates the defaults of the config
		getConfig().options().copyDefaults(true);
		//Save config after any changes
		saveConfig();
	}

	public void log(int l, String message)
	{
		message = "["+message+"]";
		
		if(debugingMode == false && l == 1) return;

		if (l == 1)
			BLogger.log(Level.INFO, ChatColor.BLUE+"[RPGClass] "+
		ChatColor.GOLD+"[Debugging] "+ChatColor.WHITE+message);

	}

















}



