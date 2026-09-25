package ppm.content;


import mindustry.type.Planet;
import mindustry.type.SectorPreset;

import static ppm.content.PermaPlanets.Gleo;

public class PermaSectors {
    public static SectorPreset  crossingIslands, one;

    public static void load() {

        crossingIslands = new SectorPreset("crossing-islands-v2", Gleo, 15){{
            alwaysUnlocked = true;
            overrideLaunchDefaults = true;
            showHidden = true;

        }};

        one = new SectorPreset("one", Gleo, 0){{
            alwaysUnlocked = true;
            overrideLaunchDefaults = true;
            showHidden = true;

        }};
    }
}
