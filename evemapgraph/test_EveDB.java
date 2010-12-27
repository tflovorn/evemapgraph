package evemapgraph;

import java.util.HashMap;
import java.sql.*;

import evemapgraph.*;

public class test_EveDB {
    public static void main(String[] args) {
        try {
            EveDB db = new EveDB();
            HashMap<Integer, SolarSystem> systems = db.getSolarSystems();
            System.out.println(systems.get(30000001).solarsystemname);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
