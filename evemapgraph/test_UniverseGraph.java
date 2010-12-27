package evemapgraph;

import java.util.HashMap;
import java.util.ArrayList;
import java.sql.*;

import evemapgraph.*;

public class test_UniverseGraph {
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
        UniverseGraph map = new UniverseGraph(systems.values(), jumps);
    }
}
