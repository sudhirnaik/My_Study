package practice.Graph;

import java.util.*;

public class GraphPorb {
    public static void main(String[] args) {
        //Adjacency List
        Map<String, List<String>> myMap = new HashMap<>();
        myMap.put("a", Arrays.asList("b", "c"));
        myMap.put("b", Arrays.asList("d"));
        myMap.put("c", Arrays.asList("e"));
        myMap.put("d", Arrays.asList("f"));
        myMap.put("e", Arrays.asList());
        myMap.put("f", Arrays.asList());
        Graph graph = new Graph(myMap);
        //depthFirstPrint(myMap, "a");
        //depthFirstPrintUsingRegression(myMap, "a");
        bredthFirstPrint(myMap,"a");


    }

    public static void depthFirstPrint(Map graph, String src) {
       //System.out.println(src);
        Stack<String> stack = new Stack<String>();
        stack.add(src);
        while(!stack.isEmpty()) {
            String current = stack.pop();
            System.out.println(current);
            List<String> neighboirs = (List<String>) graph.get(current);
            for (String v: neighboirs) {
                stack.add(v);
            }
        }
    }

    public static void bredthFirstPrint(Map graph, String src) {
        Queue<String> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()) {
            String current = q.poll();
            System.out.println(current);
            for (String str : (List<String>)graph.get(current)){
                q.add(str);
            }
        }
    }

    public static void depthFirstPrintUsingRegression(Map graph, String src) {
        System.out.println(src);
        for (String str: (List<String>)graph.get(src)){
            depthFirstPrint(graph, str);
        }
    }
}
