class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map=new HashMap<>();
        for(String word:strs){
            char[] chars=word.toCharArray();
            Arrays.sort(chars);
            String sw=new String(chars);
            if(!map.containsKey(sw)){
                map.put(sw, new ArrayList<>());
            }
            map.get(sw).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
