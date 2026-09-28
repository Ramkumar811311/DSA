class Solution {
    public static void ZigZag(String s, ArrayList<Character>[] arr, int numRows) {
        int s_ind = 0;
        while (s_ind < s.length()) {
            for (int j = 0; j < numRows; j++) {

                if (s_ind >= s.length())
                    return;

                arr[j].add(s.charAt(s_ind));

                s_ind++;
            }
            for (int j = numRows - 2; j > 0; j--) {

                if (s_ind >= s.length())
                    return;
                arr[j].add(s.charAt(s_ind));
                s_ind++;
            }

        }
    }

    public String convert(String s, int numRows) {
         if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        ArrayList<Character>[] arr = new ArrayList[numRows];

        for (int i = 0; i < numRows; i++) {
            arr[i] = new ArrayList<>();
        }
        ZigZag(s, arr, numRows);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (char ch : arr[i]) {
                result.append(ch);
            }
        }
        return result.toString();
    }
}