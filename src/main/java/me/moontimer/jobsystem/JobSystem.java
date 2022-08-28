package me.moontimer.jobsystem;

import me.moontimer.jobsystem.handler.Job;
import me.moontimer.jobsystem.handler.JobHandler;
import me.moontimer.jobsystem.inventory.InventoryListener;
import me.moontimer.jobsystem.listener.jobs.FisherListener;
import me.moontimer.jobsystem.listener.jobs.JaegerListener;
import me.moontimer.jobsystem.listener.jobs.MinerListener;
import me.moontimer.jobsystem.listener.jobs.WoodListener;
import net.jitse.npclib.NPCLib;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.material.Wood;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class JobSystem extends JavaPlugin {

    private static JobSystem instance;
    private static Economy econ = null;
    private NPCLib library;

    @Override
    public void onEnable() {

        instance = this;

        if (!setupEconomy() ) {
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        this.library = new NPCLib(this);

        Bukkit.getPluginManager().registerEvents(new FisherListener(), this);
        Bukkit.getPluginManager().registerEvents(new JaegerListener(), this);
        Bukkit.getPluginManager().registerEvents(new MinerListener(), this);
        Bukkit.getPluginManager().registerEvents(new WoodListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static JobSystem getInstance() {
        return instance;
    }

    public static Economy getEconomy() {
        return econ;
    }

    public NPCLib getNPCLib() {
        return library;
    }
}
