package ppm.content;

import arc.graphics.Color;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;

import mindustry.entities.effect.ExplosionEffect;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class PermaTurrets {
    public static Block
            //normal turrets
            hedgehog;

    public static void load() {
        hedgehog = new ItemTurret("hedgehog") {
            {
                size = 2;
                drawer = new DrawTurret("cadmium-");
                health = 700;
                range = 110f;
                reload = 50f;
                itemCapacity = 10;
                requirements(Category.turret, with(PermaItems.cadmium, 100, Items.lead, 50));

                ammo(
                    PermaItems.cadmium, new BasicBulletType(){{
                        sprite = "basic-bullet";
                        lifetime = 140f;
                        damage = 20f;
                        hitColor = PermaPallette.cadmiumYellow;
                        speed = 1f;
                        frontColor = PermaPallette.cadmiumYellow;
                        backColor = PermaPallette.fluvcoreaOrange;
                            despawnEffect = hitEffect = new ExplosionEffect(){{
                                waveColor = PermaPallette.cadmiumYellow;
                                smokeColor = Color.gray;
                                sparkColor = PermaPallette.cadmiumYellow;
                                waveStroke = 4f;
                                waveRad = 10f;
                            }};
                    }}
                );
            }
        };
    }
}
