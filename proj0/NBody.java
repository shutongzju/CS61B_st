

public class NBody {

	public static double readRadius(String text) {
		In in = new In(text);
		in.readInt();
		double radius =  in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String text) {
		
		In in = new In(text);
		int i = in.readInt();

		in.readDouble();
		Planet[] planets = new Planet[i];
		int j = 0;
		for(j = 0; j < i; j++) {
			planets[j] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(),
			in.readDouble(), in.readDouble(), in.readString());
		}
		return 	planets;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double Radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		String starfield = "./images/starfield.jpg";

		StdDraw.enableDoubleBuffering();

		StdDraw.setScale(-Radius, Radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, starfield);

		int n = planets.length;
		for (int i = 0; i < n; i++) {
			planets[i].draw();
//			StdDraw.show();
		}

		double[] xForces = new double[n];
		double[] yForces = new double[n];

		for (double t = 0; t < T; t += dt) {
			for (int j = 0; j < n; j++) {
				xForces[j] = planets[j].calcNetForceExertedByX(planets);
				yForces[j] = planets[j].calcNetForceExertedByY(planets);
				planets[j].update(dt, xForces[j], yForces[j]);
			}

			StdDraw.clear();

			StdDraw.picture(0, 0, starfield);

			for (int i = 0; i < n; i++) {
				planets[i].draw();
			}

			StdDraw.show();
			StdDraw.pause(10);
		}


		StdDraw.show();
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", Radius);
		for	(int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
					planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
					planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
	}


	}
}