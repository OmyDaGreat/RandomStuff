package org.example.yeet;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ValidParen { //20 - Valid Parentheses

	public static void main(String[] args) {
		log.info(ValidParen.isValid("()[]{}"));
	}
	public static boolean isValid(String s) {
		if(s.length() % 2 != 0) {
			return false;
		}
		while(s.contains("()") || s.contains("[]") || s.contains("{}")) {
			s = s.replace("()", "").replace("[]", "").replace("{}", "");
		}
		return s.length() == 0;
	}
}
