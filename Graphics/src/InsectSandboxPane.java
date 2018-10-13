import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

class InsectSandboxPane extends JPanel {

	private int width;

	private int height;

	private ArrayList<Insect> insects = new ArrayList<Insect>();

	public InsectSandboxPane(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		for (Shape s : insects) {
			s.draw(g);
		}
	}

	public void newInsect(Insect i) {
		insects.add(i);
		this.repaint();
	}
	public void moveAll(MessageListener ml) {

		Iterator<Insect> ii = insects.iterator();

		while (ii.hasNext()) {
			Insect s = ii.next();
			s.move();

			if (s.getX() >= width || s.getX() <= 0 || s.getY() >= height
			        || s.getY() <= 0) {
				ii.remove();
				String msg = "removed: " + s + ", " + insects.size()
				        + " left in the sandbox !";
				System.out.println(msg);
				ml.newMessage(msg);
			}
		}

		this.repaint();
	}
}

interface MessageListener {
	public void newMessage(String msg);
}