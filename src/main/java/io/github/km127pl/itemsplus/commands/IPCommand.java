package io.github.km127pl.itemsplus.commands;

import io.github.km127pl.itemsplus.handlers.YMLFileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class IPCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			if(args.length == 0) {
				sender.sendMessage(ChatColor.GREEN + "Help command..");
				return true;
			} else if(args.length >= 1) {
				if(args[0].equals("reload")  || args[0].equals("restart")) {
					sender.sendMessage(ChatColor.GREEN + "Reloading item data files..");
					YMLFileManager.registerAllItems();
					return true;
				}
				return true;
			}
			return true;
		}
}
