package pw.xwy.clickable_inventory;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public abstract class ClickableItem {

	protected ItemStack itemStack;

	public ClickableItem(ItemStack itemStack) {
		this.itemStack = itemStack;
	}

	public abstract void onClick(InventoryClickEvent e);
}
