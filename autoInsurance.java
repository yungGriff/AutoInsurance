package autoInsurance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class autoInsurance {

    private JTextField ageField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JComboBox<String> vehicleTypeComboBox;
    private JComboBox<String> colorComboBox;
    private JComboBox<String> insuranceTypeComboBox;
    private JButton calculateButton;
    private JTextArea resultTextArea;

    // Add these variables
    private int carColor;
    private int colorCost;
    private int genderRate;
    private int storedAge;
    private int insuranceType;
    private int vehicleTypeX;
    private int carCost;
    private int coverageCost;

    public autoInsurance() {
        JFrame frame = new JFrame("Auto Insurance Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel ageLabel = new JLabel("Driver's Age:");
        ageLabel.setBounds(10, 20, 80, 25);
        panel.add(ageLabel);

        ageField = new JTextField(20);
        ageField.setBounds(100, 20, 165, 25);
        panel.add(ageField);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(10, 50, 80, 25);
        panel.add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(100, 50, 80, 25);
        panel.add(femaleRadioButton);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        JLabel vehicleTypeLabel = new JLabel("Vehicle Type:");
        vehicleTypeLabel.setBounds(10, 80, 80, 25);
        panel.add(vehicleTypeLabel);

        String[] vehicleTypes = {"CAR", "TRUCK", "VAN", "SPORTS CAR"};
        vehicleTypeComboBox = new JComboBox<>(vehicleTypes);
        vehicleTypeComboBox.setBounds(100, 80, 165, 25);
        panel.add(vehicleTypeComboBox);

        JLabel colorLabel = new JLabel("Vehicle Color:");
        colorLabel.setBounds(10, 110, 80, 25);
        panel.add(colorLabel);

        String[] colors = {"RED", "BLUE", "GREY", "WHITE"};
        colorComboBox = new JComboBox<>(colors);
        colorComboBox.setBounds(100, 110, 165, 25);
        panel.add(colorComboBox);

        JLabel insuranceTypeLabel = new JLabel("Insurance Type:");
        insuranceTypeLabel.setBounds(10, 140, 100, 25);
        panel.add(insuranceTypeLabel);

        String[] insuranceTypes = {"Comprehensive", "Driver", "Full Coverage"};
        insuranceTypeComboBox = new JComboBox<>(insuranceTypes);
        insuranceTypeComboBox.setBounds(120, 140, 145, 25);
        panel.add(insuranceTypeComboBox);

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(10, 260, 150, 25);
        panel.add(calculateButton);

        resultTextArea = new JTextArea();
        resultTextArea.setBounds(10, 290, 350, 50);
        panel.add(resultTextArea);

        // Add ActionListener for the Calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    calculateInsurance();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    private void calculateInsurance() throws IOException {
        int driverAge = Integer.parseInt(ageField.getText());
        int genderRate = femaleRadioButton.isSelected() ? 1 : 2;
        int vehicleTypeX = vehicleTypeComboBox.getSelectedIndex() + 1;

        // Your existing logic
        if (driverAge == 18) {
            storedAge = 4;
        } else if (driverAge <= 25) {
            storedAge = 2;
        } else {
            storedAge = 1;
        }

        switch (vehicleTypeX) {
            case 1:
                carCost = 1;
                break;
            case 2:
                carCost = 2;
                break;
            case 3:
                carCost = 1;
                break;
            case 4:
                carCost = 4;
                break;
            default:
                // Handle default case
        }

        int colorIndex = colorComboBox.getSelectedIndex() + 1;
        switch (colorIndex) {
            case 1:
                colorCost = 4;
                break;
            case 2:
                colorCost = 2;
                break;
            case 3:
                colorCost = 1;
                break;
            case 4:
                colorCost = 1;
                break;
            default:
                // Handle default case
        }

        int insuranceTypeIndex = insuranceTypeComboBox.getSelectedIndex() + 1;
        switch (insuranceTypeIndex) {
            case 1:
                System.out.println("You selected Comprehensive Insurance");
                coverageCost = 100;
                break;
            case 2:
                System.out.println("You selected Driver Insurance:");
                coverageCost = 50;
                break;
            case 3:
                System.out.println("You have selected Full: ");
                coverageCost = 200;
                break;
            default:
                // Default report
                System.out.println("Always a Silver Lining");
        }

        int monthlyFee = ((coverageCost * colorCost * carCost * genderRate * storedAge) / 12);
        resultTextArea.setText("Your auto insurance quote estimate is priced at: " + monthlyFee + "$ per month.");

        // Additional code for writing to file if needed
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new autoInsurance();
            }
        });
    }
}
