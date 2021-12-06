package psp_t3_55124290y_servidor;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class interfaz_servidor extends javax.swing.JFrame {

    servidor socketServidor;

    public interfaz_servidor() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaConsola = new javax.swing.JTextArea();
        txtMensaje = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        btnArrancarServidor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtPuerto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtStockInicial = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAreaConsola.setColumns(20);
        txtAreaConsola.setRows(5);
        jScrollPane1.setViewportView(txtAreaConsola);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 62, 386, 199));
        getContentPane().add(txtMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 268, 358, -1));

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 297, 164, 33));

        btnArrancarServidor.setText("Arrancar servidor");
        btnArrancarServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArrancarServidorActionPerformed(evt);
            }
        });
        getContentPane().add(btnArrancarServidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 19, 324, -1));

        jLabel1.setText("Puerto:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 78, -1, -1));
        getContentPane().add(txtPuerto, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 75, 51, -1));

        jLabel2.setText("Stock inicial:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 118, -1, -1));
        getContentPane().add(txtStockInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 51, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        socketServidor.enviar(this.txtMensaje.getText());
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnArrancarServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArrancarServidorActionPerformed
        String puerto = this.txtPuerto.getText().trim();
        String stockInicial = this.txtStockInicial.getText().trim();

        if (!puerto.equals("") && !stockInicial.equals("")) {
            socketServidor = new servidor(this.txtAreaConsola, Integer.parseInt(puerto));
            socketServidor.start();
            
            socketServidor.setStock(Integer.parseInt(stockInicial));
        } else {
            JOptionPane.showMessageDialog(this, "Debe indicar un PUERTO y el STOCK INICAL para iniciar el servidor.", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnArrancarServidorActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(interfaz_servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaz_servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaz_servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaz_servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz_servidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArrancarServidor;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaConsola;
    private javax.swing.JTextField txtMensaje;
    private javax.swing.JTextField txtPuerto;
    private javax.swing.JTextField txtStockInicial;
    // End of variables declaration//GEN-END:variables
}
