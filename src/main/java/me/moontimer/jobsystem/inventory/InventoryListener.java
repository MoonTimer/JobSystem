package me.moontimer.jobsystem.inventory;

import me.moontimer.jobsystem.handler.Job;
import me.moontimer.jobsystem.handler.JobHandler;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getInventory().getTitle().equalsIgnoreCase("§aJobs")) {

            switch (event.getCurrentItem().getType()) {
                case DIAMOND_SWORD:
                    JobHandler.addToJob(player, Job.Jaeger);
                    break;
                case STONE_PICKAXE:
                    JobHandler.addToJob(player, Job.Miner);
                    break;
                case WHEAT:
                    JobHandler.addToJob(player, Job.Farmer);
                    break;
                case FISHING_ROD:
                    JobHandler.addToJob(player, Job.Fisher);
                    break;
                case WOOD:
                    JobHandler.addToJob(player, Job.Holzfaeller);
                    break;
                default:
                    JobHandler.removeJobFromPlayer(player);
                    break;

            }
            event.setCancelled(true);
        }
    }
}
