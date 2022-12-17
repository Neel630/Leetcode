class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        
        for(String s : tokens) stack.push(s);
        
        return eval(stack);
    }
    
    public int eval(Stack<String> stack){
        String s = stack.pop();
        
        // System.out.println(s+" "+(s == "*"));
        
        if(s.equals("+")){
            int right = eval(stack);
            int left = eval(stack);
            return left + right;
        }else if(s.equals("-")){
            int right = eval(stack);
            int left = eval(stack);
            return left - right;
        }else if(s.equals("/")){
            int right = eval(stack);
            int left = eval(stack);
            return left / right;
        }else if(s.equals("*")){
            int right = eval(stack);
            int left = eval(stack);
            return left * right;
        }else return Integer.parseInt(s);
        
    }
}