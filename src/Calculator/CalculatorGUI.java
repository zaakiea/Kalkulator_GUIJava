/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculator;

/**
 *
 * @author tunaterbang
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener {

    private JTextField textField;   // Layar Utama
    private JLabel historyLabel;    // Layar Riwayat
    private JPanel panelTombol;

    // Variabel logika
    private String operator;
    private double angkaPertama, angkaKedua, hasil;

    // Palet Warna
    private final Color BACKGROUND_COLOR = new Color(242, 242, 247);
    private final Color TEXT_DISPLAY_COLOR = new Color(30, 30, 30);
    private final Color TEXT_HISTORY_COLOR = new Color(120, 120, 120);
    
    private final Color BTN_NUM_COLOR = Color.WHITE; 
    private final Color BTN_FUNC_COLOR = new Color(210, 210, 215); 
    private final Color BTN_OPS_TEXT_COLOR = new Color(255, 149, 0); 
    private final Color BTN_EQUAL_COLOR = new Color(255, 149, 0); 
    private final Color TEXT_BLACK = Color.BLACK;
    private final Color TEXT_WHITE = Color.WHITE;

    public CalculatorGUI() {
        setTitle("Kalkulator");
        setSize(350, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(BACKGROUND_COLOR);

        // --- Panel Display ---
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new GridLayout(2, 1));
        displayPanel.setBackground(BACKGROUND_COLOR);
        displayPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));

        historyLabel = new JLabel(" ");
        historyLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        historyLabel.setForeground(TEXT_HISTORY_COLOR);
        historyLabel.setHorizontalAlignment(JLabel.RIGHT);
        
        textField = new JTextField();
        textField.setFont(new Font("Segoe UI", Font.BOLD, 48));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        textField.setBackground(BACKGROUND_COLOR);
        textField.setForeground(TEXT_DISPLAY_COLOR);
        textField.setBorder(null);

        displayPanel.add(historyLabel);
        displayPanel.add(textField);
        add(displayPanel, BorderLayout.NORTH);

        // --- Panel Tombol ---
        panelTombol = new JPanel();
        panelTombol.setBackground(BACKGROUND_COLOR);
        panelTombol.setLayout(new GridLayout(5, 4, 15, 15)); 
        panelTombol.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 15));

        // Update Simbol agar sesuai gambar (÷ dan ×)
        String[] labels = {
            "AC", "⌫", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "00", "0", ",", "="
        };

        for (String label : labels) {
            RoundButton tombol = new RoundButton(label);
            tombol.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tombol.addActionListener(this);

            tombol.setBackground(BTN_NUM_COLOR);
            tombol.setForeground(TEXT_BLACK);

            if (label.equals("AC") || label.equals("⌫") || label.equals("%")) {
                tombol.setBackground(BTN_FUNC_COLOR);
            } 
            else if (label.equals("÷") || label.equals("×") || label.equals("-") || label.equals("+")) {
                tombol.setForeground(BTN_OPS_TEXT_COLOR);
                tombol.setFont(new Font("Segoe UI", Font.BOLD, 24));
            } 
            else if (label.equals("=")) {
                tombol.setBackground(BTN_EQUAL_COLOR);
                tombol.setForeground(TEXT_WHITE);
            }
            panelTombol.add(tombol);
        }

        add(panelTombol, BorderLayout.CENTER);
        setVisible(true);
    }

    // Helper: Format tampilan (menghilangkan .0 dan mengganti . jadi ,)
    private String formatNumber(double val) {
        String text;
        if (val % 1 == 0) {
            text = String.valueOf((int)val);
        } else {
            text = String.valueOf(val);
        }
        // Ubah titik jadi koma untuk tampilan visual
        return text.replace(".", ",");
    }

    // Helper: Parse string ke double (mengganti , jadi . agar Java mengerti)
    private double parseValue(String text) {
        if (text.isEmpty()) return 0;
        return Double.parseDouble(text.replace(",", "."));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // 1. JIKA TOMBOL ANGKA (0-9)
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9' && !command.equals("00")) {
            textField.setText(textField.getText() + command);
        }
        // 2. JIKA TOMBOL 00
        else if (command.equals("00")) {
             textField.setText(textField.getText() + "00");
        }
        // 3. JIKA TOMBOL KOMA (Validasi agar tidak double koma)
        else if (command.equals(",")) {
            if (!textField.getText().contains(",")) {
                if (textField.getText().isEmpty()) {
                    textField.setText("0,");
                } else {
                    textField.setText(textField.getText() + ",");
                }
            }
        }
        // 4. TOMBOL AC (Reset)
        else if (command.equals("AC")) {
            textField.setText("");
            historyLabel.setText(" ");
            angkaPertama = 0; angkaKedua = 0; operator = null;
        }
        // 5. TOMBOL BACKSPACE
        else if (command.equals("⌫")) { 
            String txt = textField.getText();
            if (txt.length() > 0) {
                textField.setText(txt.substring(0, txt.length() - 1));
            }
        }
        // 6. TOMBOL SAMA DENGAN (=)
        else if (command.equals("=")) {
            if (operator != null && !textField.getText().isEmpty()) {
                angkaKedua = parseValue(textField.getText());
                
                // Tampilkan history dengan format koma
                historyLabel.setText(formatNumber(angkaPertama) + " " + operator + " " + formatNumber(angkaKedua) + " =");

                switch (operator) {
                    case "+": hasil = angkaPertama + angkaKedua; break;
                    case "-": hasil = angkaPertama - angkaKedua; break;
                    case "×": hasil = angkaPertama * angkaKedua; break; // Pakai simbol ×
                    case "÷": hasil = angkaPertama / angkaKedua; break; // Pakai simbol ÷
                    case "%": hasil = angkaPertama % angkaKedua; break;
                }
                
                textField.setText(formatNumber(hasil));
                operator = null;
            }
        }
        // 7. TOMBOL OPERATOR (+, -, ×, ÷)
        else { 
            if (!textField.getText().isEmpty()) {
                angkaPertama = parseValue(textField.getText());
                operator = command;
                
                historyLabel.setText(formatNumber(angkaPertama) + " " + operator);
                textField.setText("");
            }
        }
    }

    // --- Inner Class: Komponen Tombol Bulat ---
    class RoundButton extends JButton {
        public RoundButton(String label) {
            super(label);
            setContentAreaFilled(false); 
            setFocusPainted(false);      
            setBorderPainted(false);     
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            if (getModel().isArmed()) {
                g2.setColor(getBackground().darker());
            } else {
                g2.setColor(getBackground());
            }

            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); 
            super.paintComponent(g2);
            g2.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorGUI());
    }
}