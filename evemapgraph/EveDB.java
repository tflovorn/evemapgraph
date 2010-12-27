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

import java.util.ArrayList;
import java.sql.*;

import evemapgraph.SolarSystem;

public class EveDB {
    private Connection conn;

    public EveDB() throws SQLException {
        this.conn = getConnection();
    }

    public ArrayList<SolarSystem> getSolarSystems() throws SQLException {
        ArrayList<SolarSystem> systemList = new ArrayList<SolarSystem>();
        Statement st = this.conn.createStatement();
        String query = "SELECT * FROM mapsolarsystems";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            SolarSystem thisSystem = new SolarSystem();
            thisSystem.solarsystemname = rs.getString("solarsystemname");
            thisSystem.securityclass = rs.getString("securityclass");
            thisSystem.regionid = rs.getInt("regionid");
            thisSystem.constellationid = rs.getInt("constellationid");
            thisSystem.solarsystemid = rs.getInt("solarsystemid");
            thisSystem.border = rs.getInt("border");
            thisSystem.fringe = rs.getInt("fringe");
            thisSystem.corridor = rs.getInt("corridor");
            thisSystem.hub = rs.getInt("hub");
            thisSystem.international = rs.getInt("international");
            thisSystem.regional = rs.getInt("regional");
            thisSystem.constellation = rs.getInt("constellation");
            thisSystem.factionid = rs.getInt("factionid");
            thisSystem.suntypeid = rs.getInt("suntypeid");
            thisSystem.x = rs.getDouble("x");
            thisSystem.y = rs.getDouble("y");
            thisSystem.z = rs.getDouble("z");
            thisSystem.xMin = rs.getDouble("xMin");
            thisSystem.xMax = rs.getDouble("xMax");
            thisSystem.ymin = rs.getDouble("ymin");
            thisSystem.ymax = rs.getDouble("ymax");
            thisSystem.zmin = rs.getDouble("zmin");
            thisSystem.zmax = rs.getDouble("zmax");
            thisSystem.security = rs.getDouble("security");
            thisSystem.radius = rs.getDouble("radius");
            systemList.add(thisSystem);
        }
        rs.close();
        st.close();
        return systemList;
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost/evedb";
        String props = "?user=postgres&password=postgrespass";
        Connection conn = DriverManager.getConnection(url + props);
        return conn;
    }
}
