package exam;

import java.util.Scanner;

public class StackEx2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System. in);
		Stack stack = new Stack(100);

		String correct = sc.nextLine();
		int answer = 0 ;
		char[] arr = correct.toCharArray(); //문자열을 한문자씩 저장된 char 배열로 반환
		
		for(char chr : arr) {
			stackPush(stack, chr);
			answer = check(stack, chr);
			if(answer != 0) break;
		}
		if(stack.isEmpty() && answer == 0) //검증 2
			System.out.println("수식의 괄호가 모두 정상입니다");
		else
			System.out.println("수식 괄호에 오류가 있습니다");
		
	}
	private static void stackPush(Stack stack, char c) {
		if((c == '(') || (c == '{' ) || (c == '[')){
			stack.push(c);
		}
	}
	
	private static int check(Stack stack, char c) {
		if((c == ')') || (c == '}' ) || (c == ']')) {
			if(stack.isEmpty()) return 1; //검증 1
			else {
				char p = stack.pop();
				if((p == '(' && c == ')') || (p == '{' && c == '}') || (p == '[' && c == ']')) {
					return 0;
				}
				else return 3;
			}
		}
		return 0;
	}
}
