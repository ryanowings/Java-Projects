import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculator extends JFrame
{
   private final int WINDOW_WIDTH = 200;
   private final int WINDOW_HEIGHT = 250;
   
   private double temp1=0, temp2=0;
   private double result;
   private int operator = 0; //1 multi, 2 divide, 3 add, 4 sub, 0 none
   
   private JPanel panel;
   private JButton equalButton;
   private JButton cButton;
   private JButton multiButton;
   private JButton divideButton;
   private JButton addButton;
   private JButton subButton;
   private JButton decButton;
   private JButton one, two, three, four, five, six, seven, eight, nine, zero;
   private JTextField resultText;
   
   public Calculator()
   {
      setTitle("Calculator");
      setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      
      
            
      panel = new JPanel();
      panel.setBackground(Color.BLACK);
      
     
      
      equalButton = new JButton("=");
      cButton = new JButton("C");
      multiButton = new JButton("*");
      divideButton = new JButton("/");
      addButton = new JButton("+");
      subButton = new JButton("-");
      decButton = new JButton(".");
      one = new JButton("1");
      two = new JButton("2");
      three = new JButton("3");
      four = new JButton("4");
      five = new JButton("5");
      six = new JButton("6");
      seven = new JButton("7");
      eight = new JButton("8");
      nine = new JButton("9");
      zero = new JButton("0");
      
      one.addActionListener(new ButtonListener());
      two.addActionListener(new ButtonListener());
      three.addActionListener(new ButtonListener());
      four.addActionListener(new ButtonListener());
      five.addActionListener(new ButtonListener());
      six.addActionListener(new ButtonListener());
      seven.addActionListener(new ButtonListener());
      eight.addActionListener(new ButtonListener());
      nine.addActionListener(new ButtonListener());
      zero.addActionListener(new ButtonListener());
      equalButton.addActionListener(new ButtonListener());
      cButton.addActionListener(new ButtonListener());
      multiButton.addActionListener(new ButtonListener());
      divideButton.addActionListener(new ButtonListener());
      addButton.addActionListener(new ButtonListener());
      subButton.addActionListener(new ButtonListener());
      decButton.addActionListener(new ButtonListener());
      
      
      resultText = new JTextField();
      resultText.setBackground(Color.DARK_GRAY);
      resultText.setEnabled(false);
      resultText.setPreferredSize(new Dimension(160, 30));
      resultText.setDisabledTextColor(Color.WHITE);

      
      equalButton.setPreferredSize(new Dimension(160, 30));
      
      panel.add(resultText);
      panel.add(one);
      panel.add(two);
      panel.add(three);
      panel.add(four);
      panel.add(five);
      panel.add(six);
      panel.add(seven);
      panel.add(eight);
      panel.add(nine);
      panel.add(zero);
      panel.add(decButton);
      panel.add(cButton);
      panel.add(multiButton);
      panel.add(divideButton);
      panel.add(addButton);
      panel.add(subButton);
      panel.add(equalButton);






      
      add(panel);
      
      setVisible(true);
   }
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         String actionCommand = e.getActionCommand();
         if(actionCommand.equals("1"))
         {
            resultText.setText(resultText.getText() + "1");
            
         }
         else if(actionCommand.equals("2"))
         {
            resultText.setText(resultText.getText() + "2");
         }
         else if(actionCommand.equals("3"))
         {
            resultText.setText(resultText.getText() + "3");
         }
         else if(actionCommand.equals("4"))
         {
            resultText.setText(resultText.getText() + "4");
         }

         else if(actionCommand.equals("5"))
         {
            resultText.setText(resultText.getText() + "5");
         }
         else if(actionCommand.equals("6"))
         {
            resultText.setText(resultText.getText() + "6");
         }
         else if(actionCommand.equals("7"))
         {
            resultText.setText(resultText.getText() + "7");
         }
         else if(actionCommand.equals("8"))
         {
            resultText.setText(resultText.getText() + "8");
         }
         else if(actionCommand.equals("9"))
         {
            resultText.setText(resultText.getText() + "9");
         }
         else if(actionCommand.equals("0"))
         {
            resultText.setText(resultText.getText() + "0");
         }
         else if(actionCommand.equals("."))
         {
            resultText.setText(resultText.getText() + ".");
         }
         else if(actionCommand.equals("C"))
         {
            resultText.setText("");
         }
         else if(actionCommand.equals("*"))
         {  
            operator = 1;
            temp1 = Double.parseDouble(resultText.getText());
            resultText.setText("");
         }
         else if(actionCommand.equals("/"))
         {  
            operator = 2;
            temp1 = Double.parseDouble(resultText.getText());
            resultText.setText("");
         }
         else if(actionCommand.equals("+"))
         {  
            operator = 3;
            temp1 = Double.parseDouble(resultText.getText());
            resultText.setText("");
         }
         else if(actionCommand.equals("-"))
         {  
            operator = 4;
            temp1 = Double.parseDouble(resultText.getText());
            resultText.setText("");
         }
         else if(actionCommand.equals("="))
         {
            if(operator !=0)
            {
               
               temp2 = Double.parseDouble(resultText.getText());
               resultText.setText("");
               if (operator == 1) 
               {
                  resultText.setText(Double.toString(temp1 * temp2));
               } 
               else if (operator == 2 && temp2 != 0) 
               {
                  resultText.setText(Double.toString((Math.round((temp1 / temp2) * 100.0)) / 100.0));
               } 
               else if (operator == 2 && temp2 == 0) 
               {
                  temp2 = 0;
                  resultText.setText("ERROR: CANNOT / BY 0");
               } 

               else if (operator == 3) 
               {
                  resultText.setText(Double.toString(temp2 + temp1));
               } 
               else if (operator == 4) 
               {
                  resultText.setText(Double.toString(temp1 - temp2));
               } 
               else 
               {
                  resultText.setText(String.valueOf(temp1));
               }
               
               
               if(operator == 2 && temp2 == 0)
                  temp1 = 0;
               else
                  temp1 = Double.parseDouble(resultText.getText());
               operator = 0;
               
            }
         }
      }   
   }
   public static void main(String[]args)
   {
      new Calculator();
   }
}



      
      
