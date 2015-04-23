import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
	final int marginV = 200;

	public GUI(final GraphAreaInterface gA) {
		Container content = this.getContentPane();
		final GUI guiReference = this;
		final JPanel controlPanel = new JPanel(new GridLayout(4,1));
		final JPanel anglePanel = new JPanel(new FlowLayout());
		final JPanel scalePanel = new JPanel(new FlowLayout());
		final JPanel transPanel = new JPanel(new FlowLayout());
		final JPanel rankingPanel = new JPanel(new FlowLayout());
		final JButton btnResetImage = new JButton("Reset");
		final JSlider sldTurnAngle = new JSlider(0, 360, 0);
		final JLabel lblTurnAngle = new JLabel("Angle: 0°");
		final JSlider sldScaleX = new JSlider(0,20,10);
		final JSlider sldScaleY = new JSlider(0,20,10);
		final JLabel lblScale = new JLabel("Scale: X 1.0 Y 1.0");
		final JLabel lblTrans = new JLabel("Trans: X 0 Y 0");
		final JSlider sldTransX = new JSlider(-1 * gA.getPixelArray()[0].length,gA.getPixelArray()[0].length,0);
		final JSlider sldTransY = new JSlider(-1 * gA.getPixelArray().length ,gA.getPixelArray().length,0);
		final JLabel lblTransformations = new JLabel("Transformation Order: ");
		final JComboBox<TransformationHandler.Transformation> firstTrans = new JComboBox<TransformationHandler.Transformation>(TransformationHandler.Transformation.values());
		final JComboBox<TransformationHandler.Transformation> secondTrans = new JComboBox<TransformationHandler.Transformation>(TransformationHandler.Transformation.values());
		final JComboBox<TransformationHandler.Transformation> thirdTrans = new JComboBox<TransformationHandler.Transformation>(TransformationHandler.Transformation.values());
		
		TransformationHandler.Transformation[] initialTransArray = gA.getTransformationHandler().getTransformationArray();
		firstTrans.setSelectedItem((initialTransArray.length > 0)?initialTransArray[0]:TransformationHandler.Transformation.NONE);
		secondTrans.setSelectedItem((initialTransArray.length > 1)?initialTransArray[1]:TransformationHandler.Transformation.NONE);
		thirdTrans.setSelectedItem((initialTransArray.length > 2)?initialTransArray[2]:TransformationHandler.Transformation.NONE);

		this.setLayout(new BorderLayout());

		btnResetImage.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
					gA.reset(); 
					lblTurnAngle.setText("Angle: 0°");
					sldTurnAngle.setValue(0);
					sldScaleX.setValue(10);
					sldScaleY.setValue(10);
					lblScale.setText("Scale: X 1.0 Y 1.0");
					sldTransX.setValue(0);
					sldTransY.setValue(0);
					lblTrans.setText("Trans: X 0 Y 0");
					guiReference.repaint();
					guiReference.revalidate();
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
					lblTrans.setText(String.format("Trans: X %d Y %d",sldTransX.getValue(), sldTransY.getValue()));
					gA.translate(sldTransX.getValue(), sldTransY.getValue());
					guiReference.repaint();
				}
			}
		};
		
		ActionListener transformationDropdownListener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				TransformationHandler.Transformation[] trans = new TransformationHandler.Transformation[3];
				trans[0] = (TransformationHandler.Transformation) firstTrans.getSelectedItem();
				trans[1] = (TransformationHandler.Transformation) secondTrans.getSelectedItem();
				trans[2] = (TransformationHandler.Transformation) thirdTrans.getSelectedItem();
				gA.getTransformationHandler().setTransformationArray(trans);
				guiReference.repaint();
				}
			};
		
		gA.addMouseListener( new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				btnResetImage.doClick();
				int pixelWidth = gA.getPixelWidth();
				int canvasX = e.getX() / pixelWidth;
				int canvasY = e.getY() / pixelWidth;
				gA.setTransformationBasePoint(canvasX, canvasY);
				guiReference.repaint();
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		
		sldScaleX.addChangeListener(scaleCL);
		sldScaleY.addChangeListener(scaleCL);
		
		sldTransX.addChangeListener(transCL);
		sldTransY.addChangeListener(transCL);
		
		firstTrans.addActionListener(transformationDropdownListener);
		secondTrans.addActionListener(transformationDropdownListener);
		thirdTrans.addActionListener(transformationDropdownListener);
		
		rankingPanel.add(lblTransformations);
		rankingPanel.add(firstTrans);
		rankingPanel.add(secondTrans);
		rankingPanel.add(thirdTrans);
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
		controlPanel.add(rankingPanel);
		content.add(controlPanel, BorderLayout.NORTH);
		content.add(gA, BorderLayout.CENTER);

		int graphAreaWidth = gA.getWidth();
		int graphAreaHeight = gA.getHeight();

		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(0, 0, graphAreaWidth + controlPanel.getWidth() + marginH,
				graphAreaHeight + controlPanel.getHeight() + marginV);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {

		// Point Array
		Point[] points = {new Point(5,40), new Point(15,20), new Point(25,40), new Point(35, 17), new Point(45,30)};
		GraphAreaInterface gA = new GraphArea(500, 500, new Pokeball());
		GUI g = new GUI(gA);
	}
}
