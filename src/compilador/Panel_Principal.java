
package compilador;
import java.util.ArrayList;

public class Panel_Principal extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	ArrayList<String> lexema = new ArrayList<String>();
	public Panel_Principal() {
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jLabel1 = new javax.swing.JLabel();
		Btn_Analizar = new javax.swing.JButton();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jLabel1.setText("ENTRADA DE DATOS");

		Btn_Analizar.setText("ANALIZAR");
		Btn_Analizar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_AnalizarActionPerformed(evt);
			}
		});

		jTable2.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { 
						{ null, null, null }, 
						{ null, null, null }, 
						{ null, null, null }, 
						{ null, null, null },
						{ null, null, null }, 
						{ null, null, null }, 
						{ null, null, null }, 
						{ null, null, null },
						{ null, null, null }, 
						{ null, null, null }, 
						{ null, null, null }, 
						{ null, null, null },
						{ null, null, null }, 
						{ null, null, null }, 
						{ null, null, null }, 
						{ null, null, null },
						{ null, null, null }, 
						{ null, null, null },
						{ null, null, null }, 
						{ null, null, null },
						{ null, null, null }, 
						{ null, null, null }, 
						{ null, null, null }, 
						{ null, null, null } },
			new String[] { "LEXEMA", "TIPO DATO", "VALOR" }) {
			
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
			
		});
		jTable2.setShowGrid(true);
		jScrollPane3.setViewportView(jTable2);
		if (jTable2.getColumnModel().getColumnCount() > 0) {
			jTable2.getColumnModel().getColumn(0).setResizable(false);
			jTable2.getColumnModel().getColumn(1).setResizable(false);
			jTable2.getColumnModel().getColumn(2).setResizable(false);
		}

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(17, 17, 17)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
						.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18))
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout.createSequentialGroup().addGap(396, 396, 396).addComponent(Btn_Analizar))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(121, 121, 121).addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup().addGap(29, 29, 29).addComponent(jLabel1)
								.addGap(18, 18, 18)
								.addGroup(jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 423,
												Short.MAX_VALUE)
										.addComponent(jScrollPane1))
								.addGap(18, 18, 18).addComponent(Btn_Analizar).addContainerGap(18, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void Btn_AnalizarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Btn_AnalizarActionPerformed
		// TODO add your handling code here:
		String codigo;
		codigo = jTextArea1.getText();
		llenarLista(codigo);
		llenarTabla();
	}// GEN-LAST:event_Btn_AnalizarActionPerformed
	
	public void llenarLista(String codigo) {
		char caracter;
		String lexem="";
		lexema.clear();
		for(int i=0;i<codigo.length();i++) {
			caracter=codigo.charAt(i);
			if(caracter!=' ') {
				lexem=lexem+caracter;
				if(caracter==';') {
					if(lexema.contains(lexem)==false) lexema.add(lexem);
				}
			}else{
				if(lexema.isEmpty())lexema.add(lexem);
				if(lexema.contains(lexem)==false) lexema.add(lexem);
				lexem="";
			}
		}
	}
	
	public void llenarTabla() {
		int fila=0;
		for( fila=0;fila<lexema.size();fila++) {
			jTable2.setValueAt("", fila, 0);
		}
		for( fila=0;fila<lexema.size();fila++) {
			jTable2.setValueAt(lexema.get(fila), fila, 0);
		}
	}
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*s
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Panel_Principal.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Panel_Principal.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Panel_Principal.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Panel_Principal.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Panel_Principal().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton Btn_Analizar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTable jTable2;
	private javax.swing.JTextArea jTextArea1;
	// End of variables declaration//GEN-END:variables
}
