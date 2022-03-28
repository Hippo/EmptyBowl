package rip.hippo.emptybowl;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Hippo
 */
public final class EmptyBowl extends JavaPlugin implements Listener {

  @Override
  public void onEnable() {
    getServer().getPluginManager().registerEvents(this, this);
  }

  @EventHandler(priority = EventPriority.LOWEST)
  public void onPlayerClick(PlayerInteractEvent event) {
    if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
      Player player = event.getPlayer();
      PlayerInventory inventory = player.getInventory();
      for (int i = 0; i < inventory.getContents().length; i++) {
        ItemStack item = inventory.getItem(i);
        if (item != null && item.getType() == Material.BOWL) {
          inventory.setItem(i, new ItemStack(Material.AIR));
        }
      }
    }
  }
}
