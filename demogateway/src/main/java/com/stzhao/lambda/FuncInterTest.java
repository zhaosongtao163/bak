package com.stzhao.lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FuncInterTest<T> {

	public static void test(FuncInterConvert<Integer,Integer> convert) {
		String result = "final:"+convert.process(100);
		System.out.println(result);
	}

	public static void test2(Consumer<String> consumer) {
		consumer.accept("bbbb");
	}

	public static void test3(Supplier<String> supplier) {
		String test3 = supplier.get();
		System.out.println("test3=="+test3);
	}

}
