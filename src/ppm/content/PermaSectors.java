package ppm.content;


import mindustry.type.SectorPreset;

import static ppm.content.PermaPlanets.Gleo;

public class PermaSectors {
    public static SectorPreset one ;

    public static void load() {
        one = new SectorPreset("one", PermaPlanets.Gleo , 15)
        {{
            alwaysUnlocked = true;
            addStartingItems = true;
            captureWave = 10;
            difficulty = 0;
            overrideLaunchDefaults = true;
            noLighting = true;
            startWaveTimeMultiplier = 3f;


        }};
    }
}
