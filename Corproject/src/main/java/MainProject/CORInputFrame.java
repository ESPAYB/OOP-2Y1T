package MainProject;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CORInputFrame extends JFrame {
    private final JTextField studentNo = new JTextField("202511215", 12);
    private final JTextField studentName = new JTextField("HILARIO, GENE ANDREI", 20);
    private final JTextField address = new JTextField("Manila", 12);
    private final JTextField zip = new JTextField("1000", 8);
    private final JTextField college = new JTextField("COMPUTER STUDIES", 15);
    private final JTextField program = new JTextField("BSCSAI", 10);
    private final JTextField year = new JTextField("2nd Year", 10);
    private final JTextField term = new JTextField("1st Term", 10);
    private final JTextField schoolYear = new JTextField("2026-2027", 10);
    private final JTextField tuition = new JTextField("2200", 8);
    private final JTextField misc = new JTextField("12305", 8);
    private final JTextField idFee = new JTextField("80", 8);
    private final JTextField scholarship = new JTextField("100", 6);
    private final JTextField down = new JTextField("40", 6);
    private final JTextField midterm = new JTextField("30", 6);
    private final JTextField finalPay = new JTextField("30", 6);

    private final JTextField code = new JTextField(10);
    private final JTextField title = new JTextField(22);
    private final JTextField section = new JTextField(8);
    private final JTextField units = new JTextField(5);
    private final JTextField days = new JTextField(8);
    private final JTextField time = new JTextField(16);
    private final JTextField room = new JTextField(10);
    private final DefaultTableModel subjectModel = new DefaultTableModel(
            new String[]{"Course", "Title", "Section", "Units", "Days", "Time", "Room"}, 0);

    public CORInputFrame() {
        setTitle("COR Input Form");
        setSize(1150, 760);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildInterface();
    }

    private void buildInterface() {
        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBorder(BorderFactory.createEmptyBorder(12, 15, 12, 15));
        root.setBackground(new Color(245, 246, 248));

        JLabel heading = new JLabel("CERTIFICATE OF REGISTRATION - INPUT FORM");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        root.add(heading, BorderLayout.NORTH);

        JPanel center = new JPanel(new BorderLayout(10, 10));
        center.setOpaque(false);
        center.add(buildInfoPanel(), BorderLayout.NORTH);
        center.add(buildSubjectPanel(), BorderLayout.CENTER);
        center.add(buildFeePanel(), BorderLayout.SOUTH);
        root.add(new JScrollPane(center), BorderLayout.CENTER);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton compute = new JButton("Compute Fees");
        JButton generate = new JButton("Generate COR");
        JButton clear = new JButton("Clear");
        compute.addActionListener(e -> computeFees());
        generate.addActionListener(e -> generateCOR());
        clear.addActionListener(e -> clearForm());
        buttons.add(compute);
        buttons.add(generate);
        buttons.add(clear);
        root.add(buttons, BorderLayout.SOUTH);
        setContentPane(root);
    }

    private JPanel buildInfoPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Student Information"));
        panel.setBackground(Color.WHITE);
        addField(panel, 0, 0, "Student Number", studentNo);
        addField(panel, 2, 0, "Student Name", studentName);
        addField(panel, 0, 1, "Home Address", address);
        addField(panel, 2, 1, "ZIP Code", zip);
        addField(panel, 0, 2, "College", college);
        addField(panel, 2, 2, "Program", program);
        addField(panel, 0, 3, "Year Level", year);
        addField(panel, 2, 3, "Term", term);
        addField(panel, 0, 4, "School Year", schoolYear);
        return panel;
    }

    private JPanel buildSubjectPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Subject Input"));
        panel.setBackground(Color.WHITE);
        JPanel fields = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fields.setBackground(Color.WHITE);
        fields.add(new JLabel("Code")); fields.add(code);
        fields.add(new JLabel("Title")); fields.add(title);
        fields.add(new JLabel("Section")); fields.add(section);
        fields.add(new JLabel("Units")); fields.add(units);
        fields.add(new JLabel("Days")); fields.add(days);
        fields.add(new JLabel("Time")); fields.add(time);
        fields.add(new JLabel("Room")); fields.add(room);
        JButton add = new JButton("Add Subject");
        JButton remove = new JButton("Remove Selected");
        add.addActionListener(e -> addSubject());
        remove.addActionListener(e -> removeSubject());
        fields.add(add); fields.add(remove);
        panel.add(fields, BorderLayout.NORTH);

        JTable table = new JTable(subjectModel);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(23);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    private JPanel buildFeePanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(BorderFactory.createTitledBorder("Fee Settings"));
        panel.setBackground(Color.WHITE);
        panel.add(new JLabel("Tuition/Unit")); panel.add(tuition);
        panel.add(new JLabel("Miscellaneous")); panel.add(misc);
        panel.add(new JLabel("ID Fee")); panel.add(idFee);
        panel.add(new JLabel("Scholarship %")); panel.add(scholarship);
        panel.add(new JLabel("Down %")); panel.add(down);
        panel.add(new JLabel("Midterm %")); panel.add(midterm);
        panel.add(new JLabel("Final %")); panel.add(finalPay);
        return panel;
    }

    private void addField(JPanel panel, int x, int y, String label, JTextField field) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x; c.gridy = y; c.insets = new Insets(4, 7, 4, 7); c.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel(label + ":"), c);
        c.gridx = x + 1; c.weightx = 1; c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(field, c);
    }

    private void addSubject() {
        try {
            if (code.getText().trim().isEmpty() || title.getText().trim().isEmpty())
                throw new IllegalArgumentException("Course code and title are required.");
            int unitValue = Integer.parseInt(units.getText().trim());
            if (unitValue <= 0) throw new IllegalArgumentException("Units must be positive.");
            subjectModel.addRow(new Object[]{code.getText().trim(), title.getText().trim(),
                    section.getText().trim(), unitValue, days.getText().trim(), time.getText().trim(), room.getText().trim()});
            code.setText(""); title.setText(""); section.setText(""); units.setText("");
            days.setText(""); time.setText(""); room.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Units must be a whole number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeSubject() {
        JTable table = findSubjectTable();
        if (table != null && table.getSelectedRow() >= 0) subjectModel.removeRow(table.getSelectedRow());
    }

    private JTable findSubjectTable() {
        for (java.awt.Component component : ((JPanel) ((JScrollPane) getContentPane().getComponent(1)).getViewport().getView()).getComponents()) {
            if (component instanceof JPanel) {
                for (java.awt.Component nested : ((JPanel) component).getComponents()) {
                    if (nested instanceof JScrollPane) {
                        java.awt.Component view = ((JScrollPane) nested).getViewport().getView();
                        if (view instanceof JTable) return (JTable) view;
                    }
                }
            }
        }
        return null;
    }

    private CORData readData() {
        CORData data = new CORData();
        data.studentNumber = studentNo.getText(); data.studentName = studentName.getText();
        data.homeAddress = address.getText(); data.zipCode = zip.getText();
        data.college = college.getText(); data.program = program.getText();
        data.yearLevel = year.getText(); data.term = term.getText(); data.schoolYear = schoolYear.getText();
        data.tuitionPerUnit = number(tuition); data.miscellaneousFee = number(misc); data.idValidationFee = number(idFee);
        data.scholarshipPercent = number(scholarship); data.downPaymentPercent = number(down);
        data.midtermPercent = number(midterm); data.finalPercent = number(finalPay);
        for (int i = 0; i < subjectModel.getRowCount(); i++) {
            data.subjects.add(new Subject(subjectModel.getValueAt(i, 0).toString(), subjectModel.getValueAt(i, 1).toString(),
                    subjectModel.getValueAt(i, 2).toString(), Integer.parseInt(subjectModel.getValueAt(i, 3).toString()),
                    subjectModel.getValueAt(i, 4).toString(), subjectModel.getValueAt(i, 5).toString(), subjectModel.getValueAt(i, 6).toString()));
        }
        return data;
    }

    private double number(JTextField field) { return Double.parseDouble(field.getText().trim()); }

    private void computeFees() {
        try {
            CORData d = readData();
            JOptionPane.showMessageDialog(this, "Total Units: " + d.totalUnits() + "\nFinal Assessment: ₱ " + String.format("%,.2f", d.finalAssessment()), "Computation Result", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers in all fee fields.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generateCOR() {
        try {
            if (subjectModel.getRowCount() == 0) throw new IllegalArgumentException("Add at least one subject first.");
            new COROutputFrame(readData()).setVisible(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers in all fee fields.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Cannot Generate COR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        subjectModel.setRowCount(0);
        code.setText(""); title.setText(""); section.setText(""); units.setText(""); days.setText(""); time.setText(""); room.setText("");
    }
}
