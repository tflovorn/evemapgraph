package evemapgraph;

import java.util.ArrayList;
import java.sql.*;

import evemapgraph.SolarSystem;

public class EveDB {
    public ArrayList<SolarSystem> getSolarSystems(Connection conn) {
        ArrayList<SolarSystem> systemList = new ArrayList<SolarSystem>();
        return systemList;
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost/evedb";
        String props = "?user=postgres&password=postgrespass";
        Connection conn = DriverManager.getConnection(url + props);
        return conn;
    }
}
