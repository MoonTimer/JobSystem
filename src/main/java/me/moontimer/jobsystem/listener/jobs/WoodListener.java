package me.moontimer.jobsystem.listener.jobs;

import me.moontimer.jobsystem.JobSystem;
import me.moontimer.jobsystem.handler.Job;
import me.moontimer.jobsystem.handler.JobHandler;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class WoodListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (event.getPlayer().getWorld().getName().equalsIgnoreCase("farmwelt") && JobHandler.isInJob(event.getPlayer(), Job.Holzfaeller)) {
            if (event.getBlock().getType().equals(Material.WOOD)) {
                JobSystem.getEconomy().depositPlayer(event.getPlayer(), 5);
            }
        }
    }
}
