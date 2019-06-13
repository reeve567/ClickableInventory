package pw.xwy.clickable_inventory;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class NonClickableItem extends ClickableItem {
	public NonClickableItem(ItemStack itemStack) {
		super(itemStack);
	}

	@Override
	public void onClick(InventoryClickEvent e) {
		e.setCancelled(true);

	}
}
