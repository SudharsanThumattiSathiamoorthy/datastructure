package com.sudharsan.examples;

import java.util.Optional;

public class OptionalExample {

	static public void main(final String... args) {
		final Integer a = null;
		final Integer b = 20;
		
		final Optional<Integer> optionalA = Optional.ofNullable(a);
		final Optional<Integer> optionalB = Optional.ofNullable(b);
		
		System.out.println(optionalA.isPresent());
		System.out.println(optionalB.isPresent());
		
		System.out.println(optionalA.orElse(new Integer(0)) + optionalB.orElse(0));
		
		final vehicle v = new car();
		v.blowHorn();
	}
}

interface vehicle {
	default void blowHorn() {
		System.out.println("Vehicle");
	}
}

interface fourwheeler {
	default void blowHorn() {
		System.out.println("Four Wheeler");
	}
}

class car implements vehicle, fourwheeler {

	@Override
	public void blowHorn() {
		System.out.println("Vechicle  + car");
		vehicle.super.blowHorn();
	}
	
}