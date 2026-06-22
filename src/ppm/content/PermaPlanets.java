package ppm.content;

import arc.graphics.Color;
import arc.util.Time;
import mindustry.content.Planets;
import mindustry.game.Rules;
import mindustry.game.Team;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.graphics.g3d.SunMesh;
import mindustry.type.Planet;

public class PermaPlanets {
    public static Planet Gleo;

    public static void load() {
        Gleo = new Planet("Gleo", Planets.sun, 1, 2) {
            {
                //p sure most of this is stolen
                meshLoader = () -> new SunMesh(
                        this, 4,
                        5, 0.3, 1.7, 1.2, 1,
                        1.1f,
                        Color.valueOf("3587F2"),
                        Color.valueOf("00FF9F"),
                        Color.valueOf("C165F7"),
                        Color.valueOf("6F3C8D"),
                        Color.valueOf("BE47E5"),
                        Color.valueOf("6E2B84")
                );
                cloudMeshLoader = () -> new MultiMesh(
                        new HexSkyMesh(this, 2, 0.15f, 0.14f, 5, Color.valueOf("3587F2").a(0.75f), 2, 0.42f, 1f, 0.43f),
                        new HexSkyMesh(this, 3, 0.6f, 0.15f, 5, Color.valueOf("00FF9F").a(0.75f), 2, 0.42f, 1.2f, 0.45f)
                );
                landCloudColor = Color.valueOf("3587F2");
                atmosphereColor = Color.valueOf("00FF9F");
                alwaysUnlocked = true;
                tidalLock = true;
                atmosphereRadIn = 0.02f;
                atmosphereRadOut = 0.3f;
                accessible = true;
                allowLaunchToNumbered = false;
                allowLaunchSchematics = true;
                allowLaunchLoadout = false;
                allowSectorInvasion = false;
                clearSectorOnLose = true;
                prebuildBase = true;
                enemyBuildSpeedMultiplier = 1;
                defaultCore = PermaBlocks.coreStasis;



                ruleSetter = r -> {
                    r.waveTeam = PermaTeams.Glarstes;
                    r.placeRangeCheck = false;
                    r.showSpawns = true;
                    r.waveSpacing = 80 * Time.toSeconds;
                    r.initialWaveSpacing = 8f * Time.toMinutes;
                    r.coreDestroyClear = true;
                    r.dropZoneRadius = 64;


                    r.waves = true;
                    r.onlyDepositCore = true;
                    r.fog = false;

                    r.defaultTeam = Team.sharded;
                    Rules.TeamRule teamRule = r.teams.get(r.defaultTeam);
                    teamRule.rtsAi = true;
                };


                startSector = 15;
            }
        };
    }
}