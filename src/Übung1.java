import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Übung1 {

public Übung1() {
	JFrame myWindow = new JFrame("My First Graph in Java");
	myWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	myWindow.setBounds(0, 0, myGraphAreaWidth + marginH, myGraphAreaHeight + marginV);
	GraphArea theGraphArea = new GraphArea();
	Container content = myWindow.getContentPane();
	content.add(theGraphArea);
	myWindow.setVisible(true);
}

public class GraphArea extends JPanel {

public void paintComponent(Graphics g) {
	Graphics2D g2D = (Graphics2D) g;
	g2D.setPaint(Color.blue);
	g2D.setPaint(Color.black);
	for(int j=0; j<myGraphAreaWidth; j=j+10 ){
		g2D.drawRect(j, 10, 10, 10);
		for(int i=0; i<myGraphAreaHeight; i=i+10 ){
			g2D.drawRect(j, i, 10, 10);			
		}
	}
	//Linie zeichnen
	int start_x = 50;
	int start_y = 200;
	int end_x = 400;
	int end_y = 200;
	g2D.setPaint(Color.red);
	g2D.fillRect(start_x, start_y, 10, 10);
	g2D.fillRect(end_x, end_y, 10, 10);
	if(start_x==end_x){
		g2D.setPaint(Color.black);
		for(int i=start_y+10; i<end_y;i=i+10){
			g2D.fillRect(start_x, i, 10, 10);
		}
	}
	if(start_y==end_y){
		g2D.setPaint(Color.black);
		for(int j=start_x+10; j<end_x;j=j+10){
			g2D.fillRect(j, start_y, 10, 10);
		}
	}
	//Kreis zeichnen
	int x = 100;
	int y = 100;
	int r = 40;
	double delta = 5.0/4.0 - r;
	g2D.setPaint(Color.red);
	g2D.fillRect(x, y, 10, 10);
	while(y >= x){
		g2D.fillRect(x, y, 10, 10);
		if(delta < 0.0){
			delta+=2*x + 3.0;
			x++;
		}
		else{
			delta+=2*x - 2*y + 5.0;
			x++;
			y++;
		}
	}
	}
}

public static void main(String[] args) {
	new Übung1();
}
int myGraphAreaWidth = 500;
int myGraphAreaHeight = 400;
int yZero = myGraphAreaHeight / 2;
int marginV = 50;
int marginH = 20;
}