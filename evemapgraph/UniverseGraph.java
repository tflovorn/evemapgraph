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

import java.util.Collection;
import java.util.HashMap;

import com.tinkerpop.blueprints.pgm.*;
import com.tinkerpop.blueprints.pgm.impls.tg.*;

import evemapgraph.SolarSystem;
import evemapgraph.SolarSystemJump;

class UniverseGraph {
    private HashMap<Integer, Vertex> vertexMap;
    private Graph universe;

    public UniverseGraph(Collection<SolarSystem> systems,
                         Collection<SolarSystemJump> jumps) {
        this.vertexMap = new HashMap<Integer, Vertex>();
        Graph universe = new TinkerGraph();
        for (SolarSystem system : systems) {
            Vertex systemVertex = universe.addVertex(system);
            vertexMap.put(system.solarsystemid, systemVertex);
        }
        for (SolarSystemJump jump : jumps) {
            Vertex fromVertex = vertexMap.get(jump.fromsolarsystemid);
            Vertex toVertex = vertexMap.get(jump.tosolarsystemid);
            Edge jumpEdge = universe.addEdge(null, fromVertex, toVertex, 
                "jump");
        }
        this.universe = universe;
    }
}
