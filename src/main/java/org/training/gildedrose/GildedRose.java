/*
https://github.com/emilybache/GildedRose-Refactoring-Kata
*/
package org.training.gildedrose;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.function.Consumer;

@Slf4j
class GildedRose {

    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String CONJURED = "Conjured Mana Cake";

    public static final int MAXIMUM_QUALITY = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(item -> getItemHandlerByItemName(item).accept(item));
    }

    private Consumer<Item> getItemHandlerByItemName(Item item) {
        return switch (item.name) {
            case SULFURAS_HAND_OF_RAGNAROS -> (sulfur) -> log.info("{}'s quality never alters!", sulfur.name);
            case AGED_BRIE -> handleAgedBrie();
            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT -> handleBackstagePasses();
            case CONJURED -> handleConjured();
            default -> handleNormalItem();
        };
    }

    private Consumer<Item> handleConjured() {
        return (conjured) -> {
            if (conjured.quality > 0) {
                decreaseQuality(conjured);
            }
            decreaseSellInDays(conjured);
            if (conjured.sellIn < 0 && conjured.quality > 0) {
                decreaseQuality(conjured);
            }
            if (conjured.quality > 0) {
                decreaseQuality(conjured);
            }
        };
    }

    private Consumer<Item> handleBackstagePasses() {
        return (backstagePasses) -> {
            if (backstagePasses.quality < MAXIMUM_QUALITY) {
                backstagePasses.quality++;
                handleBackstagePasses(backstagePasses);
            }
            decreaseSellInDays(backstagePasses);
            if (backstagePasses.sellIn < 0) {
                backstagePasses.quality = 0;
            }
        };
    }

    private Consumer<Item> handleNormalItem() {
        return (normalItem) -> {
            if (normalItem.quality > 0) {
                decreaseQuality(normalItem);
            }
            decreaseSellInDays(normalItem);
            if (normalItem.sellIn < 0 && normalItem.quality > 0) {
                decreaseQuality(normalItem);
            }
        };
    }

    private Consumer<Item> handleAgedBrie() {
        return (agedBrie) -> {
            if (agedBrie.quality < MAXIMUM_QUALITY) {
                agedBrie.quality++;
            }
            decreaseSellInDays(agedBrie);
            if (agedBrie.sellIn < 0 && agedBrie.quality < MAXIMUM_QUALITY) {
                agedBrie.quality++;
            }
        };
    }

    private void decreaseSellInDays(Item item) {
        item.sellIn--;
    }

    private void handleBackstagePasses(Item item) {
        if (item.sellIn < 11 && item.quality < MAXIMUM_QUALITY) {
            item.quality++;
        }

        if (item.sellIn < 6 && item.quality < MAXIMUM_QUALITY) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        item.quality--;
    }
}