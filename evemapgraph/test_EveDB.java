package evemapgraph;

import java.util.ArrayList;
import java.sql.*;

import evemapgraph.*;

public class test_EveDB {
    public static void main(String[] args) {
        try {
            EveDB db = new EveDB();
            ArrayList<SolarSystem> systemList = db.getSolarSystems();
            System.out.println(systemList.get(0).solarsystemname);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
