class Solution {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int leftVowelCount  = 0;
        int rightVowelCount = 0;
        
        int n = s.length();
        
        for(int i=n/2;i<n;i++){
            if(vowels.indexOf(s.charAt(i-n/2))>=0){
                leftVowelCount++;
            }
            
            if(vowels.indexOf(s.charAt(i))>=0){
                rightVowelCount++;
            } 
        }
        
   
        
        if(rightVowelCount ==leftVowelCount) return true;
        return false;
    }
}