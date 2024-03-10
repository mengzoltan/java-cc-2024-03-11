/*
https://github.com/emilybache/GildedRose-Refactoring-Kata
*/
package org.training.gildedrose;

class GildedRose {

    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";

    public static final int MAXIMUM_QUALITY = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                continue;
            }

            if (isItSpecialItem(item)) {
                handleSpecialItem(item);
            } else if (item.quality > 0) {
                decreaseQuality(item);
            }

            decreaseSellInDays(item);

            if (item.sellIn < 0) {
                handleNegativeSellInDay(item);
            }
        }
    }

    private void handleNegativeSellInDay(Item item) {
        if (!item.name.equals(AGED_BRIE)) {
            if (!item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                if (item.quality > 0 && !item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                    item.quality = item.quality - 1;
                }
            } else {
                item.quality = 0;
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

    private void decreaseSellInDays(Item item) {
        item.sellIn--;
    }

    private void handleSpecialItem(Item item) {
        if (item.quality < MAXIMUM_QUALITY) {
            item.quality = item.quality + 1;

            if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                handleBackstagePasses(item);
            }
        }
    }

    private void handleBackstagePasses(Item item) {
        if (item.sellIn < 11 && item.quality < 50) {
            item.quality = item.quality + 1;
        }

        if (item.sellIn < 6 && item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private boolean isItSpecialItem(Item item) {
        return item.name.equals(AGED_BRIE)
                || item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)
                || item.name.equals(SULFURAS_HAND_OF_RAGNAROS);
    }
}