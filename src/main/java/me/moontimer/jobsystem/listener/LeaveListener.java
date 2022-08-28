package me.moontimer.jobsystem.listener;

import me.moontimer.jobsystem.handler.Job;
import me.moontimer.jobsystem.handler.JobHandler;
import me.moontimer.jobsystem.sql.MySQLHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        MySQLHandler.updateJob(player, JobHandler.getJobFromPlayer(player));
    }
}
