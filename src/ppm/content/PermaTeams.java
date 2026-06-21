package ppm.content;

import mindustry.game.Team;
import arc.graphics.Color;


import arc.Core;
import arc.graphics.g2d.*;
import arc.math.geom.Vec2;
import arc.struct.*;
import arc.util.*;
import mindustry.ui.Fonts;

public class PermaTeams {

    public static Team
            //TODO possibly add subfactions?
            Stalgares, Glarstes, Fluvcorea;
    // i fucking forgot what words stalgares was a combo of
    // Glarstes glacies   superstes
    // fluviales scoriae  slag riversfolk

    // Yea no shit theres a mistake in faction names, i made them the fuck up
    // Thanks IntelliJ
    // Fucking hell now its trying to correct my swearing
    public static void load(){

        //TODO add team colors (green, blue, orange/red)
        Stalgares = newTeam(97, "Stalgares", Color.valueOf("67ff00")); //neutral area team
        Glarstes = newTeam(87, "Glarstes", Color.valueOf("659edf")); //cold area team
        Fluvcorea = newTeam(83, "Fluvcorea", Color.valueOf("df8365")); //hot area team
    }

    //modify any of 256 teams' properties <-taken from FOS mod (EXCUSE ME HOW MUCH?!)
    private static Team newTeam(int id, String name, Color color) {
        Team team = Team.get(id);
        team.name = name;
        team.color.set(color);

        team.palette[0] = color;
        team.palette[1] = color.cpy().mul(0.75f);
        team.palette[2] = color.cpy().mul(0.5f);

        return team;
    }
}