class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        
        for(int i =0;i<arr.length;i++){
            if(st.isEmpty() || arr[i]>0) st.push(arr[i]);
            else{
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(arr[i])) st.pop();
                if(st.isEmpty()||st.peek()<0)  st.push(arr[i]);
                else if(st.peek()==Math.abs(arr[i])) st.pop();
            }
        }
        int nums[] = new int[st.size()];
        for(int i = nums.length-1;i>=0;i--){
            nums[i]=st.pop();
        }
        return nums;
    }
}