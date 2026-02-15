class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char c : s.toCharArray()) hash.put(c, hash.getOrDefault(c,0)+1);

        for (char now : t.toCharArray()) {
            if (!hash.containsKey(now)) return false;

            hash.put(now, hash.get(now)-1);
            hash.remove(now,0);
        }

        if (!hash.isEmpty()) return false;

        return true;
    }
}