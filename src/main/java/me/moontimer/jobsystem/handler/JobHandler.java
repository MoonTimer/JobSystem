package me.moontimer.jobsystem.handler;

import me.moontimer.jobsystem.JobSystem;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class JobHandler {

    public static HashMap<Player, Job> jobs = new HashMap<>();

    public static void addToJob(Player player, Job job) {
        jobs.put(player, job);
        player.sendMessage("§aDu bist nun " + job.getName());
    }

    public static void removeJobFromPlayer(Player player) {
        jobs.remove(player);
        player.sendMessage("Du hast deinen Job gekündigt");
    }

    public static boolean isInJob(Player player, Job job) {
        return jobs.get(player).equals(job);
    }

    public static Job getJobFromPlayer(Player player) {
        return jobs.get(player);
    }
}
