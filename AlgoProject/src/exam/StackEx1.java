package exam;

public class StackEx1 {

	public static void main(String[] args) {
		String ex1 = "n2 * (3 + 10)) - 1 + [(10 + 10 + {20 + 1})]";
        String ex2 = "n(3 + 10) * ((3) * 2 / 4) - 1 + [{(10 + 10 + {20 + 1})]";

        System.out.println(check(ex1));
        System.out.println(check(ex2));

	}
	
	public static boolean check(String ex) {
        Stack stack = new Stack(ex.length());

        for (int i = 0; i < ex.length(); i++) {
            char c = ex.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char openCh = stack.pop();
                
                if ((c == ')' && openCh != '(') ||
                    (c == '}' && openCh != '{') ||
                    (c == ']' && openCh != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
