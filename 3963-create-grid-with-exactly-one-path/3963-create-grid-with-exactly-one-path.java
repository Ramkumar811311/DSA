class Solution {
    public String[] createGrid(int m, int n) {
        if (n == 1) {
            String[] ans = new String[m];
            for (int i = 0; i < m; i++) {
                ans[i] = ".";
            }
            return ans;
        }
        String ans[]=new String[m];
        for(int i=0; i<m; i++){
            String str="";
            for(int j=0; j<n; j++){
                if(i==0 &&j<n-1){
                    str+='.';
                }
                else if(j==n-2){
                    str+='.';
                }
                else if(i==m-1 && j==n-1){
                    str+='.';
                }
                else{
                    str+='#';
                }
            }
            ans[i]=str;
        }
        return ans;
    }
}