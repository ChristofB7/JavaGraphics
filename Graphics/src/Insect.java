import java.awt.Graphics;
import java.util.Random;

abstract class Insect extends Shape {

	protected double directionAngle;

	protected double speed = 2;

	protected Random randGen = new Random();

	private double randomAngle() {
		return randGen.nextFloat() * 2 * Math.PI;
	}

	public Insect(int x, int y) {
		super(x, y);
		directionAngle = randomAngle();
	}

	abstract public void move();

	// see: https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics.html
	abstract public void draw(Graphics g);

}