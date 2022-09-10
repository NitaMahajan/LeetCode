class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();  // Recipes and supplies are nodes in the graph. The ingredients list gives us the edges.
        Map<String, Integer> inDegree = new HashMap<>();  
        Set<String> recipesSet = new HashSet<>();   // Needed so that later, while processing nodes during the topological sort,  we only add recipes to the result.
        // Add supply nodes to the graph.
        for (String currSupply : supplies) {
            graph.put(currSupply, new ArrayList<>());
            inDegree.put(currSupply, 0);
        }
        // Add recipe nodes to the graph.
        for (String currRecipe : recipes) {
            graph.put(currRecipe, new ArrayList<>());
            inDegree.put(currRecipe, 0);

            recipesSet.add(currRecipe);
        }
        // Add edges to the graph.
        for (int i = 0; i < ingredients.size(); ++i) {
            for (String currIngredient : ingredients.get(i)) {
                graph.putIfAbsent(currIngredient, new ArrayList<>());   
                graph.get(currIngredient).add(recipes[i]); 
                inDegree.put(recipes[i], inDegree.get(recipes[i]) + 1);   
            }
        }
        // Standard topological sort
        List<String> result = new ArrayList<>();
        Deque<String> queue = new ArrayDeque<>();
        for (String currNode : inDegree.keySet()) {
            if (inDegree.get(currNode) == 0) queue.addLast(currNode);
        }
        while (queue.size() > 0) {
            String currNode = queue.removeFirst();
            if (recipesSet.contains(currNode)) {
                result.add(currNode);   
            }
            for (String adjacentNode : graph.get(currNode)) {
                inDegree.put(adjacentNode, inDegree.get(adjacentNode) - 1);
                if (inDegree.get(adjacentNode) == 0) queue.addLast(adjacentNode);
            }
        }
        return result;
    }
}