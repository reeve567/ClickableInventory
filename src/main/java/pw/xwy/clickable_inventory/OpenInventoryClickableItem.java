package pw.xwy.clickable_inventory;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class OpenInventoryClickableItem extends ClickableItem {
	private Inventory inventory;

	public OpenInventoryClickableItem(ItemStack itemStack, Inventory inventory) {
		super(itemStack);
		this.inventory = inventory;
	}

	@Override
	public void onClick(InventoryClickEvent e) {
		e.getWhoClicked().openInventory(inventory);
	}
}
