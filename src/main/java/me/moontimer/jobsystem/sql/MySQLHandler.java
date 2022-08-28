package me.moontimer.jobsystem.sql;

import me.moontimer.jobsystem.JobSystem;
import me.moontimer.jobsystem.handler.Job;
import me.moontimer.jobsystem.handler.JobHandler;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MySQLHandler {

    private static MySQL mySQL = JobSystem.getInstance().getMySQL();
    public static void updateJob(Player player, Job job) {
        if (isRegistered(player)) {
            mySQL.execute("UPDATE Jobs SET Job = '" + job.getId() + "' WHERE UUID = '" + player.getUniqueId().toString() + "'");
        } else {
            mySQL.execute("INSERT INTO PlayerTimes (UUID, Job) VALUES ('" + player.getUniqueId().toString() + "', '" + job.getId() + "')");
        }
    }

    public static Job getJob(Player player) {
        try {
            ResultSet rs = mySQL.executeQuery("SELECT * FROM Jobs WHERE UUID = '" + player.getUniqueId().toString() + "'");
            if (rs.next())
                return JobHandler.getJobFromInt(rs.getInt("Job"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static boolean isRegistered(Player player) {
        try {
            ResultSet rs = mySQL.executeQuery("SELECT * FROM Jobs WHERE UUID = '" + player.getUniqueId().toString() + "'");
            if (rs.next())
                return (rs.getInt("Job") != 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
