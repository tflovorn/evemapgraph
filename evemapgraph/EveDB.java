/*
  Copyright (c) 2010 Timothy Lovorn

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package evemapgraph;

import java.util.HashMap;
import java.sql.*;

import evemapgraph.SolarSystem;

public class EveDB {
    private Connection conn;

    public EveDB() throws SQLException {
        this.conn = getConnection();
    }

    public HashMap<Integer, SolarSystem> getSolarSystems() throws SQLException {
        HashMap<Integer, SolarSystem> systems =
            new HashMap<Integer, SolarSystem>();
        Statement st = this.conn.createStatement();
        String query = "SELECT * FROM mapsolarsystems";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            SolarSystem ss = new SolarSystem();
            ss.solarsystemname = rs.getString("solarsystemname");
            ss.securityclass = rs.getString("securityclass");
            ss.regionid = rs.getInt("regionid");
            ss.constellationid = rs.getInt("constellationid");
            ss.solarsystemid = rs.getInt("solarsystemid");
            ss.border = rs.getInt("border");
            ss.fringe = rs.getInt("fringe");
            ss.corridor = rs.getInt("corridor");
            ss.hub = rs.getInt("hub");
            ss.international = rs.getInt("international");
            ss.regional = rs.getInt("regional");
            ss.constellation = rs.getInt("constellation");
            ss.factionid = rs.getInt("factionid");
            ss.suntypeid = rs.getInt("suntypeid");
            ss.x = rs.getDouble("x");
            ss.y = rs.getDouble("y");
            ss.z = rs.getDouble("z");
            ss.xMin = rs.getDouble("xMin");
            ss.xMax = rs.getDouble("xMax");
            ss.ymin = rs.getDouble("ymin");
            ss.ymax = rs.getDouble("ymax");
            ss.zmin = rs.getDouble("zmin");
            ss.zmax = rs.getDouble("zmax");
            ss.security = rs.getDouble("security");
            ss.radius = rs.getDouble("radius");
            systems.put(ss.solarsystemid, ss);
        }
        rs.close();
        st.close();
        return systems;
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost/evedb";
        String props = "?user=postgres&password=postgrespass";
        Connection conn = DriverManager.getConnection(url + props);
        return conn;
    }
}
