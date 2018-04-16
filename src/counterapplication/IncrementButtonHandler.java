package counterapplication;

import java.awt.event.*;

class IncrementButtonHandler implements ActionListener {
    
    private Counter counter;
    private CounterApplication view;
    
    public IncrementButtonHandler(Counter c, CounterApplication a) {
        counter = c;
        view = a;
    }
    
    public void actionPerformed(ActionEvent event){
        counter.increment();
        view.update();
    }
}