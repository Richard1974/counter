package counterapplication;

import java.awt.event.*;

class ResetItemHandler implements ActionListener {
    
    private Counter counter;
    private CounterApplication view;
    
    public ResetItemHandler(Counter c, CounterApplication a) {
        counter = c;
        view = a;
    }
    
    public void actionPerformed(ActionEvent event){
        counter.reset();
        view.update();
    }
}