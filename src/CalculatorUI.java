import java.awt.*;
import java.awt.event.*;

import javax.swing.border.Border;


public class CalculatorUI extends Frame implements ActionListener {
    TextField display;
    StringBuilder currentInput = new StringBuilder();
    CalculatorLogic logic = new CalculatorLogic();
    public CalculatorUI(){
        setTitle("Calculator");
        setSize(300,400);
        setLayout(new BorderLayout());
        setVisible(true);

        //Display
        display = new TextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display,BorderLayout.NORTH);

        //Buttons
        Panel panel = new Panel();
        panel.setLayout(new GridLayout(4,4));
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };
        for(String label: buttons){
            Button b = new Button();
            b.setFont(new Font("Arial", Font.PLAIN, 20));
            b.addActionListener(this);
            panel.add(b);
        }
        add(panel,BorderLayout.CENTER);

        // Close Window on exit
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we){
                dispose();
            }
        });
    }


    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if(command.equals("C")){
            currentInput.setLength(0);
            display.setText("");
        } else if(command.equals("=")){
            String result = logic.evaluate(currentInput.toString());
            display.setText(result);
            currentInput.setLength(0);
        }else{
            currentInput.append(command);
            display.setText(currentInput.toString());
        }
    }
}
