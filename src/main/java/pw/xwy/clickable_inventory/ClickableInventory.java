package pw.xwy.clickable_inventory;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class ClickableInventory implements Listener {

	private Map<Integer, ClickableItem> inventoryItems = new HashMap<>();
	private Inventory inventory;
	private String title;

	public ClickableInventory(JavaPlugin plugin, InventoryHolder inventoryOwner, int size, String title) {
		inventory = Bukkit.createInventory(inventoryOwner, size, title);
		this.title = title;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (e.getView().getTitle().equalsIgnoreCase(title) && e.getCurrentItem() != null) {
			ClickableItem item = inventoryItems.getOrDefault(e.getCurrentItem().hashCode(), null);
			if (item != null) {
				item.onClick(e);
			}
		}
	}

	public void setSlot(ClickableItem item, int... slots) {
		for (int i : slots) {
			inventory.setItem(i, item.itemStack);
		}
		inventoryItems.put(item.itemStack.hashCode(), item);
	}

	public void setBackground(NonClickableItem item) {
		for (int i = 0; i < inventory.getSize(); i++) {
			setSlot(item, i);
		}
	}

	public Inventory getInventory() {
		return inventory;
	}

	public String getTitle() {
		return title;
	}
}
