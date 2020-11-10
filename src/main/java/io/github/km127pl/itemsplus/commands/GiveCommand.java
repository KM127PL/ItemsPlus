package io.github.km127pl.itemsplus.commands;


import io.github.km127pl.itemsplus.handlers.YMLFileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;

@SuppressWarnings("unused")
public class GiveCommand implements CommandExecutor {
	
	private final Plugin plugin;

	public GiveCommand(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("i")) { 
			if(sender instanceof Player) {
				Player p = (Player) sender;
				
				if(args.length == 0) {
					p.sendMessage(ChatColor.GREEN + "Please pass in some arguments.");
					return true;
				}
				if(YMLFileManager.items.containsKey(args[0])) {
					ItemStack item = YMLFileManager.items.get(args[0]);	
					if(args.length >= 2) 
						item.setAmount(Integer.parseInt(args[1]));
					p.getInventory().addItem(item);
					p.sendMessage(ChatColor.GREEN + "Giving you " + ChatColor.YELLOW + "" + item.getAmount() + "x " + args[0]);
					return true;
				}
				p.sendMessage(ChatColor.GREEN + "This item does not exist");
				return true;
			} 
			return false; 
		}
		return false; 
	} 
}
