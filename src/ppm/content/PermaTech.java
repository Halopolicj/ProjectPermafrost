package ppm.content;

import arc.struct.ObjectFloatMap;
import mindustry.content.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;

import static arc.struct.Seq.with;
import static mindustry.content.TechTree.*;
import static ppm.content.PermaItems.*;
import static ppm.content.PermaBlocks.*;

public class PermaTech {

    static ObjectFloatMap<Item> costs = new ObjectFloatMap<>();
    public static void load() {
        costs.put(nickel, 0.05f);
        costs.put(Items.lead, 0.06f);
        costs.put(gallium, 0.9f);
        PermaPlanets.Gleo.techTree = nodeRoot("Gleo", coreStasis, () -> {
            context().researchCostMultipliers = costs;
            //distribution
            node(nickelConveyor, () -> {

            });
        });
    };
}