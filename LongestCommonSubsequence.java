
public class LongestCommonSubsequence {


    public static int lcs(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        for (int row = 1; row <= len1; row++) {
            for (int col = 1; col <= len2; col++) {
                char c1 = s1.charAt(row - 1);
                char c2 = s2.charAt(col - 1);
                if (Character.isDigit(c1) && Character.isDigit(c2) && c1 == c2) {
                    dp[row][col] = 1 + dp[row - 1][col - 1];
                } else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }
        
        return dp[len1][len2];
    }


    public static void main(String[] args) {
        String sequence1 = "AB13cD90azK";
        String sequence2 = "zAB173QdK80";

        int lengthOfLCS = lcs(sequence1, sequence2);
        System.out.println("The length of the Longest Common Subsequence is: " + lengthOfLCS);
    }
}