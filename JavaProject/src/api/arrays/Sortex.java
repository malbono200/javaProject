package api.arrays;

import java.util.Arrays;

public class Sortex {

	public static void main(String[] args) {
		// Arreay.sort(배열) : 항목 오름차순 정럴 메소드
		// 배열 타입이 기본타입이거나 String 배열인경우 사용가능
		String[] strAr = {"해바라기","가방","나비"};
		//String[] strAr1 = Arrays.sort(strAr); - 반환값 없음
		Arrays.sort(strAr); // 오름차순으로 항목 정럴 - 문자열인 경우 첫문자로 비교, 첫문자가 동일하면 두번째 문자로 비교..
		
		for(String str : strAr) {
			System.out.println(str);
		}
		
		//사용자 정의 클래스 배열은 Comparable 인터페이스를 구현해야만 정렬
		
	}

}
