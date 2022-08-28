package me.moontimer.jobsystem.listener;

import me.moontimer.jobsystem.handler.JobHandler;
import me.moontimer.jobsystem.sql.MySQLHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        JobHandler.jobs.put(event.getPlayer(), MySQLHandler.getJob(event.getPlayer()));
    }
}
