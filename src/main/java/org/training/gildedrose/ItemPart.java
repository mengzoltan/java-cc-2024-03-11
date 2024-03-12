package org.training.gildedrose;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ItemPart {
    private String partName;
    private List<String> partKeys;
    private BigDecimal price;

    public void addKey(String key){
        partKeys.add(key);
    }
}
