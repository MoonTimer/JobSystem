package me.moontimer.jobsystem.inventory;

import me.moontimer.jobsystem.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class JobInventory {
    private final Player player;

    public JobInventory(Player player) {
        this.player = player;

        Inventory inventory = Bukkit.createInventory(null, 9, "§aJobs");

        inventory.setItem(2, new ItemBuilder(Material.DIAMOND_SWORD, "§aJäger").build());
        inventory.setItem(3, new ItemBuilder(Material.STONE_PICKAXE, "§aMiner").build());
        inventory.setItem(4, new ItemBuilder(Material.WHEAT, "§aFarmer").build());
        inventory.setItem(5, new ItemBuilder(Material.FISHING_ROD, "§aFischer").build());
        inventory.setItem(6, new ItemBuilder(Material.WOOD, "§aHolzfäller").build());

        player.openInventory(inventory);

    }
}
