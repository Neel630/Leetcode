class Solution {
    public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        
        int max = num;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i) == '6'){
                sb.setCharAt(i, '9');
                max = Math.max(max, Integer.parseInt(sb.toString()));
                sb.setCharAt(i, '6');
                
            }else{
                sb.setCharAt(i, '6');
                max = Math.max(max, Integer.parseInt(sb.toString()));
                sb.setCharAt(i, '9');
            }
        }
        
        return max;
    }
}