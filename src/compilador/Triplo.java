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
import java.util.ArrayList;

public class Triplo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	int fila =0;
	String nombreFuncion;
	String retornoFuncion;
	
	ArrayList<String> funcDec = new ArrayList<String>();
	ArrayList<String> argFuncDec = new ArrayList<String>();
	ArrayList<String> funcInv = new ArrayList<String>();
	ArrayList<String> argFuncInv = new ArrayList<String>();
	ArrayList<Integer> filasVacias = new ArrayList<Integer>();
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
	public void funDec(String func) {
		String arr [];
		arr=func.split(" ");
		String lexema;
		funcDec.clear();
		argFuncDec.clear();
		for (int i =0;i<arr.length;i++) {
			lexema=arr[i];
			if(lexema.matches("^[#|@|a-z][a-z|A-Z|0-9]{1,}$")) {
				argFuncDec.add(lexema);
			}
		}
		funcDec.add(argFuncDec.get(0));
		argFuncDec.remove(0);
	}
	public String funInv(String func) {
		String arr [];
		arr=func.split(" ");
		String lexema;
		String operacion="";
		funcInv.clear();
		argFuncInv.clear();
		for (int i =0;i<arr.length;i++) {
			lexema=arr[i];
			if(lexema.matches("^[#|@|a-z][a-z|A-Z|0-9]{1,}$")) {
				argFuncInv.add(lexema);
			}
		}
		funcInv.add(argFuncInv.get(1));
		operacion = argFuncInv.get(0)+" = "+argFuncInv.get(1);
		argFuncInv.remove(0);
		argFuncInv.remove(0);
		return operacion;
	}
	public void generarTriplo(String codigo,ArrayList<String> retornoFunciones) {
		char caracter;
		String asignacion = "";
		String operacion []= new String [6];
		for (int i = 0; i < codigo.length(); i++) {
			caracter = codigo.charAt(i);
			if (caracter != '\n') {
				asignacion = asignacion + caracter;
			} else {
				//System.out.println(asignacion);
				if (asignacion.contains("=") && !asignacion.contains("(")) {
					operacion=asignacion.split(" ");
					addTablaTriplo(operacion);
				}else if(asignacion.contains("(") && !asignacion.contains("=")) {
					funDec(asignacion);
					crearFilaTabla(" ", " ", "JMP");
				}else if(asignacion.contains("return")){
					crearFilaTabla("", "", "JMP");
				}else if (asignacion.contains("=") && asignacion.contains("(")) {
					retornoFuncion=retornoFunciones.get(0);
					String cadena=funInv(asignacion);
					operacion=cadena.split(" ");
					nombreFuncion=funcInv.get(0);
					if(argFuncDec.isEmpty()) {
						crearFilaTabla(" ", " ", "JMP");
						addTablaTriplo(operacion);
					}else {
						addTablaTriplo(operacion);
					}
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
		if(opa.length<=4) {
			variable=opa[0];
			asignacion=opa[1];
			temporal=opa[2];
			if(temporal.equals(nombreFuncion)&&argFuncDec.isEmpty()) {
				crearFilaTabla(T1, retornoFuncion, asignacion);
				crearFilaTabla(variable, T1, asignacion);
			}else if(temporal.equals(nombreFuncion)&&!argFuncDec.isEmpty()) {
				for(int j=0;j<argFuncDec.size();j++) {
					variable=argFuncDec.get(j);
					temporal=argFuncInv.get(j);
					crearFilaTabla(T1, temporal, asignacion);
					crearFilaTabla(variable, T1, asignacion);
				}
				variable=opa[0];
				crearFilaTabla(" ", " ", "JMP");
				crearFilaTabla(T1, retornoFuncion, asignacion);
				crearFilaTabla(variable, T1, asignacion);
			}else {
				crearFilaTabla(T1,temporal,asignacion);
				crearFilaTabla(variable,T1,asignacion);
			}
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
	public void addJMP() {
		int contFilas=0;
		for(int i=0;i<table.getRowCount();i++) {
			if(table.getValueAt(i, 2).equals("JMP")) {
				filasVacias.add(i);
			}
		}
		for(int i=0;i<table.getRowCount();i++) {
			if(table.getValueAt(i, 2).equals("JMP") && i==filasVacias.get(contFilas)) {
				if(contFilas<filasVacias.size()-1) {
					table.setValueAt(filasVacias.get(contFilas+1)+2, i, 1);
					contFilas++;
				}else {
					table.setValueAt(filasVacias.get(0)+2,i,1);
				}
			}
		}
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
