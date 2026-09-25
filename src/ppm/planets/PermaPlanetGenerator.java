package ppm.planets;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Vec3;
import arc.struct.ObjectIntMap;
import arc.struct.ObjectSet;
import arc.struct.Seq;
import arc.util.noise.Ridged;
import arc.util.noise.Simplex;
import mindustry.content.Blocks;
import mindustry.ctype.UnlockableContent;
import mindustry.graphics.Voronoi;
import mindustry.maps.generators.PlanetGenerator;
import mindustry.type.Liquid;
import mindustry.type.Sector;
import mindustry.world.Block;
import mindustry.world.Tile;

import static mindustry.Vars.world;

//this code is taken from Aquarion mod and changed, i would've never made this myself, im kinda ass
//total hours wasted on trying to make this work: 5
public class PermaPlanetGenerator extends PlanetGenerator {
    Color Hliq1 = Color.valueOf("#aa5533"), Hliq2 = Color.valueOf("#884030"),
    Hland1 = Color.valueOf("#553f2f"), Hland2 = Color.valueOf("#442e1e"),
    Hridg1 = Color.valueOf("#333340"), Hridg2 = Color.valueOf("#22222a"),

    Nliq1 = Color.valueOf("#1f3588"), Nliq2 = Color.valueOf("#1f3566"),
    Nland1 = Color.valueOf("#aa9966"), Nland2 = Color.valueOf("#887744"),

    Cice1 = Color.valueOf("#77aaff"), Cice2 = Color.valueOf("#adddfd"),
    Cridg1 = Color.valueOf("#22222a"), Cridg2 = Color.valueOf("#aaaaaa");

    public PermaPlanetGenerator() {
        baseSeed = 2137;
    }

    public Color makeColor(Vec3 position) {
        float lat = position.y;
        float base = Simplex.noise3d(seed, 6, 0.7f, 0.8f, position.x, position.y, position.z);
        float t = Mathf.clamp(Mathf.round(base, 0.15f));
        float islandNoise = Ridged.noise3d(baseSeed+777, position.x*20f, position.y*20f, position.z*20f, 2, 2.5f);

        Color liquidColorHot = Hliq1.lerp(Hliq2, t);
        Color landColorHot = Hland1.lerp(Hland2, t);
        Color ridgeColorHot = Hridg1.lerp(Hridg2, t);

        if(lat>hotThresh){
            if(lat>(hotThresh*3.95f)){
                return landColorHot;
            }
            if(lat>(ridgeThreshHot)){
                return ridgeColorHot;
            }
            if(lat>oceanThresHot+base*0.1f){
                return landColorHot;
            }
            return liquidColorHot;
        }


        Color liquidColor = Nliq1.lerp(Nliq2, t);
        Color landColor = Nland1.lerp(Nland2, t);
        if(lat>coldThresh&&lat<hotThresh){
            if(islandNoise>0.5f){
                return landColor;
            }
            return liquidColor;
        }


        Color iceColor = Cice1.lerp(Cice2, t);
        Color ridgeColorCold = Cridg1.lerp(Cridg2, t);
        if(lat<coldThresh){
            if(lat + base * 0.5f < capThreshCold){
                return iceColor;
            }
            if(lat < ridgeThreshCold){
                return ridgeColorCold;
            }
            if(lat < -0.3f){
                float spike = Simplex.noise3d(seed + 2, 8, 0.55f, 1.4f, position.x, position.y, position.z);
                if(spike < spikeThresh){
                    return ridgeColorCold;
                }
                return iceColor;
            }

            float berg = Simplex.noise3d(seed + 1, 5, 0.6f, 1.3f, position.x, position.y, position.z);
            if(berg < bergThresh){
                return iceColor;
            }
            if(lat>bergThresh){
                return liquidColor;
            }
        }
        return Color.white;
    }

    float capThreshHot = 1.13f;
    float ridgeThreshHot = 0.72f;
    float oceanThresHot = 0.40f;

    float hotThresh = 0.25f;
    float coldThresh = -0.25f;

    float capThreshCold = -1f;
    float ridgeThreshCold = -0.6f;
    float spikeThresh = -0.8f;
    float bergThresh = -0.45f;

    float rawHeight(Vec3 pos){
        float lat = pos.y;
        float base = Simplex.noise3d(seed, 6, 0.7f, 0.8f, pos.x, pos.y, pos.z);
        float cliffs = Ridged.noise3d(baseSeed, pos.x, pos.y, pos.z, 5, 2f);

        //Hot Area(top)
        if(lat>hotThresh){
            if(lat>(hotThresh*3.95f)){
                return 0.23f + Simplex.noise3d(seed, 6, 0.5f, 0.86f, pos.x, pos.y, pos.z) * 0.33f;
            }
            if(lat>(ridgeThreshHot)){
                float fact = (lat - ridgeThreshHot) / ((capThreshHot - 0.2f) - ridgeThreshHot);
                return (cliffs * fact > 0.05f) ? cliffs * 0.47f : cliffs * -0.1f;
            }
            if(lat>oceanThresHot+base*0.1f){
                return Simplex.noise3d(seed, 5, 0.8f, 0.86f, pos.x, pos.y, pos.z)*-0.1f;
            }

                return Simplex.noise3d(baseSeed, 5, 0.8f, 0.86f, pos.x, pos.y, pos.z)*-0.3f;

        }

        //Temperate area(middle)(Holy shit is that a project moon reference njdajdaohbudijDPIOQKJBCVHSDVHSIJHAHansjfsjfhjjsdsuj)
        else if(lat>coldThresh&&lat<hotThresh){
            return -(Simplex.noise3d(baseSeed,6, 0.7f, 1.2f, pos.x, pos.y, pos.z)*0.5f);
        }

        else if(lat<coldThresh){
            if(lat + base * 0.5f < capThreshCold){
                return 0.23f + Simplex.noise3d(seed, 5, 0.7f, 0.86f, pos.x, pos.y, pos.z) * 0.7f;
            }
            if(lat < ridgeThreshCold){
                float fact = (lat - ridgeThreshCold) / ((capThreshCold - 0.2f) - ridgeThreshCold);
                return (cliffs * fact > 0.05f) ? cliffs * 0.37f : 0f;
             }
            if(lat < -0.3f){
                float spike = Simplex.noise3d(seed + 2, 8, 0.55f, 1.4f, pos.x, pos.y, pos.z);
                if(spike < spikeThresh){
                    float fact = Mathf.clamp((lat - 0.4f) / (ridgeThreshCold - 0.4f));
                    return (spike - spikeThresh) / (1f - spikeThresh) * 0.5f * fact;
                }
            }

            float berg = Simplex.noise3d(seed + 1, 5, 0.6f, 1.3f, pos.x, pos.y, pos.z);
            if(berg < bergThresh){
                return Mathf.pow((berg - bergThresh) / (1f - bergThresh), 0.5f) * 0.5f;
            }
            if(lat>bergThresh){
                return -(Simplex.noise3d(baseSeed,6, 0.7f, 1.2f, pos.x, pos.y, pos.z)*0.4f);
            }
        }

//        // pole caps
//        if(poles + base * 0.5f > capThresh){
//            return 0.23f + Simplex.noise3d(seed, 5, 0.7f, 0.86f, pos.x, pos.y, pos.z) * 0.7f;
//        }
//        // ridges near pole (bumpy mountains)
//        if(poles > ridgeThresh){
//            float fact = (poles - ridgeThresh) / ((capThresh - 0.2f) - ridgeThresh);
//            return (cliffs * fact > 0.05f) ? cliffs * 0.37f : 0f;
//        }
//        // Ice spikes near the pole caps
//        if(poles > 0.3f){
//            float spike = Simplex.noise3d(seed + 2, 8, 0.55f, 1.4f, pos.x, pos.y, pos.z);
//            if(spike > spikeThresh){
//                float fact = Mathf.clamp((poles - 0.4f) / (ridgeThresh - 0.4f));
//                return (spike - spikeThresh) / (1f - spikeThresh) * 0.3f * fact;
//            }
//        }
//        // bergurs
//        float berg = Simplex.noise3d(seed + 1, 5, 0.6f, 1.3f, pos.x, pos.y, pos.z);
//        if(berg > bergThresh){
//            return Mathf.pow((berg - bergThresh) / (1f - bergThresh), 0.5f) * 0.5f;
//        }

        return 0f;
    }


    @Override
    public float getHeight(Vec3 position){
        return rawHeight(position);
    }
//
    @Override
    public void getColor(Vec3 position, Color out) {
        out.set(makeColor(position));
    }
//    @Override
//    public void addWeather(Sector sector, Rules rules){

//        //apply weather based on terrain
//        ObjectIntMap<Block> floorc = new ObjectIntMap<>();
//        ObjectSet<UnlockableContent> content = new ObjectSet<>();
//
//        for(Tile tile : world.tiles){
//            if(world.getDarkness(tile.x, tile.y) >= 3){
//                continue;
//            }
//
//            Liquid liquid = tile.floor().liquidDrop;
//            if(tile.floor().itemDrop != null) content.add(tile.floor().itemDrop);
//            if(tile.overlay().itemDrop != null) content.add(tile.overlay().itemDrop);
//            if(liquid != null) content.add(liquid);
//
//            if(!tile.block().isStatic()){
//                floorc.increment(tile.floor());
//                if(tile.overlay() != Blocks.air){
//                    floorc.increment(tile.overlay());
//                }
//            }
//        }

}
