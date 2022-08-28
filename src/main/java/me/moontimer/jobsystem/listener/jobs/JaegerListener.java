package me.moontimer.jobsystem.listener.jobs;

import me.moontimer.jobsystem.JobSystem;
import me.moontimer.jobsystem.handler.Job;
import me.moontimer.jobsystem.handler.JobHandler;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class JaegerListener implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Player player = event.getEntity().getKiller();
        if (JobHandler.isInJob(player, Job.Jaeger)) {
            Entity entity = event.getEntity();

            switch (entity.getType()) {
                case CREEPER:
                case SPIDER:
                case COW:
                case WOLF:
                    JobSystem.getEconomy().depositPlayer(player, 5);
                    break;
                case ZOMBIE:
                case PIG_ZOMBIE:
                case CAVE_SPIDER:
                    JobSystem.getEconomy().depositPlayer(player, 3);
                    break;
                case SKELETON:
                case ZOMBIE_VILLAGER:
                case MULE:
                case SHEEP:
                case PIG:
                    JobSystem.getEconomy().depositPlayer(player, 4);
                    break;
                case ENDERMITE:
                case SILVERFISH:
                case RABBIT:
                    JobSystem.getEconomy().depositPlayer(player, 1);
                    break;
                case ENDERMAN:
                case SLIME:
                    JobSystem.getEconomy().depositPlayer(player, 6);
                    break;
                case BLAZE:
                case SHULKER:
                case HORSE:
                    JobSystem.getEconomy().depositPlayer(player, 8);
                    break;
                case GHAST:
                    JobSystem.getEconomy().depositPlayer(player, 13);
                    break;
                case MAGMA_CUBE:
                    JobSystem.getEconomy().depositPlayer(player, 10);
                    break;
                case WITCH:
                    JobSystem.getEconomy().depositPlayer(player, 7);
                    break;
                case WITHER_SKELETON:
                    JobSystem.getEconomy().depositPlayer(player, 12);
                    break;
                case CHICKEN:
                    JobSystem.getEconomy().depositPlayer(player, 2);
                    break;
                case OCELOT:
                    JobSystem.getEconomy().depositPlayer(player, 11);
                    break;
            }
        }
    }
}
