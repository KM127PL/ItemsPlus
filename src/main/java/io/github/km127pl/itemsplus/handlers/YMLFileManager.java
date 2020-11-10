package io.github.km127pl.itemsplus.handlers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.github.km127pl.itemsplus.Main;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class YMLFileManager {
	
	public static HashMap<String, ItemStack> items = new HashMap<String, ItemStack>();
	public static ArrayList<String> loadedFiles = new ArrayList<String>();
	
	
	private static File getDataFolder() {
		return Main.getPlugin(Main.class).getDataFolder();
	}
	
	private static Logger getLogger() {
		return Main.getPlugin(Main.class).getLogger();
	}
	
	public static void registerAllItems() {
		File f = new File(getDataFolder().getPath() + "/items/");
		
		if(!f.exists()) {
			getLogger().log(Level.WARNING, "Custom Items directory doesnt exist!");
			getLogger().log(Level.WARNING, "Creating a new one..");
			Path path = Paths.get(getDataFolder().getPath() + "/items/");
		    try {
				Files.createDirectories(path);
			} catch (IOException e) {
				getLogger().log(Level.WARNING, "Failed to create a directory!");
				getLogger().log(Level.WARNING, e.getStackTrace().toString());
			}
		}
		
        File[] list = f.listFiles();

        
        /*
         * Check if the directory is empty
         */
        if (list == null)
        	return;
        getLogger().log(Level.INFO, "Loading items..");
        
        
        for (File entry : list) {
        	getLogger().log(Level.INFO, "- " + entry.getName());
            
            if(entry.getName().endsWith("yml")) {
            	YamlConfiguration config = YamlConfiguration.loadConfiguration(entry);
            	
            	if(!config.contains("item") || !config.contains("name")) {
            		getLogger().log(Level.WARNING, "Item or Item name not found in " +  entry.getName() + " skipping..");
            		continue;
            	} 
            	
            	
            	String item = config.getString("item");
            	String name = config.getString("name");
            	String display = null;
            	if(!(item.equals(null)) || !(name.equals(null))) {
            		Material _mat;
            		try {
            			_mat = Material.getMaterial(config.get("item").toString().toUpperCase().replace(" ", "_"));
            		} catch(Exception e) {
            			_mat = Material.STONE;
            			e.printStackTrace();
            		}
            		
            		try {
            			if(_mat.equals(null))
                			_mat = Material.STONE;
            		} catch(NullPointerException e) {
            			e.printStackTrace();
            		}
            		
            		if(config.contains("display"))
                		display = config.getString("display");
                	
            		ItemStack _item = new ItemStack(_mat);
            		ItemMeta _meta = _item.getItemMeta();
            		
            		// Rarity modifier

            		// Display modifier
            		
            		if(display != null)
            			_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', display));
            		
            		_item.setItemMeta(_meta);
            		items.put((String) config.get("name"), _item);
            		getLogger().log(Level.INFO, "Loaded item  " + _item.getType() + " from " + entry.getName());
            		loadedFiles.add(entry.getName());
            		continue;
            	} 
            	throw new Error("Item or Item Name cannot be empty!");	
            }
        }
	}
}
