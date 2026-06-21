package ppm;

import arc.*;
import arc.util.*;
import ppm.content.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class permafrostMod extends Mod{

    public permafrostMod(){
        Log.info("Loaded the fucking mod");
    }

    @Override
    public void loadContent(){
        Log.info("Loading Project Permafrost.");
        //FIXME
        // fix this as i port the mod

        // new repo, code still stolen from BetaMindy
        //OverWriter.load();
        //MindyStatusEffects.load();
        //MindyLiquids.load();
        // MindyItems.load();
        //MindyBullets.load();
        //ShopItems.load();
        //FireColor.load();
        //MindyBlocks.load();
        //MindyWeathers.load();
        //MindyPlanets.load();
        //MindySectors.load();
        //MindyTechTree.load();
        //PermaAttributes.load();//When the fuck did i make this file, also i like the word fuck
        PermaLiquids.load();
        PermaItems.load();
        PermaBlocks.load();
        PermaPlanets.load();
        //PermaSectorPresets.load();
        PermaTech.load();
        PermaTeams.load();


    }

}