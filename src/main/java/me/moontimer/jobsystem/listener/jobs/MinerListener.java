package me.moontimer.jobsystem.listener.jobs;

import me.moontimer.jobsystem.JobSystem;
import me.moontimer.jobsystem.handler.Job;
import me.moontimer.jobsystem.handler.JobHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class MinerListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getPlayer().getWorld().getName().equalsIgnoreCase("farmwelt")) {


            if (JobHandler.isInJob(event.getPlayer(), Job.Miner)) {
                Player player = event.getPlayer();
                switch (event.getBlock().getType()) {
                    case COAL_ORE:
                        JobSystem.getEconomy().depositPlayer(player, 4);
                        break;
                    case IRON_ORE:
                        JobSystem.getEconomy().depositPlayer(player, 5);
                        break;
                    case REDSTONE_ORE:
                    case GOLD_ORE:
                    case QUARTZ_ORE:
                        JobSystem.getEconomy().depositPlayer(player, 6);
                        break;
                    case LAPIS_ORE:
                        JobSystem.getEconomy().depositPlayer(player, 8);
                        break;
                    case DIAMOND_ORE:
                        JobSystem.getEconomy().depositPlayer(player, 14);
                        break;
                    case EMERALD_ORE:
                        JobSystem.getEconomy().depositPlayer(player, 18);
                        break;
                }
            } else if (JobHandler.isInJob(event.getPlayer(), Job.Farmer)) {
                Player player = event.getPlayer();
                switch (event.getBlock().getType()) {
                    case SUGAR_CANE:
                        JobSystem.getEconomy().depositPlayer(player, 0.5);
                        break;
                    case WHEAT:
                    case BEETROOT:
                        JobSystem.getEconomy().depositPlayer(player, 1);
                        break;
                    case COCOA:
                    case MELON_STEM:
                    case PUMPKIN:
                    case CARROT:
                    case POTATO:
                        JobSystem.getEconomy().depositPlayer(player, 2);
                        break;
                    case NETHER_WART_BLOCK:
                        JobSystem.getEconomy().depositPlayer(player, 3);
                        break;
                }
            }
        }
    }
}
