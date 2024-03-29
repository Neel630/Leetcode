class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>(num.length + 1);
        for (int i = num.length - 1, carry = 0; i >= 0 || k > 0 || carry > 0; i--, k /= 10) {
            int d1 = i >= 0 ? num[i] : 0;
            int d2 = k % 10;
            int sum = d1 + d2 + carry;

            result.add(sum % 10);
            carry = sum / 10;
        }
        Collections.reverse(result);
        return result;
    }
}