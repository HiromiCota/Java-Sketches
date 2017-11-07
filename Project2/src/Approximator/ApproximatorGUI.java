package Approximator;

import static Approximator.Approximator.*;
import java.awt.Toolkit;
import java.text.DecimalFormat;

/**
 * File: ApproximatorGUI.java Creates a GUI that will accept user input and
 * approximate e or pi to a high degree of precision, calculate the precision
 * and runtime, and output.
 *
 * DEPENDENCIES! About.java (modal About form) PrintUtilities (print interface)
 * Splash.java (modal splash screen) Approximator.java (Math package) ePic.jpg,
 * piIcon.jpg, piPic.jpg (image binaries)
 *
 * @author Hiromi Cota
 */
public class ApproximatorGUI extends javax.swing.JFrame {

    final int SLIDER_DEFAULT = 500000;
    final DecimalFormat PERCENT = new DecimalFormat("#00.00000000000000000000%");
    final DecimalFormat TIME = new DecimalFormat("###,###,###,###,000");

    /**
     * ApproximatorGUI default constructor Sets Enter shortcut as calcjButton
     * Assigns window icon Launches splash screen Sets default values
     */
    public ApproximatorGUI() {
        initComponents();
        this.getRootPane().setDefaultButton(calcjButton);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Approximator/piIcon.jpg"));
        Splash splash = new Splash(this, true);
        splash.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        splash.setVisible(true);
        ejRadioButton.setSelected(true);
        precisionjSlider.setValue(SLIDER_DEFAULT);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menubuttonGroup = new javax.swing.ButtonGroup();
        guibuttonGroup = new javax.swing.ButtonGroup();
        buttonjPanel = new javax.swing.JPanel();
        calcjButton = new javax.swing.JButton();
        clearjButton = new javax.swing.JButton();
        printjButton = new javax.swing.JButton();
        quitjButton = new javax.swing.JButton();
        inputjPanel = new javax.swing.JPanel();
        precisionjSlider = new javax.swing.JSlider();
        precisionjLabel = new javax.swing.JLabel();
        selectorjPanel = new javax.swing.JPanel();
        ejRadioButton = new javax.swing.JRadioButton();
        pijRadioButton = new javax.swing.JRadioButton();
        outputjLabel = new javax.swing.JLabel();
        output1jTextField = new javax.swing.JTextField();
        output2jTextField = new javax.swing.JTextField();
        output1jLabel = new javax.swing.JLabel();
        output2jLabel = new javax.swing.JLabel();
        statsjPanel = new javax.swing.JPanel();
        errorjLabel = new javax.swing.JLabel();
        errorjTextField = new javax.swing.JTextField();
        timejLabel = new javax.swing.JLabel();
        timejTextField = new javax.swing.JTextField();
        titlejPanel = new javax.swing.JPanel();
        icon1jLabel = new javax.swing.JLabel();
        icon2jLabel = new javax.swing.JLabel();
        titlejLabel = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        filejMenu = new javax.swing.JMenu();
        clearjMenuItem = new javax.swing.JMenuItem();
        printjMenuItem = new javax.swing.JMenuItem();
        filejSeparator = new javax.swing.JPopupMenu.Separator();
        exitjMenuItem = new javax.swing.JMenuItem();
        approxjMenu = new javax.swing.JMenu();
        calcjMenuItem = new javax.swing.JMenuItem();
        approxjSeparator = new javax.swing.JPopupMenu.Separator();
        ejRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        pijRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        helpjMenu = new javax.swing.JMenu();
        aboutjMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonjPanel.setLayout(new java.awt.GridLayout(1, 4));

        calcjButton.setText("Calculate");
        calcjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcjButtonActionPerformed(evt);
            }
        });
        buttonjPanel.add(calcjButton);

        clearjButton.setText("Clear");
        clearjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearjButtonActionPerformed(evt);
            }
        });
        buttonjPanel.add(clearjButton);

        printjButton.setText("Print");
        printjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printjButtonActionPerformed(evt);
            }
        });
        buttonjPanel.add(printjButton);

        quitjButton.setText("Quit");
        quitjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitjButtonActionPerformed(evt);
            }
        });
        buttonjPanel.add(quitjButton);

        inputjPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        precisionjSlider.setMaximum(1000000);
        precisionjSlider.setMinimum(1);
        precisionjSlider.setMinorTickSpacing(10000);
        precisionjSlider.setSnapToTicks(true);
        precisionjSlider.setToolTipText("");

        precisionjLabel.setText("Select calculation precision:");

        javax.swing.GroupLayout inputjPanelLayout = new javax.swing.GroupLayout(inputjPanel);
        inputjPanel.setLayout(inputjPanelLayout);
        inputjPanelLayout.setHorizontalGroup(
            inputjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(precisionjLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(precisionjSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        inputjPanelLayout.setVerticalGroup(
            inputjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputjPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(inputjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(precisionjSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precisionjLabel))
                .addGap(34, 34, 34))
        );

        selectorjPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        guibuttonGroup.add(ejRadioButton);
        ejRadioButton.setText("e");

        guibuttonGroup.add(pijRadioButton);
        pijRadioButton.setText("pi");

        output1jTextField.setEditable(false);

        output2jTextField.setEditable(false);

        output1jLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        output2jLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout selectorjPanelLayout = new javax.swing.GroupLayout(selectorjPanel);
        selectorjPanel.setLayout(selectorjPanelLayout);
        selectorjPanelLayout.setHorizontalGroup(
            selectorjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectorjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectorjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(selectorjPanelLayout.createSequentialGroup()
                        .addComponent(pijRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(output2jLabel))
                    .addGroup(selectorjPanelLayout.createSequentialGroup()
                        .addComponent(ejRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(output1jLabel)))
                .addGap(10, 10, 10)
                .addGroup(selectorjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(output1jTextField)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectorjPanelLayout.createSequentialGroup()
                        .addComponent(outputjLabel)
                        .addGap(63, 63, 63))
                    .addComponent(output2jTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                .addContainerGap())
        );
        selectorjPanelLayout.setVerticalGroup(
            selectorjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectorjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectorjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ejRadioButton)
                    .addComponent(output1jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(output1jLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(selectorjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pijRadioButton)
                    .addComponent(outputjLabel)
                    .addComponent(output2jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(output2jLabel))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        statsjPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        statsjPanel.setLayout(new java.awt.GridLayout(2, 2));

        errorjLabel.setText("Relative error in approximation:");
        errorjLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        statsjPanel.add(errorjLabel);

        errorjTextField.setEditable(false);
        statsjPanel.add(errorjTextField);

        timejLabel.setText("Time of execution (in nanoseconds):");
        timejLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        statsjPanel.add(timejLabel);

        timejTextField.setEditable(false);
        statsjPanel.add(timejTextField);

        titlejPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        icon1jLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Approximator/piPic.jpg"))); // NOI18N

        icon2jLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        icon2jLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Approximator/ePic.jpg"))); // NOI18N

        titlejLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titlejLabel.setText("Approximation of pi and e");

        javax.swing.GroupLayout titlejPanelLayout = new javax.swing.GroupLayout(titlejPanel);
        titlejPanel.setLayout(titlejPanelLayout);
        titlejPanelLayout.setHorizontalGroup(
            titlejPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlejPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icon1jLabel)
                .addGap(18, 18, 18)
                .addComponent(titlejLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon2jLabel)
                .addContainerGap())
        );
        titlejPanelLayout.setVerticalGroup(
            titlejPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlejPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(titlejPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(icon1jLabel)
                    .addComponent(icon2jLabel)
                    .addComponent(titlejLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        filejMenu.setText("File");

        clearjMenuItem.setMnemonic('C');
        clearjMenuItem.setText("Clear");
        clearjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearjMenuItemActionPerformed(evt);
            }
        });
        filejMenu.add(clearjMenuItem);

        printjMenuItem.setMnemonic('P');
        printjMenuItem.setText("Print");
        printjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printjMenuItemActionPerformed(evt);
            }
        });
        filejMenu.add(printjMenuItem);
        filejMenu.add(filejSeparator);

        exitjMenuItem.setMnemonic('X');
        exitjMenuItem.setText("Exit");
        exitjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitjMenuItemActionPerformed(evt);
            }
        });
        filejMenu.add(exitjMenuItem);

        jMenuBar.add(filejMenu);

        approxjMenu.setText("Approximation");

        calcjMenuItem.setText("Calculate");
        calcjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcjMenuItemActionPerformed(evt);
            }
        });
        approxjMenu.add(calcjMenuItem);
        approxjMenu.add(approxjSeparator);

        menubuttonGroup.add(ejRadioButtonMenuItem);
        ejRadioButtonMenuItem.setSelected(true);
        ejRadioButtonMenuItem.setText("Solve for e");
        approxjMenu.add(ejRadioButtonMenuItem);

        menubuttonGroup.add(pijRadioButtonMenuItem);
        pijRadioButtonMenuItem.setText("Solve for pi");
        approxjMenu.add(pijRadioButtonMenuItem);

        jMenuBar.add(approxjMenu);

        helpjMenu.setMnemonic('H');
        helpjMenu.setText("Help");

        aboutjMenuItem.setMnemonic('A');
        aboutjMenuItem.setText("About");
        aboutjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutjMenuItemActionPerformed(evt);
            }
        });
        helpjMenu.add(aboutjMenuItem);

        jMenuBar.add(helpjMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(statsjPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                            .addComponent(selectorjPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputjPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titlejPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlejPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectorjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statsjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Function: calcjButtonActionPerformed()
     *
     * @author: Hiromi Cota Gets precision from GUI Triggers calcE() or
     * calcPi(), depending on user input
     *
     * Dependencies: calcE() calcPi()
     *
     */
    private void calcjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcjButtonActionPerformed
        // Threads from previous executions may not have timed out.
        // CALL GARBAGE COLLECTION NOW!
        System.gc();
        // Get requested precision
        int terms;
        terms = precisionjSlider.getValue();
        //Clear the labels every time values are potentially changed.
        clearLabels();
        // Which constant is being approximated?
        if (ejRadioButton.isSelected()) {
            calcE(terms);
        } else if (pijRadioButton.isSelected()) {// Trigger pi approximation
            calcPi(terms);
        } else {
            // Yell at user
        }
    }//GEN-LAST:event_calcjButtonActionPerformed

    /**
     * Function: calcPi()
     *
     * @author: Hiromi Cota Calculates pi based on provided input and records
     * runtime.
     *
     * Dependencies: calcPiGL() flipFlopPi()
     * @param precision
     *
     */
    private void calcPi(int precision) {
        long start = System.nanoTime();
        double GL = calcPiGL(precision);
        long stop = System.nanoTime();
        long time = (stop - start);
        double flip = flipFlopPi(precision);

        setLabels("pi");
        timejTextField.setText(TIME.format(time));
        output1jTextField.setText("" + GL);
        output2jTextField.setText("" + flip);
        errorjTextField.setText("" + PERCENT.format(Math.abs(Math.PI - GL)));
    }

    /**
     * Function: calcE()
     *
     * @author: Hiromi Cota Calculates e and records runtime.
     *
     * Dependencies: calcEFactorial()
     * @param precision
     */
    private void calcE(int precision) {
        clearLabels();
        long start = System.nanoTime();
        double factorial = calcEFactorial(precision);
        long stop = System.nanoTime();
        long time = (stop - start);

        System.out.println("" + precision);

        setLabels("e");

        output1jTextField.setText("" + factorial);
        timejTextField.setText(TIME.format(time));
        errorjTextField.setText("" + PERCENT.format(Math.abs(Math.E - factorial)));
    }

    /**
     * Function: setLabels()
     *
     * @author: Hiromi Cota Sets output labels to to reflect the functions being
     * invoked
     *
     * WARNING: Type names are hardcoded!
     *
     * @param type
     */
    private void setLabels(String type) {
        //Set the labels for the output fields
        clearLabels(); //This shouldn't be necessary, but I trust nothing.
        if (type.equalsIgnoreCase("pi")) {
            output1jLabel.setText("Via Gregory-Leibniz formula: ");
            output2jLabel.setText("Via other formula: ");
        } else if (type.equalsIgnoreCase("e")) {
            output1jLabel.setText("Via Gregory-Leibniz formula: ");
            //output2jLabel.setText("Via formula 2: ");
        }
    }

    /**
     * Function: clearLabels()
     *
     * @author: Hiromi Cota Clears labels.
     */
    private void clearLabels() {
        output1jLabel.setText("");
        output2jLabel.setText("");
    }

    /**
     * Function: clearjButtonActionPerformed()
     *
     * @author: Hiromi Cota Sets values back to defaults. Blanks all text output
     * fields. Clears labels.
     *
     * Dependencies: clearLabels()
     */
    private void clearjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearjButtonActionPerformed
        // Reset values to defaults
        ejRadioButton.setSelected(true);
        precisionjSlider.setValue(SLIDER_DEFAULT);
        clearLabels();
        output1jTextField.setText("");
        output2jTextField.setText("");
        errorjTextField.setText("");
        timejTextField.setText("");
    }//GEN-LAST:event_clearjButtonActionPerformed

    /**
     * Function: printjButtonActionPerformed()
     *
     * @author: Hiromi Cota Invokes PrintUtilities constructor and calls print()
     * method
     *
     * Dependencies: PrintUtilities class
     */
    private void printjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printjButtonActionPerformed
        // Call PrintUtilities
        PrintUtilities printThis = new PrintUtilities(this);
        printThis.print();
    }//GEN-LAST:event_printjButtonActionPerformed

    /**
     * Function: quitjButtonActionPerformed()
     *
     * @author: Hiromi Cota Quits.
     */
    private void quitjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitjButtonActionPerformed
        // Quit out
        System.exit(0);
    }//GEN-LAST:event_quitjButtonActionPerformed

    /**
     * Function: calcjMenuItemActionPerformed()
     *
     * @author: Hiromi Cota Handles calc trigger from menu
     *
     * Dependencies: calcjButtonActionPerformed() (implicit call)
     */
    private void calcjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcjMenuItemActionPerformed
        // Trigger calc
        calcjButton.doClick();
    }//GEN-LAST:event_calcjMenuItemActionPerformed

    /**
     * Function: clearjMenuItemActionPerformed()
     *
     * @author: Hiromi Cota Handles clear trigger from menu
     *
     * Dependencies: clearjButtonActionPerformed() (implicit call)
     */
    private void clearjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearjMenuItemActionPerformed
        // Trigger clear
        clearjButton.doClick();
    }//GEN-LAST:event_clearjMenuItemActionPerformed

    /**
     * Function: printjMenuItemActionPerformed()
     *
     * @author: Hiromi Cota handles print trigger from menu
     *
     * Dependencies: printjButtonActionPerformed() (implicit call)
     */
    private void printjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printjMenuItemActionPerformed
        // Trigger print
        printjButton.doClick();
    }//GEN-LAST:event_printjMenuItemActionPerformed

    /**
     * Function: exitjMenuItemActionPerformed
     *
     * @author: Hiromi Cota Handles exit trigger from menu
     *
     * Dependencies: quitjButtonActionPerformed() (implicit call)
     */
    private void exitjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitjMenuItemActionPerformed
        // Trigger exit
        quitjButton.doClick();
    }//GEN-LAST:event_exitjMenuItemActionPerformed

    /**
     * Function: aboutjMenuItemActionPerformed()
     *
     * @author: Hiromi Cota Handles about trigger from menu. Constructs new
     * About form and displays it.
     *
     * Dependencies: About class
     */
    private void aboutjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutjMenuItemActionPerformed
        // TODO add your handling code here:
        About about = new About(this, true);
        about.setLocationRelativeTo(null);
        about.setVisible(true);
    }//GEN-LAST:event_aboutjMenuItemActionPerformed

    /**
     * Function: main()
     *
     * @author: Hiromi Cota Constructs ApproximatorGUI and displays it.
     *
     * Dependencies: ApproximatorGUI constructor
     * @param args
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ApproximatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApproximatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApproximatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApproximatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApproximatorGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutjMenuItem;
    private javax.swing.JMenu approxjMenu;
    private javax.swing.JPopupMenu.Separator approxjSeparator;
    private javax.swing.JPanel buttonjPanel;
    private javax.swing.JButton calcjButton;
    private javax.swing.JMenuItem calcjMenuItem;
    private javax.swing.JButton clearjButton;
    private javax.swing.JMenuItem clearjMenuItem;
    private javax.swing.JRadioButton ejRadioButton;
    private javax.swing.JRadioButtonMenuItem ejRadioButtonMenuItem;
    private javax.swing.JLabel errorjLabel;
    private javax.swing.JTextField errorjTextField;
    private javax.swing.JMenuItem exitjMenuItem;
    private javax.swing.JMenu filejMenu;
    private javax.swing.JPopupMenu.Separator filejSeparator;
    private javax.swing.ButtonGroup guibuttonGroup;
    private javax.swing.JMenu helpjMenu;
    private javax.swing.JLabel icon1jLabel;
    private javax.swing.JLabel icon2jLabel;
    private javax.swing.JPanel inputjPanel;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.ButtonGroup menubuttonGroup;
    private javax.swing.JLabel output1jLabel;
    private javax.swing.JTextField output1jTextField;
    private javax.swing.JLabel output2jLabel;
    private javax.swing.JTextField output2jTextField;
    private javax.swing.JLabel outputjLabel;
    private javax.swing.JRadioButton pijRadioButton;
    private javax.swing.JRadioButtonMenuItem pijRadioButtonMenuItem;
    private javax.swing.JLabel precisionjLabel;
    private javax.swing.JSlider precisionjSlider;
    private javax.swing.JButton printjButton;
    private javax.swing.JMenuItem printjMenuItem;
    private javax.swing.JButton quitjButton;
    private javax.swing.JPanel selectorjPanel;
    private javax.swing.JPanel statsjPanel;
    private javax.swing.JLabel timejLabel;
    private javax.swing.JTextField timejTextField;
    private javax.swing.JLabel titlejLabel;
    private javax.swing.JPanel titlejPanel;
    // End of variables declaration//GEN-END:variables
}
