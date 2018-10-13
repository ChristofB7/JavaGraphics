import java.awt.Color;
import java.awt.Graphics;

class StraightLineMovingInsect extends Insect {

	public StraightLineMovingInsect(int x, int y) {
		super(x, y);
	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(getX(), getY(), 20, 20); 
	}

	public void move() {

		double speed = 10;

		double deltaX = Math.cos(directionAngle) * speed;
		double deltaY = Math.sin(directionAngle) * speed;

		setX(getX() + ((int) deltaX));
		setY(getY() + ((int) deltaY));
	}
}