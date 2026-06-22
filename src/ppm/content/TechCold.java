package ppm.content;

import arc.struct.ObjectFloatMap;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.Item;

import ppm.content.PermaItems.*;

import static mindustry.content.TechTree.*;

public class TechCold {
    static ObjectFloatMap<Item> costs = new ObjectFloatMap<>();
    public static void load() {
        //costs.put(nickel, 0.05f);
        PermaPlanets.Gleo.techTree = nodeRoot("Gleo - Frozen", Blocks.coreShard, () -> {



            nodeProduce(PermaItems.gallium, () -> {
               nodeProduce(Liquids.gallium, () -> {

               });

               nodeProduce(Items.silicon, () -> {

               });
            });
        });
    }
}
