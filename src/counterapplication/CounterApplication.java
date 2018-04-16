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
        
        setTitle("Counter Application");
        setSize(250, 450);
        
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
        
        label.setToolTipText("Current value of the counter");
        incrementButton.setToolTipText("Increment the counter");
        resetButton.setToolTipText("Set the counter back to zero");
        
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('x');
        
        // Handler implemented as named inner class
        class ExitItemListener implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        }
        
        exitItem.addActionListener(new ExitItemListener());
        fileMenu.add(exitItem);
        
        menuBar.add(fileMenu);
        
        JMenu actionMenu = new JMenu("Action");
        actionMenu.setMnemonic('A');
        
        JMenuItem incrementItem = new JMenuItem("Increment");
        incrementItem.setMnemonic('I');
        
        incrementItem.addActionListener(
            // Anonymous inner class to handle exitItem event
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    counter.increment();
                    update();
                }
            } // end anonymous inner class
        ); // end call to addActionListener
        
        actionMenu.add(incrementItem);
        
        JMenuItem resetItem = new JMenuItem("Reset");
        resetItem.setMnemonic('R');
        // Handler implemented in separate class
        resetItem.addActionListener(new ResetItemHandler(counter, this));
        actionMenu.add(resetItem);
        
        menuBar.add(actionMenu);
        
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
