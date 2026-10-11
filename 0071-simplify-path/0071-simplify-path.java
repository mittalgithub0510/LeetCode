class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();

        String[] arr = path.split("/");

        for (String str : arr) {
            if (str.equals("") || str.equals(".")) {
                continue;
            } 
            else if (str.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } 
            else {
                st.push(str);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (String dir : st) {
            sb.append("/").append(dir);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}