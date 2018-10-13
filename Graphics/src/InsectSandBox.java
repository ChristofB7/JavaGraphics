import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

class InsectSandBox extends JFrame {

	// Constants :

	private final int HEIGHT = 550;
	private final int WIDTH = 550;
	private final String straightLineInsect = "straightLineInsect";
	private final String randomAngleInsect = "randomAngleInsect";
	private final String randomAngleSpeedInsect = "randomAngleSpeedInsect";

	public InsectSandBox() {
		super("Sand Box");

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel rootPanel = new JPanel(new BorderLayout());
		this.add(rootPanel);

		final InsectSandboxPane sandBox = new InsectSandboxPane(HEIGHT, WIDTH);
		rootPanel.add(sandBox, BorderLayout.CENTER);
	
    // TODO: somewhere in here add a MouseAdapter to sandBox
		JPanel buttonPanel = new JPanel(new GridLayout(3, 1));

		rootPanel.add(buttonPanel, BorderLayout.SOUTH);

		JRadioButton b1 = new JRadioButton(straightLineInsect);
		b1.setActionCommand(straightLineInsect);
		JRadioButton b2 = new JRadioButton(randomAngleInsect);
		b2.setActionCommand(randomAngleInsect);
		JRadioButton b3 = new JRadioButton(randomAngleSpeedInsect);
		b3.setActionCommand(randomAngleSpeedInsect);

		final ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(b1);
		buttonGroup.add(b2);
		buttonGroup.add(b3);

		JPanel radioPanel = new JPanel(new GridLayout(1, 3));
		buttonPanel.add(radioPanel);
		radioPanel.add(b1);
		radioPanel.add(b2);
		radioPanel.add(b3);

		b1.setSelected(true);

		final Random randGen = new Random();
		JButton newInsectButton = new JButton("new insect");
		buttonPanel.add(newInsectButton);

		// IMPORTANT: Anonymous Class, we create an anonymous ActionListener :
		// see:
		// https://docs.google.com/document/d/1Ng_W-_yeYQt8FLpdbquHXqdNUUjQjUDbGONPxOSAp60/edit#heading=h.bxqgrwqthxes

		sandBox.addMouseListener(new MouseListener() { // here I add a new Mouse Listener and create an anonymous Mouse Listener

			@Override
			public void mouseClicked(MouseEvent e) { // the only one we really care about it mouseClicked
				// TODO Auto-generated method stub
				String command = buttonGroup.getSelection().getActionCommand();

				if (command == straightLineInsect) {
					System.out.println("ADD straightWalker");

					sandBox.newInsect(new StraightLineMovingInsect(
					        (int) (e.getX()), // create a new insect on the mouse clicked spot using its x and y position as parameters
					        (int) (e.getY())  // of type Straight Line
					));
				} 
				else if (command == randomAngleInsect) {
					System.out.println("ADD randomAngleWalker");

					sandBox.newInsect(new RandomAngleMovingInsect(
							(int) (e.getX()), // create a new insect on the mouse clicked spot using its x and y position as parameters
					        (int) (e.getY())  // of type Random Angle
					));					
				} 
				else if (command == randomAngleSpeedInsect) {
					System.out.println("ADD randomSpeedAngleWalker");

					sandBox.newInsect(new RandomAngleSpeedInsect(
							(int) (e.getX()),   // create a new insect on the mouse clicked spot using its x and y position as parameters
					        (int) (e.getY())   // of type randomAngle speed
					));										                
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		newInsectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String command = buttonGroup.getSelection().getActionCommand();

				if (command == straightLineInsect) {
					System.out.println("ADD straightWalker");

					sandBox.newInsect(new StraightLineMovingInsect(
					        (int) (randGen.nextFloat() * WIDTH), 
					        (int) (randGen.nextFloat() * HEIGHT)
					));
				} 
				else if (command == randomAngleInsect) {
					System.out.println("ADD randomAngleWalker");

					sandBox.newInsect(new RandomAngleMovingInsect(
					        (int) (randGen.nextFloat() * WIDTH), 
					        (int) (randGen.nextFloat() * HEIGHT)
					));					
				} 
				else if (command == randomAngleSpeedInsect) {
					System.out.println("ADD randomSpeedAngleWalker");

					sandBox.newInsect(new RandomAngleSpeedInsect(
					        (int) (randGen.nextFloat() * WIDTH), 
					        (int) (randGen.nextFloat() * HEIGHT)
					));										                
				}
			}
		});

		this.pack();
		this.setVisible(true);

		final JLabel mesagesLabel = new JLabel("no messages yet");
		buttonPanel.add(mesagesLabel);

		// Other anonymous class:

		final MessageListener ml = new MessageListener() {
			public void newMessage(String msg) {
				mesagesLabel.setText(msg);
			}
		};

		// This is where the "moving" is triggered:

		Thread t = new Thread(new Runnable() {
			public void run() {
				while (true) {

					// Runs inside of the Swing UI thread
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							sandBox.moveAll(ml);
						}
					});

					try {
						// IMPORTANT: you can reduce the speed of the animation by segging a longer sleep time
						// Thread.sleep(2000); // sleep 2 seconds (2000 milliseconds 
					  
						Thread.sleep(100); // sleep between moves
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		});
		t.setDaemon(true);
		t.start();
	}
}