class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // If endWord is not in the wordList, return 0 as no transformation is possible
        if (!wordList.contains(endWord)) return 0;

        // Initialize sets for BFS
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);

        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        Set<String> wordSet = new HashSet<>(wordList); // Convert wordList to a set for faster lookup

        return bfs(beginSet, endSet, wordSet, 1); // Start BFS with distance = 1
    }

    private int bfs(Set<String> beginSet, Set<String> endSet, Set<String> wordSet, int distance) {
        // Swap sets to always process the smaller set (bi-directional BFS optimization)
        if (beginSet.size() > endSet.size()) {
            return bfs(endSet, beginSet, wordSet, distance);
        }

        // Remove all words in the current beginSet from wordSet to prevent revisiting
        wordSet.removeAll(beginSet);

        // Set to hold words reachable in the next level of BFS
        Set<String> reachableSet = new HashSet<>();

        // For each word in the current level
        for (String word : beginSet) {
            char[] charArray = word.toCharArray();

            // Try changing each character of the word
            for (int i = 0; i < charArray.length; i++) {
                char originalChar = charArray[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    charArray[i] = c; // Replace the character
                    String newWord = new String(charArray);

                    // If the new word is in the endSet, return the current distance + 1
                    if (endSet.contains(newWord)) {
                        return distance + 1;
                    }

                    // If the new word is in the wordSet, add it to reachableSet
                    if (wordSet.contains(newWord)) {
                        reachableSet.add(newWord);
                    }
                }

                // Restore the original character
                charArray[i] = originalChar;
            }
        }

        // Increment the distance
        distance++;

        // If no new words are reachable, return 0
        if (reachableSet.isEmpty()) {
            return 0;
        }

        // Recursively call BFS with the new reachable set
        return bfs(reachableSet, endSet, wordSet, distance);
    }
}
