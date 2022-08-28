package me.moontimer.jobsystem.commands;

import me.moontimer.jobsystem.JobSystem;
import net.jitse.npclib.api.NPC;
import net.jitse.npclib.api.skin.Skin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class SetNPCCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        NPC npc = JobSystem.getInstance().getNPCLib().createNPC(Collections.singletonList("§aJobs"));

        npc.setLocation(player.getLocation());

        return false;
    }
}
