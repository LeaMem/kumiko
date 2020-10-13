package com.lea.kumiko.midware.others.customTest;

public interface Factory<T> {

	T create();


	class Creator<T>{

		T instance;

		public <F extends Factory<T>> T newInstance(F f){
			instance = f.create();
			return instance;
		}
	}

	class IntegerFactory implements Factory<Integer>{

		@Override
		public Integer create() {
			return 9;
		}
	}

}
