/*
https://github.com/emilybache/GildedRose-Refactoring-Kata
*/
package org.training.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void sulfuras_quality_check() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, items[0].quality);
        assertEquals(0, items[0].sellIn);
        app.updateQuality();
        assertEquals(80, items[0].quality);
        assertEquals(0, items[0].sellIn);
    }

    @Test
    void The_Quality_of_an_item_is_never_more_than_50() {
        int quality = 48;
        int sellIn = 0;
        Item agedBrie = new Item("Aged Brie", sellIn, quality);
        Item[] items = new Item[]{agedBrie};

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(quality+2, agedBrie.quality);
        assertEquals(sellIn-1, agedBrie.sellIn);

        app.updateQuality();

        assertEquals(50, agedBrie.quality);
        assertEquals(sellIn-2, agedBrie.sellIn);
    }

    @Test
    void testQualityAndSellInDropOnSimpleItems() {
        int quality = 2;
        int sellIn = 4;
        Item foo = new Item("foo", sellIn, quality);
        Item[] items = new Item[]{foo};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("foo", foo.name);
        assertEquals(quality-1, foo.quality);
        assertEquals(sellIn-1, foo.sellIn);
    }

    @Test
    void The_Quality_of_an_item_is_never_negative() {
        int quality = 0;
        int sellIn = 0;
        Item foo = new Item("foo", sellIn, quality);
        Item[] items = new Item[]{foo};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("foo", foo.name);
        assertEquals(0, foo.quality);
        assertEquals(sellIn-1, foo.sellIn);

        app.updateQuality();
        assertEquals(0, foo.quality);

    }

    @Test
    void Once_the_sell_by_date_has_passed_Quality_degrades_twice_as_fast() {
        int quality = 10;
        int sellIn = 0;
        Item foo = new Item("foo", sellIn, quality);
        Item[] items = new Item[]{foo};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("foo", foo.name);
        assertEquals(quality-2, foo.quality);
        assertEquals(sellIn-1, foo.sellIn);

        app.updateQuality();

        assertEquals("foo", foo.name);
        assertEquals(quality-4, foo.quality);
        assertEquals(sellIn-2, foo.sellIn);
    }

    @Test
    void Aged_Brie_actually_increases_in_Quality_the_older_it_gets() {
        int quality = 10;
        int sellIn = 4;
        Item agedBrie = new Item("Aged Brie", sellIn, quality);
        Item[] items = new Item[]{agedBrie};

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(quality+1, agedBrie.quality);
        assertEquals(sellIn-1, agedBrie.sellIn);

        app.updateQuality();

        assertEquals(quality+2, agedBrie.quality);
        assertEquals(sellIn-2, agedBrie.sellIn);
    }

    @Test
    void Aged_Brie_actually_increases_in_Quality_the_older_it_gets_twice_after_zero_sell_in() {
        int quality = 10;
        int sellIn = 0;
        Item agedBrie = new Item("Aged Brie", sellIn, quality);
        Item[] items = new Item[]{agedBrie};

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(quality+2, agedBrie.quality);
        assertEquals(sellIn-1, agedBrie.sellIn);

        app.updateQuality();

        assertEquals(quality+4, agedBrie.quality);
        assertEquals(sellIn-2, agedBrie.sellIn);
    }

    @Test
    void Backstage_Passes_Quality_increases_by_2_when_there_are_10_days() {
        int quality = 10;
        int sellIn = 10;
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
        Item[] items = new Item[]{backstagePasses};

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(quality+2, backstagePasses.quality);
        assertEquals(sellIn-1, backstagePasses.sellIn);

        app.updateQuality();

        assertEquals(quality+4, backstagePasses.quality);
        assertEquals(sellIn-2, backstagePasses.sellIn);
    }

    @Test
    void Backstage_Passes_Quality_increases_by_3_when_there_are_5_days() {
        int quality = 10;
        int sellIn = 5;
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
        Item[] items = new Item[]{backstagePasses};

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(quality+3, backstagePasses.quality);
        assertEquals(sellIn-1, backstagePasses.sellIn);

        app.updateQuality();

        assertEquals(quality+6, backstagePasses.quality);
        assertEquals(sellIn-2, backstagePasses.sellIn);
    }

    @Test
    void Backstage_Passes_Quality_drops_to_0_after_the_concert() {
        int quality = 10;
        int sellIn = 0;
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
        Item[] items = new Item[]{backstagePasses};

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, backstagePasses.quality);
        assertEquals(sellIn-1, backstagePasses.sellIn);

        app.updateQuality();

        assertEquals(0, backstagePasses.quality);
        assertEquals(sellIn-2, backstagePasses.sellIn);
    }
}