import java.awt.Color;
import java.awt.Graphics;

public class RandomAngleMovingInsect extends Insect {

	
	
	public RandomAngleMovingInsect(int x, int y) {
		super(x, y);

	}

	public void move() {
		double speed = 12.5;

		double deltaX = Math.cos(directionAngle) * speed;
		double deltaY = Math.sin(directionAngle) * speed;

		setX(getX() + ((int) deltaX));
		setY(getY() + ((int) deltaY));
		if(Math.random()<0.5)
		directionAngle += Math.PI / 10;   // add or subtract Math.PI / 10 every time move is called to the angle
		else
			directionAngle -= Math.PI / 10;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.MAGENTA);
		g.fillRect(getX(), getY(), 20, 20); // why not make a Magenta Square
	}

}
