

/*
 * Basic geometric shape with an X,Y position
 * and an abstract draw method to be implemented
 * in subclasses. 
 * See:  https://docs.google.com/document/d/1Ng_W-_yeYQt8FLpdbquHXqdNUUjQjUDbGONPxOSAp60/edit#heading=h.hsuuk4b0auly
 */
/*
 * The Insect class adds movement, it has an abstract move() method that updates
 * it's x,y coordinate to it's new position, and a abstract draw(Graphics2D)
 * method.
 * 
 * Subclasses will implement move() and draw().
 */

// TODO: create Insect subclasses: 

// class RandomAngleMovingInsect extends Insect { ...

// class RandomAngleAndSpeedMovingInsect extends Insect { ...

public class Main {

	public static void main(String[] args) throws Exception {

		InsectSandBox b = new InsectSandBox();
	}
}
