import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Currency;
import javax.swing.*;

public class CellPhonePackages extends JFrame implements ActionListener {

    static final int width = 600;
    static final int height = 400;
    private final JPanel panelEast = new JPanel();
    private final JPanel panelWest = new JPanel();
    private final JPanel panelTop = new JPanel();
    private final JPanel panelBottom = new JPanel();
    private final JPanel panelCentre = new JPanel();
    private final JButton btnExit = new JButton();
    JButton btnOrder = new JButton();

    // Cell phone Model
    ButtonGroup btnGroupModel = new ButtonGroup();
    JRadioButton radModelHundred;
    JRadioButton radModelOneTen;
    JRadioButton radModelTwoHundred;
    //Plans in minutes
    ButtonGroup btnGroupMinutes = new ButtonGroup();
    JRadioButton radThreeHundredMinutes;
    JRadioButton radEightHundredMinutes;
    JRadioButton radFifteenHundredMinutes;

    JCheckBox chkVoiceMail = new JCheckBox();
    JCheckBox chkTextMessaging = new JCheckBox();

    JLabel lblTitle = new JLabel();

    CellPhonePackages() {

        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setTitle("Cell Phone Packages");
        

        CreateRightPane();
        CreateLeftPane();
        CreateBottomPane();
        CreateTopPane();
        CreateCentrePane();
        this.setVisible(true);
    }

    private void CreateRightPane() {

        chkVoiceMail.setText("Voice Mail ($5.00)");
        chkTextMessaging.setText("Text Message ($10.00)");
        panelEast.setLayout(new BorderLayout());

        panelEast.setBorder(BorderFactory.createTitledBorder("Options"));

        panelEast.add(chkVoiceMail);
        panelEast.add(chkTextMessaging, BorderLayout.SOUTH);
        add(panelEast, BorderLayout.EAST);

    }

    private void CreateLeftPane() {

        radEightHundredMinutes = new JRadioButton("800 mins ($65.00) per month");
        radThreeHundredMinutes = new JRadioButton("300 mins ($45.00) per month", true);
        radFifteenHundredMinutes = new JRadioButton("1500 mins ($99.00) per month");

        btnGroupMinutes.add(radEightHundredMinutes);
        btnGroupMinutes.add(radThreeHundredMinutes);
        btnGroupMinutes.add(radFifteenHundredMinutes);

        panelWest.setLayout(new BorderLayout());
        panelWest.setBorder(BorderFactory.createTitledBorder("Packages"));

        panelWest.add(radThreeHundredMinutes, BorderLayout.NORTH);
        panelWest.add(radEightHundredMinutes, BorderLayout.CENTER);
        panelWest.add(radFifteenHundredMinutes, BorderLayout.SOUTH);
        add(panelWest, BorderLayout.WEST);
    }

    protected void CreateBottomPane() {
        btnOrder.setText("Order");
        btnExit.setText("Exit");
        btnExit.addActionListener(this);
        btnOrder.addActionListener(this);
        panelBottom.add(btnOrder);
        panelBottom.add(btnExit);
        add(panelBottom, BorderLayout.SOUTH);
    }

    private void CreateTopPane() {

        lblTitle.setText("Welcome to Cell Solutions");
        panelTop.add(lblTitle);
        add(panelTop, BorderLayout.NORTH);
    }

    private void CreateCentrePane() {
        radModelHundred = new JRadioButton("Model 100 (29.95)", true);
        radModelOneTen = new JRadioButton("Model 110 ($49.95)");
        radModelTwoHundred = new JRadioButton("Model 220 ($99.95)");

        btnGroupModel.add(radModelHundred);
        btnGroupModel.add(radModelOneTen);
        btnGroupModel.add(radModelTwoHundred);

        panelCentre.setLayout(new BorderLayout());

        panelCentre.setBorder(BorderFactory.createTitledBorder("Cellphone Models"));
        panelCentre.add(radModelHundred, BorderLayout.NORTH);
        panelCentre.add(radModelOneTen, BorderLayout.CENTER);
        panelCentre.add(radModelTwoHundred, BorderLayout.SOUTH);
        add(panelCentre, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnExit) {
            dispose();
        } else if (e.getSource() == btnOrder) {
            double total = 0;
            double salesTax = 0.07;
            total += (chkTextMessaging.isSelected()) ? 10 : 0;
            total += (chkVoiceMail.isSelected()) ? 5 : 0;

            total += (radThreeHundredMinutes.isSelected()) ? 45 : 0;
            total += (radEightHundredMinutes.isSelected()) ? 65 : 0;
            total += (radFifteenHundredMinutes.isSelected()) ? 99 : 0;

            total += (radModelHundred.isSelected()) ? 29.95 : 0;
            total += (radModelOneTen.isSelected()) ? 49.95 : 0;
            total += (radModelTwoHundred.isSelected()) ? 99.95 : 0;
            JOptionPane.showMessageDialog(null, "subtotal: " + NumberFormat.getCurrencyInstance().format(total) + "\nTax: " + NumberFormat.getCurrencyInstance().format(total * salesTax) + "\nTotal: " + NumberFormat.getCurrencyInstance().format(total + (total * salesTax)), "Order Total", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    public static void main(String[] args) {

        CellPhonePackages window = new CellPhonePackages();

    }

}
