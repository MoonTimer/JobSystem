package me.moontimer.jobsystem.listener.jobs;

import me.moontimer.jobsystem.JobSystem;
import me.moontimer.jobsystem.handler.Job;
import me.moontimer.jobsystem.handler.JobHandler;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Player;
import org.bukkit.entity.TropicalFish;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerFishEvent;

public class FisherListener implements Listener {

    @EventHandler
    public void onFish(PlayerFishEvent event) {
        Player player = event.getPlayer();
        if (event.getState().equals(PlayerFishEvent.State.CAUGHT_FISH)) {
            if (JobHandler.isInJob(player, Job.Fisher)) {
                JobSystem.getEconomy().depositPlayer(player, 5);
            }
        }
    }
}
