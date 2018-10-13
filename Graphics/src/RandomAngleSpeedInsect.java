import java.awt.Color;
import java.awt.Graphics;

public class RandomAngleSpeedInsect extends Insect {

	public RandomAngleSpeedInsect(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		double speed = 12.5;

		double deltaX = Math.cos(directionAngle) * speed;
		double deltaY = Math.sin(directionAngle) * speed;

		setX(getX() + ((int) deltaX));
		setY(getY() + ((int) deltaY));
		if(Math.random()<0.5)
		directionAngle += Math.E / 10;
		else
			directionAngle -= Math.E / 10;
		speed = Math.floor(Math.random() * 10) + 1; // do the same thing with the angle and change the speed every time too.
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.CYAN);
		g.draw3DRect(getX(), getY(), 10, 30, true);
		
	}

}
