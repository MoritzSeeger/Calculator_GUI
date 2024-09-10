import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame implements ActionListener{
    JFrame frame;
    JButton[] numbuttons = new JButton[10];
    JButton[] functionButton = new JButton[9];

    JButton plusButton, minusButton, multButton, divButton, kommButton, delButton, clrButton, eqlButton, negButton;

    BorderLayout borderLayout = new BorderLayout(5,5);
    JTextField textField;
    JLabel label;
    JPanel panel1;
    JPanel panel2;
    BorderFactory borderFactory;
    char operator;
    double num1;
    double num2;
    double result;

    ImageIcon icon = new ImageIcon("Ted.png");
    ImageIcon imageIcon = new ImageIcon("taschenrechner.png");
    Image originalImage = icon.getImage();
    Image scaledImage = originalImage.getScaledInstance(70, 75, Image.SCALE_SMOOTH);
    ImageIcon resizedIcon = new ImageIcon(scaledImage);
    Frame(){

        frame = new JFrame("Taschenrechner");
        frame.setSize(500,800);
        frame.setIconImage(scaledImage);
        frame.getContentPane().setBackground(Color.white);
        frame.setLayout(null);

        plusButton = new JButton("+");
        minusButton = new JButton("-");
        multButton = new JButton("*");
        divButton = new JButton("/");
        kommButton = new JButton(",");
        eqlButton = new JButton("=");
        delButton = new JButton("delete");
        clrButton = new JButton("clear");
        negButton = new JButton("(-)");

        plusButton.setBackground(Color.white);
        minusButton.setBackground(Color.white);
        multButton.setBackground(Color.white);
        divButton.setBackground(Color.white);
        kommButton.setBackground(Color.white);
        eqlButton.setBackground(Color.white);
        delButton.setBackground(Color.white);
        clrButton.setBackground(Color.white);
        negButton.setBackground(Color.white);
        Border border = BorderFactory.createLineBorder(Color.white);

        eqlButton.setIcon(resizedIcon);


        functionButton[0] = plusButton;
        functionButton[1] = minusButton;
        functionButton[2] = multButton;
        functionButton[3] = divButton;
        functionButton[4] = kommButton;
        functionButton[5] = delButton;
        functionButton[6] = clrButton;
        functionButton[7] = eqlButton;
        functionButton[8] = negButton;

        label = new JLabel();
        label.setText("Tedulator");
        label.setForeground(Color.white);
        label.setBounds(160,20,100,20);
        label.setFont(new Font("Monoospaced",Font.ITALIC,18));


        textField = new JTextField();
        textField.setBounds(41,25,400,150);
        textField.setBackground(new Color(255,209,220));
        textField.setEditable(false);
        textField.setBorder(border);
        textField.add(label);

        panel1 = new JPanel();
        panel2 = new JPanel();

        for (int i = 0; i < numbuttons.length; i++){
            numbuttons[i] = new JButton(String.valueOf(i));
            numbuttons[i].setFont(new Font("Monoospaced",Font.ITALIC,16));
            numbuttons[i].addActionListener(this);
            numbuttons[i].setForeground(Color.black);
            numbuttons[i].setBorder(border);
            numbuttons[i].setBackground(new Color(255,209,220));
            numbuttons[i].setFocusable(false);
        }

        for (int j = 0; j < functionButton.length; j++){
            functionButton[j].setFont(new Font("Monoospaced",Font.ITALIC,20));
            functionButton[j].addActionListener(this);
            functionButton[j].setForeground(Color.black);
            functionButton[j].setBorder(border);
            functionButton[j].setBackground(new Color(255,209,220));
            functionButton[j].setFocusable(false);
        }

        panel1.setBounds(41,655,400,90);
        panel1.setBackground(new Color(255,209,220));
        panel1.add(functionButton[6]);
        panel1.add(functionButton[5]);
        panel1.add(functionButton[8]);
        panel1.setLayout(new GridLayout(1,3,5,5));

        panel2.setBounds(41,250,400,400);
        panel2.setBackground(new Color(255,209,220));
        panel2.setLayout(new GridLayout(4,4,5,5));
        panel2.add(numbuttons[7]);
        panel2.add(numbuttons[8]);
        panel2.add(numbuttons[9]);
        panel2.add(functionButton[0]);
        panel2.add(numbuttons[4]);
        panel2.add(numbuttons[5]);
        panel2.add(numbuttons[6]);
        panel2.add(functionButton[1]);
        panel2.add(numbuttons[1]);
        panel2.add(numbuttons[2]);
        panel2.add(numbuttons[3]);
        panel2.add(functionButton[2]);
        panel2.add(numbuttons[0]);
        panel2.add(functionButton[4]);
        panel2.add(functionButton[7]);
        panel2.add(functionButton[3]);


        frame.add(textField);
        frame.add(panel1);
        frame.add(panel2);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numbuttons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == kommButton) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == plusButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == minusButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == multButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == eqlButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length()-1; i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }
}


