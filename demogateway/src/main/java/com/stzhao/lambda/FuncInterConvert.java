package com.stzhao.lambda;

@FunctionalInterface
public interface FuncInterConvert<I, R> {

	R process(I i);

}
