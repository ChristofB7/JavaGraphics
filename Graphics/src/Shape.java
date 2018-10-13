import java.awt.Graphics;

abstract class Shape {

	private int x;
	private int y;

	public Shape(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	abstract public void draw(Graphics g);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return "Shape(" + getX() + "," + getY() + ")";
	}
}