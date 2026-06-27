package ppm.content;


import mindustry.type.Planet;
import mindustry.type.SectorPreset;

import static ppm.content.PermaPlanets.Gleo;

public class PermaSectors {
    public static SectorPreset one, crossingIslands;

    public static void load() {
        one = new SectorPreset("one", PermaPlanets.Gleo , 21)
        {{
            alwaysUnlocked = true;
            addStartingItems = true;
            captureWave = 10;
            difficulty = 1;
            noLighting = true;
            startWaveTimeMultiplier = 3f;
            requireUnlock = false;

        }};

        crossingIslands = new SectorPreset("crossing-IslandsV1", Gleo, 15){{
           alwaysUnlocked = true;
           requireUnlock = false;

        }};
    }
}
