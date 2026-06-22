package ppm.expand.blocks.defense;

import arc.graphics.g2d.TextureRegion;
import mindustry.entities.abilities.Ability;
import mindustry.entities.abilities.Ability.*;
import mindustry.entities.abilities.RegenAbility;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.meta.*;
import arc.Core;
import static mindustry.Vars.*;


public class RegenWall extends Wall {
    public float healPercent = 0f;
    public RegenWall(String name) {
        super(name);
        insulated = true;
        absorbLasers = true;
        crushDamageMultiplier = 1f;
        clipSize = tilesize * 2 + 2;


    }

    @Override
    public void setStats(){
        super.setStats();

        stats.add(Stat.repairTime, (int)(1f / ((12f/60f) / 100f) / 60f), StatUnit.seconds);
    }
}
