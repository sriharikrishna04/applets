import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bar extends Applet implements ActionListener {
    private TextField[] courseFields;
    private int[] passPercentages;
    
    public void init() {
        // Create text fields for each course
        courseFields = new TextField[5];
        for (int i = 0; i < 5; i++) {
            courseFields[i] = new TextField(10);
            add(new Label("Course " + (i + 1)));
            add(courseFields[i]);
        }
        
        // Add a button to draw the chart
        Button drawButton = new Button("Draw Chart");
        drawButton.addActionListener(this);
        add(drawButton);
    }
    
    public void actionPerformed(ActionEvent e) {
        passPercentages = new int[5];
        
        // Parse user input and calculate pass percentages
        for (int i = 0; i < 5; i++) {
            try {
                passPercentages[i] = Integer.parseInt(courseFields[i].getText());
            } catch (NumberFormatException ex) {
                passPercentages[i] = 0;
            }
        }
        
        repaint(); // Trigger the paint method to draw the chart
    }
    
    public void paint(Graphics g) {
        int x = 50;
        int y = 250;
        int barWidth = 40;
        int barSpacing = 20;
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(Color.BLUE);
        for (int i = 0; i < 5; i++) {
            int barHeight = passPercentages[i] * 2; // Scale for display
            g.fillRect(x, y - barHeight, barWidth, barHeight);
            g.setColor(Color.BLACK);
            g.drawString("Course " + (i + 1), x, y + 20);
            x += barWidth + barSpacing;
        }
    }
}
