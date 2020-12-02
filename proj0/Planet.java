
public class Planet {

	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}

	public Planet(Planet p) {
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}
	
	public double calcDistance(Planet p) {
		return Math.sqrt(Math.pow(p.xxPos - this.xxPos, 2) + Math.pow(p.yyPos - this.yyPos, 2));
	}

	public double calcForceExertedBy(Planet p) {
		if (this.calcDistance(p) == 0) {
			return 0;
		}
		return G * this.mass * p.mass / Math.pow(this.calcDistance(p), 2);
	}

	public double calcForceExertedByX(Planet p) {
		if (this.calcDistance(p) == 0) {
			return 0;
		}
		return -this.calcForceExertedBy(p) * (this.xxPos - p.xxPos) / this.calcDistance(p);
	}

	public double calcForceExertedByY(Planet p) {
		if (this.calcDistance(p) == 0) {
			return 0;
		}
		return -this.calcForceExertedBy(p) * (this.yyPos - p.yyPos) / this.calcDistance(p);
	}

	public double calcNetForceExertedByX(Planet[] ps) {
		int i = ps.length;
		double NFX = 0;
		for (int j = 0; j < i; j++) {
			NFX += this.calcForceExertedByX(ps[j]);
		}	
		return NFX;
	}

	public double calcNetForceExertedByY(Planet[] ps) {
		int i = ps.length;
		double NFY = 0;
		for (int j = 0; j < i; j++) {
			NFY += this.calcForceExertedByY(ps[j]);
		}	
		return NFY;
	}

	public void update(double t, double fx, double fy) {
		this.xxVel = this.xxVel + t*(fx/this.mass);
		this.xxPos = this.xxPos + t*this.xxVel;
		this.yyVel = this.yyVel + t*(fy/this.mass);
		this.yyPos = this.yyPos + t*this.yyVel;
	}

	public void draw() {
		StdDraw.picture(this.xxPos, this.yyPos, "./images/" + this.imgFileName);
	}
}