import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultBoundedRangeModel;
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
	final int marginH = 50;
	final int marginV = 150;

	public GUI(final GraphAreaInterface gA,final DrawerInterface drawer) {
		Container content = this.getContentPane();
		final GUI guiReference = this;
		final JPanel controlPanel = new JPanel(new GridLayout(3,1));
		final JPanel anglePanel = new JPanel(new FlowLayout());
		final JPanel scalePanel = new JPanel(new FlowLayout());
		final JPanel transPanel = new JPanel(new FlowLayout());
		final JButton btnResetImage = new JButton("Reset");
		final JSlider sldTurnAngle = new JSlider(0, 360, 0);
		final JLabel lblTurnAngle = new JLabel("Angle: 0°");
		final JSlider sldScaleX = new JSlider(0,20,10);
		final JSlider sldScaleY = new JSlider(0,20,10);
		final JLabel lblScale = new JLabel("Scale: X 1.0 Y 1.0");
		final JLabel lblTrans = new JLabel("Trans: X 1 Y 1");
		final JSlider sldTransX = new JSlider(0,gA.getPixelArray()[0].length,0);
		final JSlider sldTransY = new JSlider(0,gA.getPixelArray().length,10);

		this.setLayout(new BorderLayout());

		btnResetImage.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (e.getSource() == btnResetImage){
					gA.clear(); 
					drawer.drawOnto(gA);
					lblTurnAngle.setText("Angle: 0°");
					sldTurnAngle.setValue(0);
					sldScaleX.setValue(10);
					sldScaleY.setValue(10);
					lblScale.setText("Scale: X 1.0 Y 1.0");
					sldTransX.setValue(0);
					sldTransY.setValue(0);
					lblTrans.setText("Trans: X 1 Y 1");
//					gA.rotate(0);
					guiReference.repaint();
				}
			}
		});
		
		sldTurnAngle.addChangeListener( new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				if (e.getSource() == sldTurnAngle){
					lblTurnAngle.setText(String.format("Angle: %d°",sldTurnAngle.getValue() ));
					gA.rotate(sldTurnAngle.getValue());
					guiReference.repaint();
				}
			}
		});
		
		ChangeListener scaleCL =  new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				if (e.getSource() == sldScaleX || e.getSource() == sldScaleY){
					lblScale.setText(String.format("Scale: X %.1f Y %.1f",sldScaleX.getValue() / 10.0, sldScaleY.getValue() / 10.0 ));
					gA.scale(sldScaleX.getValue()/10.0, sldScaleY.getValue()/10.0);
					guiReference.repaint();
				}
			}
		};
		
		ChangeListener transCL =  new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				if (e.getSource() == sldTransX || e.getSource() == sldTransY){
					lblTrans.setText(String.format("Scale: X %d Y %d",sldTransX.getValue(), sldTransY.getValue()));
					gA.translate(sldTransX.getValue(), sldTransY.getValue());
					guiReference.repaint();
				}
			}
		};
		
		sldScaleX.addChangeListener(scaleCL);
		sldScaleY.addChangeListener(scaleCL);
		
		sldTransX.addChangeListener(transCL);
		sldTransY.addChangeListener(transCL);
		
		transPanel.add(lblTrans);
		transPanel.add(sldTransX);
		transPanel.add(sldTransY);
		scalePanel.add(lblScale);
		scalePanel.add(sldScaleX);
		scalePanel.add(sldScaleY);
		anglePanel.add(btnResetImage);
		anglePanel.add(lblTurnAngle);
		anglePanel.add(sldTurnAngle);
		controlPanel.add(anglePanel);
		controlPanel.add(scalePanel);
		controlPanel.add(transPanel);
		content.add(controlPanel, BorderLayout.NORTH);
		content.add(gA, BorderLayout.CENTER);

		int graphAreaWidth = gA.getWidth();
		int graphAreaHeight = gA.getHeight();

		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(0, 0, graphAreaWidth + controlPanel.getWidth() + marginH,
				graphAreaHeight + controlPanel.getHeight() + marginV);
		
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
