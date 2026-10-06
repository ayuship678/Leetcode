class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        // okay I have the start and the end
        // I need from the start to move to each string with 1 different charatcer
        // i will make BFS until I find this endGene
        // so I have graph I will create graph with startGene and iterate over bank
        // arrya
        // add to startgene list of strings with 1 char different
        // then those charatters I will do same

        HashMap<String, List<String>> graph = new HashMap<>();
        graph.put(startGene, new ArrayList<>());
        for (var gene : bank) {
            int diffCh = 0;
            for (int i = 0; i < 8; i++) {
                if (startGene.charAt(i) != gene.charAt(i))
                    diffCh++;
            }
            if (diffCh == 1)
                graph.get(startGene).add(gene);

            graph.putIfAbsent(gene, new ArrayList<>());
            for (var gene2 : bank) {
                if (gene2.equals(gene))
                    continue;
                int diffCh2 = 0;
                for (int i = 0; i < 8; i++) {
                    if (gene.charAt(i) != gene2.charAt(i))
                        diffCh2++;
                }

                if (diffCh2 == 1)
                    graph.get(gene).add(gene2);
            }
        }

        // now make BFS untill you find endGene

        return bfs(graph, startGene, endGene);

    }

    private int bfs(HashMap<String, List<String>> graph, String startGene, String endGene) {

        Queue<String> queue = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        queue.add(startGene);
        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++){
                String currgene = queue.remove();
                
                if(visited.contains(currgene))
                    continue;
                
                visited.add(currgene);

                for(var gene: graph.get(currgene)){
                    if(gene.equals(endGene))
                        return level;
                    queue.add(gene);
                }
                    
            }

        }

        return -1;
    }
}