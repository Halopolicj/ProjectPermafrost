package ppm;

import arc.util.*;
import ppm.content.*;
import mindustry.mod.*;

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
        PermaAttributes.load();
        PermaLiquids.load();
        PermaItems.load();
        PermaBlocks.load();
        PermaSectors.load();
        PermaPlanets.load();
        PermaTech.load();
        PermaTeams.load();


    }

}