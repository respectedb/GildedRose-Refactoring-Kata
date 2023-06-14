package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void 하루마다_퀄리티_감소() {
        List<Item> items = new ArrayList<>();
        Item item = Item.builder().
                name(Constants.ETC).
                sellIn(10).
                quality(10).
                build();
        items.add(item);

        gildedRoseService.updateQuality(items);
        assertEquals(9, item.getQuality());
    }
    
    @Test
    void 판매기한초과_퀄리티_2배_감소() {
        List<Item> items = new ArrayList<>();
        Item item = Item.builder().
                name(Constants.ETC).
                sellIn(0).
                quality(10).
                build();
        items.add(item);

        gildedRoseService.updateQuality(items);
        assertEquals(8, item.getQuality());
    }
    
    @ParameterizedTest
    @CsvSource({"3, 13", "6, 12", "11, 11"})
    void BACKSTAGE_PASSES_판매일별_퀄리티_증가(int sellIn, int dayQuality) {
        List<Item> items = new ArrayList<>();
        Item item = Item.builder().
                name(Constants.BACKSTAGE_PASSES).
                sellIn(sellIn).
                quality(10).
                build();
        items.add(item);

        gildedRoseService.updateQuality(items);
        assertEquals(dayQuality, item.getQuality());
    }

}
