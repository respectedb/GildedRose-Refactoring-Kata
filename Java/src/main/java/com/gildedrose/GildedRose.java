import java.util.List;

public class GildedRose {

	public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
	public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	public static final String AGED_BRIE = "Aged Brie";
	
	private List<Item> items = null;

	public GildedRose(List<Item> items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			updateQuality(item);
			updateSellIn(item);
		}
	}

	private void updateQuality(Item item) {
		if (GildedRose.AGED_BRIE.equals(item.getName())) {
			if (item.getSellIn() > 0) {
				increaseQuality(item, 1);
			} else {
				increaseQuality(item, 2);
			}
		} else if (GildedRose.BACKSTAGE.equals(item.getName())) {
			if(item.getSellIn() > 10) {
				increaseQuality(item, 1);
			} else if (item.getSellIn() > 5) {
				increaseQuality(item, 2);
			} else if (item.getSellIn() > 0) {
				increaseQuality(item, 3);
			} else {
				item.setQuality(0);
			}
		} else if(GildedRose.SULFURAS.equals(item.getName())){
			
		} else {
			if (item.getSellIn() > 0) {
				decreaseQuality(item, 1);
			} else {
				decreaseQuality(item, 2);
			}
		}
	}

	private void updateSellIn(Item item) {
		if (GildedRose.SULFURAS.equals(item.getName()))
			return;
		
		item.setSellIn(item.getSellIn() - 1);
	}

	private void decreaseQuality(Item item, int amount) {
		int newQuality = Math.max(0, item.getQuality() - amount);
		item.setQuality(newQuality);
	}

	private void increaseQuality(Item item, int amount) {
		int newQuality = Math.min(50, item.getQuality() + amount);
		item.setQuality(newQuality);
	}

}
