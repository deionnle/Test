public class First {
    static boolean f(String s1, String s2) {
        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();
        int x = 0;

        for (int i = 0; i < s1arr.length; i++) {
            if (s2arr[x] == s1arr[i]) {
                if (x == s2arr.length - 1) {
                    return true;
                }
                x ++;
            } else {
                x = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "12312453124318";
        String s2 = "318";
        System.out.println(f(s1,s2));
    }
}