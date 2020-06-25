package com.stzhao.lambda;

public class MainTest {

	public static void main(String[] args) {
		FuncInterTest.test((c)->{
			
			System.out.println("this is :"+c+500);
			return c+500;
		});
		FuncInterTest.test2((c)->{
			System.out.println(c+"aaaa-----");
			
		});
		FuncInterTest.test3(()->{
			
			return "test33333";
		});
	}

}
