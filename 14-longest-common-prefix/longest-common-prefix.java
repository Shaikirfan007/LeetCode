class Solution {    
    public String longestCommonPrefix(String[] str) {
        //your code goes here
        String prefix=str[0];
        for (int i=1;i<str.length;i++){
            int j =0;
            while(j<prefix.length() && j<str[i].length()&& prefix.charAt(j)==str[i].charAt(j)){
                j++;
            }
            prefix = prefix.substring(0, j);

            if (prefix.length() == 0) {
                return "";
            }
        }
        return prefix;
    }
}