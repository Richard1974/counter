package counterapplication;

import java.awt.event.*;

class ResetButtonHandler implements ActionListener {

    private Counter counter;
    private CounterApplication view;
    
    public ResetButtonHandler(Counter c, CounterApplication a) {
        counter = c;
        view = a;
    }
    
    public void actionPerformed(ActionEvent event){
        counter.reset();
        view.update();
    }
}
        