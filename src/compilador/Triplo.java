package compilador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;

public class Triplo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	int fila =0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Triplo frame = new Triplo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void generarTriplo(String codigo) {
		char caracter;
		String asignacion = "";
		String operacion []= new String [6];
		for (int i = 0; i < codigo.length(); i++) {
			caracter = codigo.charAt(i);
			if (caracter != '\n') {
				asignacion = asignacion + caracter;
			} else {
				if (asignacion.contains("=")) {
					operacion=asignacion.split(" ");
					addTablaTriplo(operacion);
				}else if(asignacion.contains("(")) {
					crearFilaTabla(" ", " ", "JMP");
				}else if(asignacion.contains("return")){
					crearFilaTabla("", "", "JMP");
				}
				asignacion = "";
			}
		}
		
	}
	/**
	 * @param opa
	 */
	public void addTablaTriplo(String opa[]) {
		String variable;
		String asignacion;
		String temporal;
		String operacion;
		String dato;
		String T1="T1";
		if(opa.length==4) {
			variable=opa[0];
			asignacion=opa[1];
			temporal=opa[2];
			crearFilaTabla(T1,temporal,asignacion);
			crearFilaTabla(variable,T1,asignacion);
		}else{
			variable=opa[0];
			asignacion=opa[1];
			temporal=opa[2];
			operacion = opa[3];
			dato = opa [4];
			crearFilaTabla(T1,temporal,asignacion);
			crearFilaTabla(T1,dato,operacion);
			crearFilaTabla(variable,T1,asignacion);
		}
	}
	public void crearFilaTabla(String datoObjeto,String datoFuente, String operador) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[]{"DATO OBJETO", "DATO FUENTE", "OPERADOR"});
		table.setValueAt(datoObjeto, fila, 0);
		table.setValueAt(datoFuente, fila, 1);
		table.setValueAt(operador, fila, 2);
		fila++;
	}
	public Triplo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 923, 511);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 55, 540, 427);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DATO OBJETO", "DATO FUENTE", "OPERADOR"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(98);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(101);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(95);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("TRIPLO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(416, 30, 80, 13);
		panel.add(lblNewLabel);
	}
}
