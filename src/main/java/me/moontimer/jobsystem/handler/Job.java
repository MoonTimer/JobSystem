package me.moontimer.jobsystem.handler;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;

public enum Job {

    Jaeger("Jäger", 1),
    Miner("Miner", 2),
    Farmer("Farmer", 3),
    Fisher("Fisher",4),
    Holzfaeller("Holzfäller", 5);

    private final String name;
    private final int id;

    Job(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
