package com.thinkinginjava.clazz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//: typeinfo/toys/ToyTest.java
//Testing class Class.
interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
	// Comment out the following default constructor
	// to see NoSuchMethodError from (*1*)
	Toy() {
	}

	Toy(int i) {
		System.out.println("Create Toy with 1");
	}
	void f(){
		System.out.println("Toy........");
	}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
	FancyToy() {
		super(1);
	}
}

public class ToyTest {
	static void printInfo(Class cc) {
		System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
		System.out.println("Simple name: " + cc.getSimpleName());
		System.out.println("Canonical name : " + cc.getCanonicalName());
	}

	public static void main(String[] args) {
		try {
			Class c = Class.forName("com.thinkinginjava.clazz.Toy");
			
			Constructor<Toy>[] cons = c.getDeclaredConstructors();
			System.out.println(cons.length);
			Toy toy=null;
			try {
				toy = cons[1].newInstance(1);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			toy.f();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//		Class c = null;
//		try {
//			c = Class.forName("typeinfo.toys.FancyToy");
//		} catch (ClassNotFoundException e) {
//			System.out.println("Can't find FancyToy");
//			System.exit(1);
//		}
//		printInfo(c);
//		for (Class face : c.getInterfaces())
//			printInfo(face);
//		Class up = c.getSuperclass();
//		Object obj = null;
//		try {
//			// Requires default constructor:
//			obj = up.newInstance();
//		} catch (InstantiationException e) {
//			System.out.println("Cannot instantiate");
//			System.exit(1);
//		} catch (IllegalAccessException e) {
//			System.out.println("Cannot access");
//			System.exit(1);
//		}
//		printInfo(obj.getClass());
	}
} /*
	 * Output: Class name: typeinfo.toys.FancyToy is interface? [false] Simple
	 * name: FancyToy Canonical name : typeinfo.toys.FancyToy Class name:
	 * typeinfo.toys.HasBatteries is interface? [true] Simple name: HasBatteries
	 * Canonical name : typeinfo.toys.HasBatteries Class name:
	 * typeinfo.toys.Waterproof is interface? [true] Simple name: Waterproof
	 * Canonical name : typeinfo.toys.Waterproof Class name:
	 * typeinfo.toys.Shoots is interface? [true] Simple name: Shoots Canonical
	 * name : typeinfo.toys.Shoots Class name: typeinfo.toys.Toy is interface?
	 * [false] Simple name: Toy Canonical name : typeinfo.toys.Toy
	 */// :~
