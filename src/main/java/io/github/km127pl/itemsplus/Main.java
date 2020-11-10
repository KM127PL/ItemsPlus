package io.github.km127pl.itemsplus;

import io.github.km127pl.itemsplus.commands.GiveCommand;
import io.github.km127pl.itemsplus.commands.IPCommand;
import io.github.km127pl.itemsplus.handlers.YMLFileManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        this.getCommand("i").setExecutor(new GiveCommand(this));
        this.getCommand("ip").setExecutor(new IPCommand());
        YMLFileManager.registerAllItems();
    }

    @Override
    public void onDisable() {
        YMLFileManager.items.clear();
    }
}
