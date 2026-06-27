package ppm.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class PermaItems {

    //Load Mod Items

    public static Item
            cadmium, gallium, neodymium, zirconium, bismuth;

    public static void load() {
        cadmium = new Item("cadmium") {{
            cost = 1f;
            color = Color.valueOf("cbbd8a");
            hardness=1;
        }};
        gallium = new Item("gallium") {{
            cost = 1.8f;
            color = Color.gray;
            hardness = 3;
        }};
        bismuth = new Item("bismuth") {{
            cost = 2f;
            hardness = 2;
            charge = 1f;
            //how the hell do i make the color rainbow
            color = Color.coral;//I got no idea how the coral color looks
        }};
        neodymium = new Item("neodymium") {{
            cost = 2.65f;
            color = Color.valueOf("c26cbc");
        }};
        zirconium = new Item("zirconium") {{
            cost =  3f;
            charge = 0.7f;
            //TODO add cool color probably blue-ish
        }};
    }
}