package main.kidneyAnalysesAgents.AgentsGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.kidneyAnalysesAgents.AgentsBehaviour.AgentAddAnalyses;

public class AgentAddAnalysesGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private AgentAddAnalyses agentAddAnalyses;

	private JFrame frmAddAnalyses;

	private JTextField txtGravity;
	private JTextField txtPh;
	private JTextField txtOsmo;
	private JTextField txtCond;
	private JTextField txtUreaConcentration;
	private JTextField txtCalciumConcentration;

	// Creaza aplicatia agentului de adaugare analize
	public AgentAddAnalysesGUI(AgentAddAnalyses aAddAnalyses) {
		super(aAddAnalyses.getLocalName());
		agentAddAnalyses = aAddAnalyses;
		initialize();
	}

	// Initializeaza continutul interfetei
	private void initialize() {
		frmAddAnalyses = new JFrame();
		frmAddAnalyses.setTitle("Add analyses");
		frmAddAnalyses.getContentPane().setBackground(Color.DARK_GRAY);
		frmAddAnalyses.setBounds(100, 100, 172, 353);
		frmAddAnalyses.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddAnalyses.getContentPane().setLayout(null);

		// Inchide agentul la inchiderea interfetei
		frmAddAnalyses.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				agentAddAnalyses.doDelete();
			}
		});

		txtGravity = new JTextField();
		txtGravity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtGravity.getText().toLowerCase().contains("gravity")) {
					txtGravity.setText("");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (txtGravity.getText().isEmpty()) {
					txtGravity.setText("Gravity");
				}
			}
		});
		txtGravity.setBackground(Color.BLACK);
		txtGravity.setForeground(Color.LIGHT_GRAY);
		txtGravity.setText("Gravity");
		txtGravity.setBounds(10, 11, 137, 20);
		txtGravity.setColumns(10);
		frmAddAnalyses.getContentPane().add(txtGravity);

		txtPh = new JTextField();
		txtPh.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtPh.getText().toLowerCase().contains("ph")) {
					txtPh.setText("");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (txtPh.getText().isEmpty()) {
					txtPh.setText("pH");
				}
			}
		});
		txtPh.setText("pH");
		txtPh.setForeground(Color.LIGHT_GRAY);
		txtPh.setColumns(10);
		txtPh.setBackground(Color.BLACK);
		txtPh.setBounds(10, 42, 137, 20);
		frmAddAnalyses.getContentPane().add(txtPh);

		txtOsmo = new JTextField();
		txtOsmo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtOsmo.getText().toLowerCase().contains("osmolarity")) {
					txtOsmo.setText("");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (txtOsmo.getText().isEmpty()) {
					txtOsmo.setText("Osmolarity");
				}
			}
		});
		txtOsmo.setText("Osmolarity");
		txtOsmo.setForeground(Color.LIGHT_GRAY);
		txtOsmo.setColumns(10);
		txtOsmo.setBackground(Color.BLACK);
		txtOsmo.setBounds(10, 73, 137, 20);
		frmAddAnalyses.getContentPane().add(txtOsmo);

		txtCond = new JTextField();
		txtCond.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCond.getText().toLowerCase().contains("conductivity")) {
					txtCond.setText("");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (txtCond.getText().isEmpty()) {
					txtCond.setText("Conductivity");
				}
			}
		});
		txtCond.setText("Conductivity");
		txtCond.setForeground(Color.LIGHT_GRAY);
		txtCond.setColumns(10);
		txtCond.setBackground(Color.BLACK);
		txtCond.setBounds(10, 104, 137, 20);
		frmAddAnalyses.getContentPane().add(txtCond);

		txtUreaConcentration = new JTextField();
		txtUreaConcentration.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtUreaConcentration.getText().toLowerCase().contains("urea concentration")) {
					txtUreaConcentration.setText("");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (txtUreaConcentration.getText().isEmpty()) {
					txtUreaConcentration.setText("Urea concentration");
				}
			}
		});
		txtUreaConcentration.setText("Urea concentration");
		txtUreaConcentration.setForeground(Color.LIGHT_GRAY);
		txtUreaConcentration.setColumns(10);
		txtUreaConcentration.setBackground(Color.BLACK);
		txtUreaConcentration.setBounds(10, 135, 137, 20);
		frmAddAnalyses.getContentPane().add(txtUreaConcentration);

		txtCalciumConcentration = new JTextField();
		txtCalciumConcentration.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCalciumConcentration.getText().toLowerCase().contains("calcium concentration")) {
					txtCalciumConcentration.setText("");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (txtCalciumConcentration.getText().isEmpty()) {
					txtCalciumConcentration.setText("Calcium concentration");
				}
			}
		});
		txtCalciumConcentration.setText("Calcium concentration");
		txtCalciumConcentration.setForeground(Color.LIGHT_GRAY);
		txtCalciumConcentration.setColumns(10);
		txtCalciumConcentration.setBackground(Color.BLACK);
		txtCalciumConcentration.setBounds(10, 166, 137, 20);
		frmAddAnalyses.getContentPane().add(txtCalciumConcentration);

		JComboBox<String> cbKidneyStones = new JComboBox<String>();
		cbKidneyStones.setToolTipText("");
		cbKidneyStones.setForeground(new Color(192, 192, 192));
		cbKidneyStones.setBackground(new Color(0, 0, 0));
		cbKidneyStones.setBounds(10, 210, 137, 22);
		cbKidneyStones.addItem("Present");
		cbKidneyStones.addItem("Not Present");
		frmAddAnalyses.getContentPane().add(cbKidneyStones);

		JLabel lblKidneyStonesPresence = new JLabel("Kidney stones presence");
		lblKidneyStonesPresence.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblKidneyStonesPresence.setForeground(new Color(192, 192, 192));
		lblKidneyStonesPresence.setBounds(10, 195, 137, 14);
		frmAddAnalyses.getContentPane().add(lblKidneyStonesPresence);

		JButton btnAddAnalysis = new JButton("Add analysis");
		btnAddAnalysis.setForeground(Color.WHITE);
		btnAddAnalysis.setBackground(Color.BLACK);
		btnAddAnalysis.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddAnalysis.setBounds(10, 279, 137, 27);
		frmAddAnalyses.getContentPane().add(btnAddAnalysis);

		btnAddAnalysis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isNumber(txtGravity.getText()) && isNumber(txtPh.getText()) && isNumber(txtOsmo.getText())
						&& isNumber(txtCond.getText()) && isNumber(txtUreaConcentration.getText())
						&& isNumber(txtCalciumConcentration.getText())) {
					if (((String) cbKidneyStones.getSelectedItem()) == "Present") {
						// Start the one shot behaviour to add new analysis
						agentAddAnalyses.AddNewUrineAnalysis(txtGravity.getText(), txtPh.getText(), txtOsmo.getText(),
								txtCond.getText(), txtUreaConcentration.getText(), txtCalciumConcentration.getText(),
								"1");
					} else {
						// Start the one shot behaviour to add new analysis
						agentAddAnalyses.AddNewUrineAnalysis(txtGravity.getText(), txtPh.getText(), txtOsmo.getText(),
								txtCond.getText(), txtUreaConcentration.getText(), txtCalciumConcentration.getText(),
								"0");
					}

					setDefaultTextForTexboxes();
					setDefaultColorForTexboxes(Color.LIGHT_GRAY);
				} else {
					System.out.print("Adding was not possible, check the validity of the inputs!\n");
				}
			}
		});

		setResizable(false);
	}

	// Set default text for textboxes
	private void setDefaultTextForTexboxes() {
		txtGravity.setText("Gravity");
		txtPh.setText("pH");
		txtOsmo.setText("Osmolarity");
		txtCond.setText("Conductivity");
		txtUreaConcentration.setText("Urea concentration");
		txtCalciumConcentration.setText("Calcium concentration");
	}

	// Set default color for textboxes
	private void setDefaultColorForTexboxes(Color fg) {
		txtGravity.setForeground(fg);
		txtPh.setForeground(fg);
		txtOsmo.setForeground(fg);
		txtCond.setForeground(fg);
		txtUreaConcentration.setForeground(fg);
		txtCalciumConcentration.setForeground(fg);
	}

	public void showInterface() {
		frmAddAnalyses.setVisible(true);
	}

	public static boolean isNumber(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
