package app;

import domain.Universe;
import domain.star.LuminosityClass;
import domain.star.Star;
import domain.star.StarType;

public class Application {
	public static void main(String[] args) {
		new Star("ZHNU-1376454841","name", StarType.K,0, LuminosityClass.IX,0,0,4253.1807,144.82558,0.44032276,0.10076359586949325);

		System.out.println(Universe.getInstance());
	}

}
