/*273. Integer to English Words

Convert a non-negative integer num to its English words representation.

Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"
Example 2:

Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 

Constraints:

0 <= num <= 2^31 - 1 */



class Solution {

    String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return helper(num);
    }

    private String helper(int num) {
        if (num < 10) {
            return belowTen[num];
        } else if (num < 20) {
            return belowTwenty[num - 10];
        } else if (num < 100) {
            return belowHundred[num / 10] + (num % 10 == 0 ? "" : " " + helper(num % 10));
        } else if (num < 1000) {
            return belowTen[num / 100] + " Hundred" + (num % 100 == 0 ? "" : " " + helper(num % 100));
        } else if (num < 1000000) {
            return helper(num / 1000) + " Thousand" + (num % 1000 == 0 ? "" : " " + helper(num % 1000));
        } else if (num < 1000000000) {
            return helper(num / 1000000) + " Million" + (num % 1000000 == 0 ? "" : " " + helper(num % 1000000));
        } else {
            return helper(num / 1000000000) + " Billion" + (num % 1000000000 == 0 ? "" : " " + helper(num % 1000000000));
        }
    }
}