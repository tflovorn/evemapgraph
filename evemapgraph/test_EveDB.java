package evemapgraph;

import java.util.HashMap;
import java.util.ArrayList;
import java.sql.*;

import evemapgraph.*;

public class test_EveDB {
    public static void main(String[] args) {
        HashMap<Integer, SolarSystem> systems;
        ArrayList<SolarSystemJump> jumps;
        try {
            EveDB db = new EveDB();
            systems = db.getSolarSystems();
            jumps = db.getSolarSystemJumps();
        } catch (SQLException e) {
            System.out.println(e.toString());
            return;
        }
        System.out.println(systems.get(30000001).solarsystemname);
        System.out.println(jumps.get(0).fromsolarsystemid + " ---> " +
                           jumps.get(0).tosolarsystemid);
    }
}
