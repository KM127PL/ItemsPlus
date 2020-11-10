package io.github.km127pl.itemsplus.etc;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Functions {
	

	public static void giveItemStack(Player player, ItemStack is, int amount) {
		is.setAmount(amount);
	    player.getInventory().addItem(is);
	}
	
	public static Object eval(String function) {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		Object result = null;
		try {
			result = engine.eval(function);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
