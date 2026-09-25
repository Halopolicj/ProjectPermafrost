package ppm.content;

import arc.graphics.Color;
import arc.struct.Seq;
import arc.util.Time;
import mindustry.content.Planets;
import mindustry.game.Rules;
import mindustry.game.Team;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.graphics.g3d.SunMesh;
import mindustry.maps.generators.BlankPlanetGenerator;
import mindustry.type.Planet;
import mindustry.type.Sector;
import ppm.content.PermaSectors.*;
import static arc.graphics.Gl.one;
import ppm.planets.PermaPlanetGenerator;
public class PermaPlanets {
    public static Planet Gleo;

    public static void load() {
        Gleo = new Planet("Gleo", Planets.sun, 1, 2) {
            {
                generator = new PermaPlanetGenerator();
                meshLoader = () -> new HexMesh(this, 5);
                cloudMeshLoader = () -> new MultiMesh(
                        new HexSkyMesh(this, 2, 0.15f, 0.14f, 5, Color.valueOf("3587F2").a(0.75f), 2, 0.42f, 1f, 0.43f),
                        new HexSkyMesh(this, 3, 0.6f, 0.15f, 5, Color.valueOf("00FF9F").a(0.75f), 2, 0.42f, 1.2f, 0.45f)
                );
                landCloudColor = Color.valueOf("1365d0");
                hasAtmosphere = false;
                alwaysUnlocked = true;
                tidalLock = true;

                accessible = true;
                allowLaunchSchematics = true;
                allowLaunchLoadout = false;
                allowSectorInvasion = false;
                clearSectorOnLose = true;
                prebuildBase = true;
                enemyBuildSpeedMultiplier = 1;
                defaultCore = PermaBlocks.coreStasis;
                visible = true;

                ruleSetter = r -> {
                    r.waveTeam = PermaTeams.Glarstes;
                    r.placeRangeCheck = false;
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

                unlockedOnLand.add(PermaBlocks.coreStasis);
                startSector = 15;

            }

        };
    }
}