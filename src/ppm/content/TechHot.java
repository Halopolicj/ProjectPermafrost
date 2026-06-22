package ppm.content;

import arc.struct.ObjectFloatMap;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.type.Item;

import static mindustry.content.TechTree.nodeProduce;
import static mindustry.content.TechTree.nodeRoot;


import static ppm.content.PermaItems.*;

public class TechHot {
    static ObjectFloatMap<Item> costs = new ObjectFloatMap<>();
    public static void load() {
        //costs.put(nickel, 0.05f);
        PermaPlanets.Gleo.techTree = nodeRoot("Gleo - Molten", Blocks.coreBastion, () -> {



            nodeProduce(Items.lead, () -> {
                nodeProduce(Items.silicon, () -> {
                    nodeProduce(zirconium, () -> {

                    });
                });
            });
        });
    }
}
