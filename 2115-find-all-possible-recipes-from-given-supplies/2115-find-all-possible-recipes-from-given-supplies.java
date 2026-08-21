class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int indegree[] = new int[recipes.length];
        HashMap<String, Integer> recipeIndex = new HashMap<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < ingredients.size(); i++) {
            recipeIndex.put(recipes[i], i);
            indegree[i] = ingredients.get(i).size();
            for (int j = 0; j < ingredients.get(i).size(); j++) {
                if (!map.containsKey(ingredients.get(i).get(j))) {
                    map.put(ingredients.get(i).get(j), new ArrayList<>());
                }
                map.get(ingredients.get(i).get(j)).add(recipes[i]);
            }
        }
        Queue<String> q = new LinkedList<>();
        List<String> ans = new ArrayList<>();
        for (String supply : supplies) {
            q.add(supply);
        }
        while (!q.isEmpty()) {
            String ingredient = q.remove();
            if (!map.containsKey(ingredient)) {
                continue;
            }
            for (String recipie : map.get(ingredient)) {
                int recpInd = recipeIndex.get(recipie);
                indegree[recpInd]--;
                if (indegree[recpInd] == 0) {
                    ans.add(recipie);
                    q.add(recipie);
                }
            }
        }
        return ans;
    }
}