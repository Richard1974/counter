package counterapplication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class CounterApplication extends JFrame {
    Counter counter;
    JLabel label;
    JButton incrementButton;
    JButton resetButton;
    
    public CounterApplication() {
        
        counter = new Counter();
        label = new JLabel("" + counter.getCount(),
                           SwingConstants.CENTER);
        incrementButton = new JButton("Increment");
        resetButton = new JButton("Reset");
        
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 1));
        container.add(label);
        container.add(incrementButton);
        container.add(resetButton);
                
        incrementButton.addActionListener(new IncrementButtonHandler(counter, this));
        resetButton.addActionListener(new ResetButtonHandler(counter, this));
        
        setSize(150, 450);
        setVisible(true);
    }
    
    public void update() {
        label.setText("" + counter.getCount());
        repaint();
    }
    
    public static void main(String[] args){
        CounterApplication app = new CounterApplication();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
