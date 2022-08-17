class Solution {

    public int uniqueMorseRepresentations(String[] words) {
        String[] encodings = {
            ".-",
            "-...",
            "-.-.",
            "-..",
            ".",
            "..-.",
            "--.",
            "....",
            "..",
            ".---",
            "-.-",
            ".-..",
            "--",
            "-.",
            "---",
            ".--.",
            "--.-",
            ".-.",
            "...",
            "-",
            "..-",
            "...-",
            ".--",
            "-..-",
            "-.--",
            "--.."
        };

        Set<String> set = new HashSet<>();
        for (String w : words) {
            String e = "";
            for (char c : w.toCharArray()) {
                e += encodings[c - 97];
            }
            set.add(e);
        }
        return set.size();
    }
}
