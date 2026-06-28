package ppm.content;


import mindustry.type.Planet;
import mindustry.type.SectorPreset;

import static ppm.content.PermaPlanets.Gleo;

public class PermaSectors {
    public static SectorPreset one, crossingIslands;

    public static void load() {


        crossingIslands = new SectorPreset("crossing-IslandsV1", Gleo, 15){{
           alwaysUnlocked = true;
           requireUnlock = false;

        }};
    }
}
