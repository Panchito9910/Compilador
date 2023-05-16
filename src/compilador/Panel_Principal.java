
package compilador;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel_Principal extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	ArrayList<String> lexema = new ArrayList<String>();
	ArrayList<String> enteros = new ArrayList<String>();
	ArrayList<String> reales = new ArrayList<String>();
	ArrayList<String> cadenas = new ArrayList<String>();
	ArrayList<String> funciones = new ArrayList<String>();
	ArrayList<String> argumentosFunciones = new ArrayList<String>();
	ArrayList<Integer> cantidadArgumentosFunciones = new ArrayList<Integer>();
	ArrayList<String> retornoFunciones = new ArrayList<String>();
	Triplo triplo = new Triplo();

	public Panel_Principal() {
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jPanel1.setBackground(new Color(240, 240, 240));
		scrollEntradaTexto = new javax.swing.JScrollPane();
		entradaTexto = new javax.swing.JTextArea();
		jLabel1 = new javax.swing.JLabel();
		Btn_Analizar = new javax.swing.JButton();
		scrollTablaLexemas = new javax.swing.JScrollPane();
		tablaLexemas = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		entradaTexto.setColumns(20);
		entradaTexto.setRows(5);
		scrollEntradaTexto.setViewportView(entradaTexto);

		jLabel1.setText("ENTRADA DE DATOS");

		Btn_Analizar.setText("ANALIZAR");
		Btn_Analizar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_AnalizarActionPerformed(evt);
			}
		});

		tablaLexemas
				.setModel(new DefaultTableModel(
						new Object[][] { { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, },
						new String[] { "LEXEMA", "TIPO DATO", "VALOR" }) {
					Class[] columnTypes = new Class[] { String.class, Object.class, Object.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
		tablaLexemas.setShowGrid(true);
		scrollTablaLexemas.setViewportView(tablaLexemas);
		if (tablaLexemas.getColumnModel().getColumnCount() > 0) {
			tablaLexemas.getColumnModel().getColumn(0).setResizable(false);
			tablaLexemas.getColumnModel().getColumn(1).setResizable(false);
			tablaLexemas.getColumnModel().getColumn(2).setResizable(false);
		}

		JLabel lblTablaLexemas = new JLabel("TABLA DE LEXEMAS");

		JScrollPane scrollTablaErrores = new JScrollPane();

		JLabel lblTablaErrores = new JLabel("TABLA DE ERRORES");

		JButton btnNewButton = new JButton("TRIPLO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo;
				codigo = entradaTexto.getText();
				triplo.generarTriplo(codigo, retornoFunciones);
				triplo.addJMP();
				triplo.generarCodEnsamblador();
				triplo.setVisible(true);
			}
		});

		JButton btnOptimizar = new JButton("Optimizar");
		btnOptimizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnEnsamblador = new JButton("Ensamblador");
		btnEnsamblador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(149)
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 448, Short.MAX_VALUE)
								.addComponent(
										lblTablaLexemas, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addGap(324))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(17).addGroup(jPanel1Layout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(
										jPanel1Layout.createSequentialGroup().addComponent(Btn_Analizar).addGap(32)
												.addComponent(btnOptimizar).addGap(57).addComponent(btnNewButton,
														GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
												.addGap(43).addComponent(btnEnsamblador).addGap(678))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(scrollEntradaTexto, GroupLayout.PREFERRED_SIZE, 387,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
												.addGroup(jPanel1Layout.createSequentialGroup().addGap(18)
														.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
																.addComponent(scrollTablaErrores, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
																.addComponent(scrollTablaLexemas, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE))
														.addContainerGap())
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblTablaErrores, GroupLayout.PREFERRED_SIZE, 127,
																GroupLayout.PREFERRED_SIZE)
														.addGap(298)))))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout
				.createSequentialGroup().addGap(29)
				.addGroup(jPanel1Layout
						.createParallelGroup(Alignment.BASELINE).addComponent(jLabel1).addComponent(lblTablaLexemas))
				.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollEntradaTexto, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addComponent(scrollTablaLexemas, GroupLayout.PREFERRED_SIZE, 153,
										GroupLayout.PREFERRED_SIZE)
								.addGap(19).addComponent(lblTablaErrores)
								.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
								.addComponent(scrollTablaErrores, GroupLayout.PREFERRED_SIZE, 144,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(53)
				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(Btn_Analizar)
						.addComponent(btnEnsamblador).addComponent(btnOptimizar)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addGap(26)));

		tablaErrores = new JTable();
		tablaErrores.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "Lexema", "Error", "Descripci\u00F3n", "L\u00EDnea" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablaErrores.getColumnModel().getColumn(0).setPreferredWidth(51);
		tablaErrores.getColumnModel().getColumn(1).setPreferredWidth(55);
		tablaErrores.getColumnModel().getColumn(2).setPreferredWidth(178);
		scrollTablaErrores.setViewportView(tablaErrores);
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 1154, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 527, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void Btn_AnalizarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Btn_AnalizarActionPerformed
		// TODO add your handling code here:
		String codigo;
		codigo = entradaTexto.getText();
		llenarLista(codigo);
		llenarColumnaLexema();
		analizarLexemas(codigo);
		llenarColumnaTipoDato();
		analizarErrores(codigo);

	}// GEN-LAST:event_Btn_AnalizarActionPerformed

	public void llenarLista(String codigo) {
		char caracter;
		String lexem = "";
		for (int fila = 0; fila < lexema.size(); fila++) {
			tablaLexemas.setValueAt("", fila, 0);
			tablaLexemas.setValueAt("", fila, 1);
			tablaLexemas.setValueAt("", fila, 2);
		}
		lexema.clear();
		for (int i = 0; i < codigo.length(); i++) {
			caracter = codigo.charAt(i);
			if (caracter != ' ' && caracter != '\n') {
				lexem = lexem + caracter;
			} else {
				if (!lexema.contains(lexem))
					lexema.add(lexem);
				lexem = "";
			}
		}
	}

	public void llenarColumnaLexema() {
		for (int fila = 0; fila < lexema.size(); fila++) {
			tablaLexemas.setValueAt(lexema.get(fila), fila, 0);
		}
	}

	public void analizarLexemas(String codigo) {
		char caracter;
		String tipoDeDato = "";
		String lexem = "";
		for (int i = 0; i < codigo.length(); i++) {
			caracter = codigo.charAt(i);
			if (caracter != ' ' && caracter != '\n') {
				lexem = lexem + caracter;
			} else {
				if (lexem.equals("$Entero") || lexem.equals("$Real") || lexem.equals("$Cadena"))
					tipoDeDato = lexem;
				analizarExpresionRegular(tipoDeDato, lexem);
				if (lexem.equals(";") || caracter == '\n') {
					tipoDeDato = "";
				}
				lexem = "";
			}
		}
	}

	public void analizarExpresionRegular(String tipoDeDato, String lexem) {
		/* Identificadores */
		if (lexem.matches("^[#|@|a-z][a-z|A-Z|0-9]{1,}$")) {
			if (tipoDeDato.equals("$Entero"))
				enteros.add(lexem);
			if (tipoDeDato.equals("$Real"))
				reales.add(lexem);
			if (tipoDeDato.equals("$Cadena"))
				cadenas.add(lexem);
		}
		/* Numeros enteros */
		if (lexem.matches("^[-][4][0-9]{1,}[4]|[4][0-9]{1,}[4]$")) {
			for (int fila = 0; fila < lexema.size(); fila++) {
				if (tipoDeDato.equals(lexema.get(fila)) || lexem.equals(lexema.get(fila))) {
					tablaLexemas.setValueAt("$Entero", fila, 1);
				}
			}
		}
		/* Numeros reales */
		if (lexem.matches("^[-][0-9]{1,}[.][4][0-9]{1,}[4]|[0-9]{1,}[.][4][0-9]{1,}[4]$")) {
			for (int fila = 0; fila < lexema.size(); fila++) {
				if (tipoDeDato.equals(lexema.get(fila)) || lexem.equals(lexema.get(fila))) {
					tablaLexemas.setValueAt("$Real", fila, 1);
				}
			}
		}
		/* Cadenas */
		if (lexem.matches("^[\"].{0,}[\"]$")) {
			for (int fila = 0; fila < lexema.size(); fila++) {
				if (tipoDeDato.equals(lexema.get(fila)) || lexem.equals(lexema.get(fila))) {
					tablaLexemas.setValueAt("$Cadena", fila, 1);
				}
			}
		}

	}

	public void llenarColumnaTipoDato() {
		for (int fila = 0; fila < enteros.size(); fila++) {
			if (lexema.contains(enteros.get(fila))) {
				tablaLexemas.setValueAt("$Entero", lexema.indexOf(enteros.get(fila)), 1);
			}
		}
		for (int fila = 0; fila < reales.size(); fila++) {
			if (lexema.contains(reales.get(fila))) {
				tablaLexemas.setValueAt("$Real", lexema.indexOf(reales.get(fila)), 1);
			}
		}
		for (int fila = 0; fila < cadenas.size(); fila++) {
			if (lexema.contains(cadenas.get(fila))) {
				tablaLexemas.setValueAt("$Cadena", lexema.indexOf(cadenas.get(fila)), 1);
			}
		}

	}

	public void analizarErrores(String codigo) {
		char caracter;
		String lexem = "";
		String error = "Error";
		String tipoError = "";
		String tipoDato = "";
		String tipoDatoAsignacion = "";
		String tipoDatoFuncion = "";
		String lexemaFuncion = "";
		String tipoDatoArgumento1 = "";
		String tipoDatoArgumento2 = "";

		int contadorErrores = 0;
		int contadorLinea = 1;
		int contadorFilaTablaErrores = 0;
		int fila = 0;
		int cantArgumentosFuncion = 0;
		int contArgumentos = 0;
		int contRetorno = 0;

		boolean asignacion = false;
		boolean funcion = false;
		boolean finArgumentos = false;
		boolean retorno = false;
		boolean funcionRepetida = false;

		funciones.clear();
		argumentosFunciones.clear();
		cantidadArgumentosFunciones.clear();
		retornoFunciones.clear();

		for (int i = 0; i < tablaErrores.getRowCount(); i++) {
			tablaErrores.setValueAt("", i, 0);// Coloca el lexema que da el error en la tabla de errores
			tablaErrores.setValueAt("", i, 1);// Columna Token de error
			tablaErrores.setValueAt("", i, 2);// Columna descripcion del error
			tablaErrores.setValueAt("", i, 3);// Linea de codigo donde esta el error
		}

		for (int i = 0; i < codigo.length(); i++) {
			caracter = codigo.charAt(i);
			if (caracter != ' ' && caracter != '\n') {
				lexem = lexem + caracter;
			} else if (caracter == '\n') {
				contadorLinea++;
				lexem = "";
			} else if (lexema.contains(lexem)) {
				fila = lexema.indexOf(lexem);// Devuelve el indice del lexem evaluado
				tipoDato = (String) tablaLexemas.getValueAt(fila, 1);// Obtiene el valor en la columna Tipo de Dato en
																		// la fila indicada

				if (lexem.matches("^[#|@|a-z][a-z|A-Z|0-9]{1,}$") && asignacion == false) {
					tipoDatoAsignacion = tipoDato;
				}
				if (lexem.matches("^[#|@|a-z][a-z|A-Z|0-9]{1,}$") && funcion == false) {
					tipoDatoFuncion = tipoDato;
					lexemaFuncion = lexem;
				}
				// Evalua si el lexema tiene un tipo de dato asignado, en caso de que no
				// entonces se añadira a
				// la tabla de errores
				if (!lexem.equals("$Entero") && !lexem.equals("$Real") && !lexem.equals("$Cadena") && !lexem.equals("=")
						&& !lexem.matches("^[(|)|{|}|,|;]$") && !lexem.matches("^[+|-|*|/|%]$")
						&& !lexem.equals("return")) {
					// Identificadores no declarados
					String algo = (String) tablaLexemas.getValueAt(lexema.indexOf(lexem), 1);
					if (algo == null) {
						contadorErrores++;
						tipoError = "Identificador no declarado";
						llenarTablaErrores(lexem, error, tipoError, contadorErrores, contadorFilaTablaErrores,
								contadorLinea);
						contadorFilaTablaErrores++;
					}
					// Error de retorno de funcion
					else if (asignacion && funciones.contains(lexem) && tipoDatoAsignacion != null) {
						String retornoFuncion = retornoFunciones.get(contRetorno);
						int algo2 = lexema.indexOf(retornoFuncion);
						tipoDato = (String) tablaLexemas.getValueAt(algo2, 1);
						contRetorno++;
						System.out.println(contRetorno);
						// Reglas de asignacion Entero a Entero
						if (tipoDatoAsignacion.equals("$Entero") && !tipoDato.equals("$Entero")) {
							contadorErrores++;
							tipoError = "Incompatibilidad de asignación $Entero";
							llenarTablaErrores(retornoFuncion, error, tipoError, contadorErrores,
									contadorFilaTablaErrores, contadorLinea);
							contadorFilaTablaErrores++;
						}
						// Reglas de asignacion de Real a Real o Real a Entero
						else if (tipoDatoAsignacion.equals("$Real")
								&& !(tipoDato.equals("$Real") || tipoDato.equals("$Entero"))) {
							contadorErrores++;
							tipoError = "Incompatibilidad de asignación $Real";
							llenarTablaErrores(retornoFuncion, error, tipoError, contadorErrores,
									contadorFilaTablaErrores, contadorLinea);
							contadorFilaTablaErrores++;
						}
						// Cadena a Cadena
						else if (tipoDatoAsignacion.equals("$Cadena") && !(tipoDato.equals("$Cadena"))) {
							contadorErrores++;
							tipoError = "Incompatibilidad de asignación $Cadena";
							llenarTablaErrores(retornoFuncion, error, tipoError, contadorErrores,
									contadorFilaTablaErrores, contadorLinea);
							contadorFilaTablaErrores++;
						}
						asignacion = false;
					} else if (asignacion && tipoDatoAsignacion != null) {
						// Reglas de asignacion Entero a Entero
						if (tipoDatoAsignacion.equals("$Entero") && !tipoDato.equals("$Entero")) {
							contadorErrores++;
							tipoError = "Incompatibilidad de asignación $Entero";
							llenarTablaErrores(lexem, error, tipoError, contadorErrores, contadorFilaTablaErrores,
									contadorLinea);
							contadorFilaTablaErrores++;
						} // Reglas de asignacion de Real a Real o Real a Entero
						else if (tipoDatoAsignacion.equals("$Real")
								&& !(tipoDato.equals("$Real") || tipoDato.equals("$Entero"))) {
							contadorErrores++;
							tipoError = "Incompatibilidad de asignación $Real";
							llenarTablaErrores(lexem, error, tipoError, contadorErrores, contadorFilaTablaErrores,
									contadorLinea);
							contadorFilaTablaErrores++;
						}
						// Cadena a Cadena
						else if (tipoDatoAsignacion.equals("$Cadena") && !(tipoDato.equals("$Cadena"))) {
							contadorErrores++;
							tipoError = "Incompatibilidad de asignación $Cadena";
							llenarTablaErrores(lexem, error, tipoError, contadorErrores, contadorFilaTablaErrores,
									contadorLinea);
							contadorFilaTablaErrores++;
						}
						asignacion = false;
					}
					// Error de funcion
					else if (funcion) {
						if (!finArgumentos && funcionRepetida == false) {
							if (!funciones.contains(lexemaFuncion)) {
								funciones.add(lexemaFuncion);
							}
							argumentosFunciones.add(lexem);
							cantidadArgumentosFunciones.add(0, cantArgumentosFuncion);
							cantArgumentosFuncion++;
						} else {
							cantArgumentosFuncion = 0;
						}
						if (retorno) {
							retornoFunciones.add(lexem);
							if (!tipoDatoFuncion.equals(tipoDato)) {
								contadorErrores++;
								tipoError = "Incompatibilidad de retorno de funcion";
								llenarTablaErrores(lexem, error, tipoError, contadorErrores, contadorFilaTablaErrores,
										contadorLinea);
								contadorFilaTablaErrores++;
							}
							retorno = false;
						}
						if (funcionRepetida) {
							// Error por argumentos de funcion
							if (contArgumentos < cantidadArgumentosFunciones.size()) {
								// argumentos de la funcion declarada
								tipoDatoArgumento1 = (String) tablaLexemas
										.getValueAt(lexema.indexOf(argumentosFunciones.get(contArgumentos)), 1);
								String arg1 = (String) tablaLexemas
										.getValueAt(lexema.indexOf(argumentosFunciones.get(contArgumentos)), 0);
								// argumentos de la funcion invocada
								tipoDatoArgumento2 = (String) tablaLexemas.getValueAt(lexema.indexOf(lexem), 1);
								String arg2 = (String) tablaLexemas.getValueAt(lexema.indexOf(lexem), 0);
								System.out.println(arg1 + tipoDatoArgumento1 + arg2 + tipoDatoArgumento2);
								if (arg2 == null) {
									contadorErrores++;
									tipoError = "Identificador no declarado";
									llenarTablaErrores(arg2, error, tipoError, contadorErrores,
											contadorFilaTablaErrores, contadorLinea);
									contadorFilaTablaErrores++;
									// Reglas de asignacion Entero a Entero
								} else if (arg1.equals("$Entero") && !arg2.equals("$Entero")) {
									contadorErrores++;
									tipoError = "Incompatibilidad de asignación $Entero";
									llenarTablaErrores(arg2, error, tipoError, contadorErrores,
											contadorFilaTablaErrores, contadorLinea);
									contadorFilaTablaErrores++;
								}
								// Reglas de asignacion de Real a Real o Real a Entero
								else if (arg1.equals("$Real") && !(arg2.equals("$Real") || arg2.equals("$Entero"))) {
									contadorErrores++;
									tipoError = "Incompatibilidad de asignación $Real";
									llenarTablaErrores(arg2, error, tipoError, contadorErrores,
											contadorFilaTablaErrores, contadorLinea);
									contadorFilaTablaErrores++;
								}
								// Cadena a Cadena
								else if (arg1.equals("$Cadena") && !(arg2.equals("$Cadena"))) {
									contadorErrores++;
									tipoError = "Incompatibilidad de asignación $Cadena";
									llenarTablaErrores(arg2, error, tipoError, contadorErrores,
											contadorFilaTablaErrores, contadorLinea);
									contadorFilaTablaErrores++;
								}
								contArgumentos++;
							} else {
								contArgumentos = 0;
								lexemaFuncion = "";
								funcion = false;
								funcionRepetida = false;
							}
						}
					}
					// Error de identificadores no declarados
					else if ((tipoDato == null || tipoDato == "")) {
						contadorErrores++;
						tipoError = "Identificador puede no estar declarado";
						llenarTablaErrores(lexem, error, tipoError, contadorErrores, contadorFilaTablaErrores,
								contadorLinea);
						contadorFilaTablaErrores++;
					}
				}
				// detectada asignacion
				if (lexem.equals("=")) {
					asignacion = true;
				}
				// detectada op aritmetica
				if (lexem.matches("^[+|-]$")) {
					asignacion = true;
				}
				// detectada funcion
				if (lexem.equals("(")) {
					funcion = true;
					finArgumentos = false;
				}
				if (funciones.contains(lexem)) {
					funcionRepetida = true;
				}
				if (lexem.equals(")")) {
					finArgumentos = true;
				}
				if (lexem.equals("return")) {
					retorno = true;
				}
				lexem = "";
			}
		}
	}

	public void llenarTablaErrores(String lexem, String error, String tipoError, int contadorErrores,
			int contadorFilaTablaErrores, int contadorLinea) {
		tablaErrores.setValueAt(lexem, contadorFilaTablaErrores, 0);// Coloca el lexema que da el error en la tabla de
																	// errores
		tablaErrores.setValueAt(error + contadorErrores, contadorFilaTablaErrores, 1);// Columna Token de error
		tablaErrores.setValueAt(tipoError, contadorFilaTablaErrores, 2);// Columna descripcion del error
		tablaErrores.setValueAt(contadorLinea, contadorFilaTablaErrores, 3);// Columna linea del error
	}

	public static void main(String args[]) {
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
	private javax.swing.JScrollPane scrollEntradaTexto;
	private javax.swing.JScrollPane scrollTablaLexemas;
	private javax.swing.JTable tablaLexemas;
	private javax.swing.JTextArea entradaTexto;
	private JTable tablaErrores;
}
