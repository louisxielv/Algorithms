package edu.nyu.lx463.questions.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LyuXie on 4/15/17.
 */
public class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    public GraphNode(int key) {
        this.key = key;
        this.neighbors = new ArrayList<GraphNode>();
    }
}
