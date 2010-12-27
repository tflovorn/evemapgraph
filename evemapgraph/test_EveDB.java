package evemapgraph;

import java.util.HashMap;
import java.util.ArrayList;
import java.sql.*;

import evemapgraph.*;

public class test_EveDB {
    public static void main(String[] args) {
        try {
            EveDB db = new EveDB();
            HashMap<Integer, SolarSystem> systems = db.getSolarSystems();
            ArrayList<SolarSystemJump> jumps = db.getSolarSystemJumps();
            System.out.println(systems.get(30000001).solarsystemname);
            System.out.println(jumps.get(0).fromsolarsystemid + " ---> " +
                               jumps.get(0).tosolarsystemid);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
