import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUI extends JFrame {

	// Constants
	final int marginH = 20;
	final int marginV = 80;
	int angle = 0;

	public GUI(final GraphAreaInterface gA,final DrawerInterface drawer) {
		Container content = this.getContentPane();
		final GUI guiReference = this;
		final JPanel buttonPanel = new JPanel(new FlowLayout());
		final JButton btnResetImage = new JButton("Reset");
		final JSlider sldTurnAngle = new JSlider(0, 360, 0);
		final JLabel lblTurnAngle = new JLabel("Angle: 0°");

		this.setLayout(new BorderLayout());

		btnResetImage.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (e.getSource() == btnResetImage){
					gA.clear(); 
					drawer.drawOnto(gA);
					guiReference.repaint();
				}
			}
		});
		
		sldTurnAngle.addChangeListener( new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				if (e.getSource() == sldTurnAngle){
					lblTurnAngle.setText(String.format("Angle: %d°",sldTurnAngle.getValue() ));
					gA.rotate(sldTurnAngle.getValue() - angle);
					guiReference.angle = sldTurnAngle.getValue();
					guiReference.repaint();
				}
			}
		});

		buttonPanel.add(btnResetImage);
		buttonPanel.add(lblTurnAngle);
		buttonPanel.add(sldTurnAngle);
		content.add(buttonPanel, BorderLayout.NORTH);
		content.add(gA, BorderLayout.CENTER);

		int graphAreaWidth = gA.getWidth();
		int graphAreaHeight = gA.getHeight();

		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(0, 0, graphAreaWidth + buttonPanel.getWidth() + marginH,
				graphAreaHeight + buttonPanel.getHeight() + marginV);
		
		// Draw onto Graph Area
		drawer.drawOnto(gA);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {

		// Pokeball
		GraphAreaInterface gA = new GraphArea(500, 500);
		GUI g = new GUI(gA, new Pokeball());
	}
}
