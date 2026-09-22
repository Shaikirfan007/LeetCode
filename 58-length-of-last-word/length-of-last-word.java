class Solution {
    public int lengthOfLastWord(String s) {
        // Trim leading and trailing spaces
        s = s.trim();
        
        // Find the last space character
        int lastSpaceIndex = s.lastIndexOf(' ');
        
        // Length of last word = total length - last space index - 1
        return s.length() - lastSpaceIndex - 1;
    }
}
