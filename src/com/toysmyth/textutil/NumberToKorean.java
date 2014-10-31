package com.toysmyth.textutil;

import java.util.Stack;

public class NumberToKorean {

	public static void main(String[] args) {
		
		int start = 0;
		int end = start + 1000;
		
		if (args.length > 0)
			start = Integer.parseInt(args[0]);
		if (args.length > 1)
			end = Integer.parseInt(args[1]);
		
		for (int i=start; i<=end; i++) {
			String numText = convertNumber2Korean(i);
			
			System.out.println(numText);
		}
	}

	public static String convertNumber2Korean(long number) {
		Stack<Integer> stack = new Stack<Integer>();
		
		long numCurrent = number;
		do {
			int numLittle = (int)(numCurrent % 10);
			
			stack.add(numLittle);
			
			numCurrent /= 10;
		} while (numCurrent > 0);
		
		StringBuilder sBuilder = new StringBuilder();
		
		while (!stack.isEmpty()) {
			int num = stack.pop();
			int digit = stack.size();
			
			if (num>1 || number<=1 || (num==1 && digit==0)) {
				sBuilder.append(getNumberText(num));
			} 
			
			if (num>0)
				sBuilder.append(getDigitText(digit));
		}
		
		return sBuilder.toString();
	}

	private static String numberText[] = 
		{"영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
	private static String getNumberText(int number) {
		return numberText[number];
	}

	private static String digitText[] = { 
		"", "십", "백", "천"
	};
	private static String digitUnitText[] = {
		"", "만", "억", "조", "경", "해", "자", "양", "구", "간", "정", "재", "극", "항하사", "아승기", "나유타", "불가사의", "무량대수"
	}; // Be aware of range for long type.
	private static String getDigitText(int digit) {
		return digitText[digit%4] + digitUnitText[digit/4];
	}

}
