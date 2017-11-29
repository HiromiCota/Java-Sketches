package Movie;

import java.awt.Toolkit;

/**
 * class About Description: Modal About screen 
 *
 * Contains extensions/overrides for Task Overrides propertyChange Overrides
 * actionPerformed
 * 
 * WARNING: NO main()! MUST BE INVOKED BY ANOTHER CLASS!
 *
 * @author Hiromi Cota
 */
public class About extends javax.swing.JDialog {

    /**
     * About default constructor
     * Sets icon
     */
    public About(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Approximator/piIcon.jpg"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundjPanel = new javax.swing.JPanel();
        textjScrollPane = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        iconsjPanel = new javax.swing.JPanel();
        piIconjLabel = new javax.swing.JLabel();
        eIconjLabel = new javax.swing.JLabel();
        OKjButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        backgroundjPanel.setBackground(new java.awt.Color(153, 255, 0));

        jTextArea.setEditable(false);
        jTextArea.setColumns(20);
        jTextArea.setLineWrap(true);
        jTextArea.setRows(5);
        jTextArea.setText("The ANC 9,000!\n\nCreated by Over 9,000 Studios,\nthe ANC 9,000 loads a theater's films, showtimes, and transaction history from external XML files. \n\nIn case of data loss, The ANC 9,000 can also be used to create new XML files.\n\n\nCopyright 2017\nNot to be used for evil.");
        jTextArea.setWrapStyleWord(true);
        textjScrollPane.setViewportView(jTextArea);

        iconsjPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        iconsjPanel.setLayout(new java.awt.GridLayout(2, 2));

        piIconjLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        piIconjLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Approximator/piPic.jpg"))); // NOI18N
        iconsjPanel.add(piIconjLabel);

        eIconjLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eIconjLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Approximator/ePic.jpg"))); // NOI18N
        iconsjPanel.add(eIconjLabel);

        OKjButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        OKjButton.setText("OK");
        OKjButton.setToolTipText("Click OK to close");
        OKjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundjPanelLayout = new javax.swing.GroupLayout(backgroundjPanel);
        backgroundjPanel.setLayout(backgroundjPanelLayout);
        backgroundjPanelLayout.setHorizontalGroup(
            backgroundjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconsjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textjScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(backgroundjPanelLayout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(OKjButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundjPanelLayout.setVerticalGroup(
            backgroundjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textjScrollPane)
                    .addComponent(iconsjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(OKjButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
    * Function: OKjButtonActionPerformed()
    * @author: Hiromi Cota
    * Disposes this form    
    */
    private void OKjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKjButtonActionPerformed
        // Dispose of this dialog
        this.dispose();
    }//GEN-LAST:event_OKjButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OKjButton;
    private javax.swing.JPanel backgroundjPanel;
    private javax.swing.JLabel eIconjLabel;
    private javax.swing.JPanel iconsjPanel;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JLabel piIconjLabel;
    private javax.swing.JScrollPane textjScrollPane;
    // End of variables declaration//GEN-END:variables
}
