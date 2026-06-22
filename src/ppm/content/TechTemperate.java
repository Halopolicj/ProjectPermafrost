package ppm.content;

import arc.struct.ObjectFloatMap;
import mindustry.content.*;
import mindustry.type.*;

import static arc.struct.Seq.with;
import static mindustry.content.TechTree.*;
import static ppm.content.PermaItems.*;
import static ppm.content.PermaBlocks.*;
import static ppm.content.PermaSectors.*;

public class TechTemperate {

    static ObjectFloatMap<Item> costs = new ObjectFloatMap<>();
    public static void load() {
        costs.put(cadmium, 0.05f);
        costs.put(Items.lead, 0.06f);
        costs.put(gallium, 0.9f);
        PermaPlanets.Gleo.techTree = nodeRoot("Gleo", coreStasis, () -> {
            context().researchCostMultipliers = costs;
            //distribution
            node(cadmiumConveyor, () -> {
                node(cadmiumRouter, () -> {
                    node(cadmiumJunction, () -> {
                        node(cadmiumSorter, () -> {
                            node(cadmiumSorterInv, ()-> {

                            });
                        });
                        node(cadmiumOverflow, () -> {
                            node(cadmiumUnderflow, () -> {

                            });
                        });
                    });
                });
                node(cadmiumBridge, () -> {

                });
            });
            node(cadmiumWall, () -> {
               node(cadmiumWallBig, () -> {

               });
               node(zircWall, () -> {
                   node(zircWallBig, () -> {

                   });
               });
            });

            nodeProduce(cadmium, () -> {

                nodeProduce(Items.silicon, () -> {

                });

               nodeProduce(Items.lead, () -> {

               });

            });

            node(one, () -> {

            });
        });
    }
}