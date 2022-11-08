class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push('\0');
        
        for(char c : s.toCharArray()){
            if(stack.peek() != '\0'){
                char peek = stack.peek();
                if((c - 'A' == peek - 'a' )|| (c - 'a' == peek - 'A' )){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }else{
                stack.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(stack.peek() != '\0'){
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}