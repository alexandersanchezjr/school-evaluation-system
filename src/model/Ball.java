package model;

public class Ball {
	public static final int STEP_MOVE = 1;
	private double x;
	private double r;
	private double max;
	private Direction d;
	public Ball(double xx, double rr) {
		x = xx;
		r = rr;
		d = Direction.LEFT;
	}
	public double getX() {
		return x;
	}
	public void setMax(double mx) {
		max = mx;
	}
	public void move() {
		if(d==Direction.LEFT) {
			x -= STEP_MOVE;
		}else {
			x += STEP_MOVE;
		}
		verifyDirection();
	}
	private void verifyDirection() {
		if(x+2*r>=max) {
			x = max-2*r;
			changeDirection();
		}	
		if(x-r<=0) {
			x = r;
			changeDirection();
		}
	}
	private void changeDirection() {
		if(d==Direction.LEFT) {
			d = Direction.RIGHT;
		}else {
			d = Direction.LEFT;
		}
	}
}
