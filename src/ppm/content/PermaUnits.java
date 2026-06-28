package ppm.content;

import arc.graphics.Color;
import arc.struct.ObjectSet;
import mindustry.ai.types.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.*;
import mindustry.graphics.Pal;
import mindustry.type.*;

public class PermaUnits {
    public static UnitType
        geride;/*colonist, sms, assault, heavy, scout,

    insectCrawler, insectSwarmer, insectSpit;*/

    public static void load() {

        geride = new UnitType("geride") {{
            legCount = 4;
            coreUnitDock = true;
            legSpeed = 1f;
            legBaseOffset = 2f;
            controller = u -> u.team.isAI() ? new BuilderAI(true, 400f) : new CommandAI();
            isEnemy = false;
            constructor = UnitWaterMove::create;
            groundLayer = 60f;
            shadowElevation = 0.12f;
            legLengthScl = 2f;
            legGroupSize = 2;
            legMoveSpace = 1f;
            legMinLength = 2f;
            legMaxLength = 4f;
            //legExtension = -2f;
            legStraightness = .6f;
            //legBaseOffset = 2.5f;
            legPairOffset = 2.5f;
            rippleScale = 0.01f;
            lockLegBase = true;
            legContinuousMove = true;
            legPhysicsLayer = true;
            allowLegStep = false;
            legForwardScl = 2.5f;

            health = 65f;
            armor = 1f;
            speed = 4.5f;
            drag = 1f;
            flying = false;
            canDrown = false;

            hitSize = 8f;
            physics = false;
            stepShake = 0f;
            rotateSpeed = 8f;
            immunities.add(StatusEffects.wet);
            createScorch = false;
            createWreck = false;

            mineSpeed = 8f;
            mineTier = 1;
            buildSpeed = 1f;
            itemCapacity = 70;



            weapons.add(new Weapon("heal-turret"){{
                top = false;
                reload = 60f;
                x = 0f;
                y = 4f;

                shoot = new ShootSpread(){{
                    shots = 2;
                    shotDelay = 3f;
                    spread = 2f;
                }};

                inaccuracy = 3f;
                shootSound = Sounds.shootBeamPlasmaSmall;

                bullet = new LaserBoltBulletType(3.5f, 11){{
                    scaleKeepVelocity = true;
                    collidesTeam = true;
                    healPercent = 5.5f;
                    width = 1.5f;
                    height = 5f;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    trailWidth = 1.2f;
                    trailLength = 4;
                    shootEffect = Fx.shootSmallColor;
                    smokeEffect = Fx.hitLaserColor;
                    backColor = trailColor = Pal.heal;
                    hitColor = Pal.heal;
                    frontColor = Color.white;
                    lightColor = Pal.heal;

                    lifetime = 70f;
                    homingPower = 0.5f;
                    homingDelay = 2f;
                }};
            }});
        }};

        }};
        /*colonist = new UnitType("colonist") {{
            aiController = BuilderAI::new;
            constructor = MechUnit::create;
            isEnemy = false;

            mechSideSway = 0f;
            mechStepParticles = true;
            legSpeed = .5f;

            health = 100f;
            armor = 2f;
            hitSize = 2f;
            flying = false;
            itemCapacity = 20;
            drag = 1.25f;

            speed = 1.75f;
            canBoost = true;
            boostMultiplier = .75f; // Fly speed over obstacle/far from camera

            buildSpeed = .25f;
            buildRange = 150f;

            canAttack = true;
            mineSpeed = 2f;
            mineTier = 0;
            mineFloor = true;
            mineWalls = true;

            coreUnitDock = true;
            createScorch = false;
        }};
        sms = new UnitType("sms") {{
            aiController = BuilderAI::new;
            constructor = MechUnit::create;
            isEnemy = false;

            mechSideSway = 0f;
            mechStepParticles = true;
            legSpeed = .5f;

            health = 300f;
            speed = 1.75f;
            flying = false;
            hitSize = 2.5f;
            itemCapacity = 40;
            drag = 1.25f;

            canBoost = true;
            boostMultiplier = .75f; // Fly speed over obstacle/far from camera

            buildSpeed = .75f;
            buildRange = 100f;

            canAttack = true;
            mineSpeed = 2f;
            mineTier = 0;
            mineFloor = true;
            mineWalls = true;

            coreUnitDock = true;
            createScorch = false;

            weapons.add(new Weapon("aeyama-taser") {{
                top = false;
                x = 5f;
                y = 3f;
                shootY = 2f;
                reload = 36f;
                recoil = 2f;
                shootSound = Sounds.spark;
                shake = 0.1f;
                alternate = false;
                mirror = false;
                shoot.shots = 3;
                shoot.shotDelay = 0.5f;
                bullet = new LightningBulletType(){{
                    lightningLength = 4;
                    damage = 6f;
                    speed = 0f;
                    collidesTeam = true;
                    healPercent = 2f;
                    lifetime = Fx.lightning.lifetime;
                    hitEffect = Fx.hitLancer;
                    despawnEffect = Fx.none;
                    status = StatusEffects.shocked;
                    statusDuration = 10f;
                    hittable = false;
                    lightColor = Color.white;
                    buildingDamageMultiplier = 0.25f;
                    lightningColor = hitColor =Color.valueOf("#5b6ee1");
                }};
            }});
        }};
        assault = new UnitType("assault") {{
            aiController = BuilderAI::new;
            constructor = MechUnit::create;
            isEnemy = false;

            mechSideSway = 0f;
            mechStepParticles = true;
            legSpeed = .5f;

            health = 300f;
            speed = 1.5f;
            drag = 1.25f;
            flying = false;
            omniMovement = true;
            hitSize = 2f;
            itemCapacity = 10;

            buildSpeed = .25f;
            buildRange = 100f;

            canBoost = true;
            boostMultiplier = .3f;

            canAttack = true;
            mineSpeed = 2f;
            mineTier = 0;
            mineFloor = true;
            mineWalls = true;

            coreUnitDock = true;
            createScorch = false;

            weapons.add(AeyamaWeapons.rifle);
        }};
        heavy = new UnitType("heavy") {{
            aiController = BuilderAI::new;
            constructor = MechUnit::create;
            isEnemy = false;

            mechSideSway = 0f;
            mechStepParticles = true;
            legSpeed = .5f;

            health = 300f;
            speed = 1.5f;
            drag = 1.25f;
            flying = false;
            omniMovement = true;
            hitSize = 2f;
            itemCapacity = 10;

            buildSpeed = .25f;
            buildRange = 100f;

            canBoost = true;
            boostMultiplier = .3f;

            canAttack = true;
            mineSpeed = 2f;
            mineTier = 0;
            mineFloor = true;
            mineWalls = true;

            coreUnitDock = true;
            createScorch = false;

            weapons.add(AeyamaWeapons.rifle);
        }};
        scout = new UnitType("scout") {{
            aiController = BuilderAI::new;
            constructor = MechUnit::create;
            isEnemy = false;

            mechSideSway = 0f;
            mechStepParticles = true;
            legSpeed = .5f;

            health = 300f;
            speed = 1.5f;
            drag = 1.25f;
            flying = false;
            omniMovement = true;
            hitSize = 2f;
            itemCapacity = 10;

            buildSpeed = .25f;
            buildRange = 100f;

            canBoost = true;
            boostMultiplier = .3f;

            canAttack = true;
            mineSpeed = 2f;
            mineTier = 0;
            mineFloor = true;
            mineWalls = true;

            coreUnitDock = true;
            createScorch = false;

            weapons.add(AeyamaWeapons.rifle);
        }};

        insectCrawler = new UnitType("insect-crawler") {{
            aiController = GroundAI::new;
            constructor = LegsUnit::create;
            isEnemy = true;
            groundLayer = 60f;

            legSpeed = .5f;
            legCount = 6;
            legLengthScl = 2f;
            legGroupSize = 3;
            legMoveSpace = 1f;
            legMinLength = .3f;
            legMaxLength = .6f;
            // legExtension = -2f;
            legStraightness = .2f;
            legBaseOffset = 2.5f;
            legPairOffset = 2.5f;
            rippleScale = .15f;
            lockLegBase = true;
            legContinuousMove = true;
            legPhysicsLayer = false;
            allowLegStep = false;

            health = 65f;
            armor = 1f;
            speed = .75f;
            drag = 1f;
            flying = false;
            hitSize = 8f;
            physics = true;
            stepShake = 0f;
            rotateSpeed = 8f;

            createScorch = false;
            createWreck = false;

            canAttack = true;

            weapons.add(new Weapon("aeyama-insect-claw") {{
                top = false;
                reload = 25f;
                recoil = -1f;
                x = -0.8f;
                y = 3.25f;
                shootY = 4f;
                shake = .35f;
                alternate = false;
                mirror = true;
                shootSound = Sounds.none;
                bullet = new BasicBulletType() {{
                    damage = 8f;
                    speed = 30f;
                    lifetime = 1f;
                    frontColor = Color.valueOf("#ffffff00");
                    backColor = Color.valueOf("#98ffa900");
                }};
            }});
        }};
        insectSwarmer = new UnitType("insect-swarmer") {{
            aiController = GroundAI::new;
            constructor = LegsUnit::create;
            isEnemy = true;
            groundLayer = 60f;

            legSpeed = .5f;
            legCount = 6;
            legLengthScl = 2f;
            legGroupSize = 3;
            legMoveSpace = .5f;
            legMinLength = .1f;
            legMaxLength = .4f;
            legExtension = 1f;
            legStraightness = .5f;
            legBaseOffset = 1f;
            legPairOffset = .5f;
            rippleScale = .15f;
            lockLegBase = true;
            legContinuousMove = true;
            legPhysicsLayer = false;
            allowLegStep = false;

            health = 16f;
            armor = 0f;
            speed = 0.75f;
            drag = .5f;
            flying = false;
            hitSize = 4f;
            physics = true;
            stepShake = 0f;
            rotateSpeed = 8f;

            createScorch = false;
            createWreck = false;

            canAttack = true;

            weapons.add(new Weapon("aeyama-insect-claw") {{
                top = false;
                reload = 5f;
                recoil = -1f;
                x = -.8f;
                y = 2f;
                shootY = 3f;
                shake = .25f;
                alternate = false;
                mirror = true;
                shootSound = Sounds.none;
                bullet = new BasicBulletType() {{
                    damage = 2f;
                    speed = 20f;
                    lifetime = 1f;
                    frontColor = Color.valueOf("#ffffff00");
                    backColor = Color.valueOf("#98ffa900");
                }};
            }});
        }};
        insectSpit = new UnitType("insect-spit") {{
            aiController = GroundAI::new;
            constructor = LegsUnit::create;
            isEnemy = true;
            groundLayer = 60f;

            legSpeed = 0.7f;
            legCount = 6;
            legLengthScl = 3f;
            legGroupSize = 3;
            legMoveSpace = 0.6f;
            legMinLength = 0.2f;
            legMaxLength = 0.5f;
            legExtension = 1f;
            legStraightness = 0.5f;
            legBaseOffset = 1f;
            legPairOffset = 0.6f;
            rippleScale = 0.15f;
            lockLegBase = true;
            legContinuousMove = true;
            legPhysicsLayer = false;
            allowLegStep = false;

            health = 36f;
            armor = 2f;
            speed = 0.7f;
            drag = 0.5f;
            flying = false;
            hitSize = 10f;
            physics = true;
            stepShake = 0.1f;
            rotateSpeed = 8f;

            createScorch = false;
            createWreck = false;

            canAttack = true;
            weapons.add(AeyamaWeapons.insectSpit);*/
        //};
//}
