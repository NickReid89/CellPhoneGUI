import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static java.text.NumberFormat.getCurrencyInstance;

public class CellPhonePackages2 extends JFrame implements ActionListener {

    //Window Size.
    static final int width = 600;
    static final int height = 400;

    //Labels for window.
    JLabel lblPackage = new JLabel("Package Cost: ");
    JLabel lblPhone = new JLabel("Phone Cost: ");
    JLabel lblOptions = new JLabel("Options Cost: ");

    //text fields with default of 10 character spaces to make room for input from program.
    JTextField txtPackage = new JTextField(10);
    JTextField txtPhone = new JTextField(10);
    JTextField txtOptions = new JTextField(10);

    // button groups for radio buttons.
    ButtonGroup packagebg = new ButtonGroup();
    ButtonGroup phonebg = new ButtonGroup();

    //Check box buttons.
    JCheckBoxMenuItem chkVoiceMail;
    JCheckBoxMenuItem chkText;

    // Panels for main panel.
    JPanel north = new JPanel();
    JPanel center = new JPanel();
    JPanel south = new JPanel();

    // phone model radio buttons.
    JRadioButtonMenuItem radModelOneHundred;
    JRadioButtonMenuItem radModelOneTen;
    JRadioButtonMenuItem radModelTwoHundred;

    // minutes radio buttons.
    JRadioButtonMenuItem radThreeHundredMinutes;
    JRadioButtonMenuItem radEightHundredMinutes;
    JRadioButtonMenuItem radFifteenHundredMinutes;

    // Menu items to exit program or reset values.
    JMenuItem reset;
    JMenuItem exit;

    CellPhonePackages2() {

        //set size.
        this.setSize(width, height);
        // default close application.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // used a grid layout to display date.
        this.setLayout(new GridLayout(3, 0));
        // Title for program.
        this.setTitle("Cell Phone Packages");
        // Make the menu Strip.
        setMenuStrip();
        // Set up the panels.
        setUpPanel();
        // Set up the text fields.
        setUpTextFields();
        // Let the user see the program.
        this.setVisible(true);

    }

    private void setUpTextFields() {
        // Don't let the user put fake info in.
        txtOptions.setEditable(false);
        txtPhone.setEditable(false);
        txtPackage.setEditable(false);
        // force a reset click so the program can do the work for me in the action Performed method.
        // This will set all the default values for the user.
        reset.doClick();
    }

    private void setUpPanel() {
        // Set the individual panels up.
        north.add(lblPackage);
        north.add(txtPackage);

        center.add(lblPhone);
        center.add(txtPhone);

        south.add(lblOptions);
        south.add(txtOptions);

        // Add the panels.
        add(north);
        add(center);
        add(south);
    }

    protected void setMenuStrip() {
        JMenuBar mb = new JMenuBar();

        JMenu file = new JMenu("File");
        // Let's the user reset the choices to default.
        reset = new JMenuItem("Reset");
        file.add(reset);    
        reset.addActionListener(this);
        reset.setMnemonic('r');
        // exits program.
        exit = new JMenuItem("Exit");
        file.add(exit);
        exit.setMnemonic('x');
        exit.addActionListener(this);

        // code for packages.
        JMenu packages = new JMenu("Packages");
        radThreeHundredMinutes = new JRadioButtonMenuItem("300 minutes ($45.00) per month", true);
        radEightHundredMinutes = new JRadioButtonMenuItem("800 minutes ($65.00) per month");
        radFifteenHundredMinutes = new JRadioButtonMenuItem("1500 minutes ($99.00) per month");

        radThreeHundredMinutes.setMnemonic('3');
        radEightHundredMinutes.setMnemonic('8');
        radFifteenHundredMinutes.setMnemonic('5');

        radThreeHundredMinutes.addActionListener(this);
        radEightHundredMinutes.addActionListener(this);
        radFifteenHundredMinutes.addActionListener(this);

        packagebg.add(radThreeHundredMinutes);
        packagebg.add(radEightHundredMinutes);
        packagebg.add(radFifteenHundredMinutes);

        packages.add(radThreeHundredMinutes);
        packages.add(radEightHundredMinutes);
        packages.add(radFifteenHundredMinutes);

        // code for phones.
        JMenu phone = new JMenu("Phones");
        radModelOneHundred = new JRadioButtonMenuItem("Model 100 ($29.95)", true);
        radModelOneTen = new JRadioButtonMenuItem("Model 110 ($49.95)");
        radModelTwoHundred = new JRadioButtonMenuItem("Model 200($99.95)");

        radModelOneHundred.setMnemonic('1');
        radModelOneTen.setMnemonic('0');
        radModelTwoHundred.setMnemonic('2');

        radModelOneHundred.addActionListener(this);
        radModelOneTen.addActionListener(this);
        radModelTwoHundred.addActionListener(this);

        phonebg.add(radModelOneHundred);
        phonebg.add(radModelOneTen);
        phonebg.add(radModelTwoHundred);

        phone.add(radModelOneHundred);
        phone.add(radModelOneTen);
        phone.add(radModelTwoHundred);

        //code for options
        JMenu options = new JMenu("Options");
        chkVoiceMail = new JCheckBoxMenuItem("Voice Mail ($5.00)", false);
        chkText = new JCheckBoxMenuItem("Text Messaging ($10.00)", false);

        chkVoiceMail.setMnemonic('v');
        chkText.setMnemonic('t');

        chkVoiceMail.addActionListener(this);
        chkText.addActionListener(this);

        options.add(chkVoiceMail);
        options.add(chkText);

        file.setMnemonic('f');
        packages.setMnemonic('p');
        phone.setMnemonic('h');
        options.setMnemonic('o');

        // Add to the menu bar.
        mb.add(file);
        mb.add(packages);
        mb.add(phone);
        mb.add(options);
        // set the menu bar.
        this.setJMenuBar(mb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exit) {
            dispose();
            /* Reset is called either when the program is started up or the user presses it. The program will call this
             upon starting to set all values to default and letting the user see them. It does this by first setting the radio buttons to the 
             first option and then the two check boxes to false. This will set them to default but won't be visible to the user. So to get around this
             I call the doClick method of radThreeHundred minutes which is the first radio button of the packages group. This causes it to go through
             the "else" of the actionPerformed event which sets the visibility. 
             */
        } else if (e.getSource() == reset) {
            radThreeHundredMinutes.setSelected(true);
            radModelOneHundred.setSelected(true);
            chkText.setSelected(false);
            chkVoiceMail.setSelected(false);
            radThreeHundredMinutes.doClick();
            // calculates and shows the user the price
        } else {
            double packagePrice = 0;
            double phonePrice = 0;
            double optionsPrice = 0;

            packagePrice += (radThreeHundredMinutes.isSelected()) ? 45 : 0;
            packagePrice += (radEightHundredMinutes.isSelected()) ? 65 : 0;
            packagePrice += (radFifteenHundredMinutes.isSelected()) ? 99 : 0;

            txtPackage.setText(getCurrencyInstance().format(packagePrice) + " per Month");

            phonePrice += (radModelOneHundred.isSelected()) ? 29.95 : 0;
            phonePrice += (radModelOneTen.isSelected()) ? 49.95 : 0;
            phonePrice += (radModelTwoHundred.isSelected()) ? 99.95 : 0;

            txtPhone.setText(getCurrencyInstance().format(phonePrice));

            optionsPrice += (chkText.isSelected()) ? 10 : 0;
            optionsPrice += (chkVoiceMail.isSelected()) ? 5 : 0;

            txtOptions.setText(getCurrencyInstance().format(optionsPrice));
        }

    }

    public static void main(String[] args) {

        CellPhonePackages2 window = new CellPhonePackages2();

    }

}
