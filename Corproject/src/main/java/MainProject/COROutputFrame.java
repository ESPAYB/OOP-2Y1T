package MainProject;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class COROutputFrame extends JFrame {
    private final DecimalFormat money = new DecimalFormat("#,##0.00");

    public COROutputFrame(CORData data) {
        setTitle("Certificate of Registration");
        setSize(1050, 760);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBorder(BorderFactory.createEmptyBorder(15, 18, 15, 18));
        root.setBackground(new Color(247, 248, 250));

        JLabel heading = new JLabel("CERTIFICATE OF REGISTRATION", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        root.add(heading, BorderLayout.NORTH);

        JPanel content = new JPanel(new BorderLayout(8, 12));
        content.setOpaque(false);
        content.add(buildStudentDetails(data), BorderLayout.NORTH);
        content.add(buildSubjectTable(data), BorderLayout.CENTER);
        content.add(buildFees(data), BorderLayout.SOUTH);
        root.add(content, BorderLayout.CENTER);

        JButton close = new JButton("Close");
        close.addActionListener(e -> dispose());
        JPanel bottom = new JPanel();
        bottom.setOpaque(false);
        bottom.add(close);
        root.add(bottom, BorderLayout.SOUTH);
        setContentPane(root);
    }

    private JPanel buildStudentDetails(CORData d) {
        JPanel panel = new JPanel(new GridLayout(5, 2, 30, 3));
        panel.setBorder(BorderFactory.createTitledBorder("Enrollment Information"));
        panel.setBackground(Color.WHITE);
        addDetail(panel, "Enrollment Status: ENROLLED", "College: " + d.college);
        addDetail(panel, "Student #: " + d.studentNumber, "Program: " + d.program);
        addDetail(panel, "Name: " + d.studentName, "Year Level: " + d.yearLevel);
        addDetail(panel, "Phone: N/A", "Term: " + d.term + "   SY: " + d.schoolYear);
        addDetail(panel, "Home Address: " + d.homeAddress, "ZIP Code: " + d.zipCode);
        return panel;
    }

    private void addDetail(JPanel panel, String left, String right) {
        panel.add(new JLabel(left));
        panel.add(new JLabel(right));
    }

    private JScrollPane buildSubjectTable(CORData d) {
        String[] columns = {"Course", "Title", "Section", "Units", "Days", "Time", "Room"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };
        for (Subject s : d.subjects) {
            model.addRow(new Object[]{s.getCode(), s.getTitle(), s.getSection(),
                    s.getUnits(), s.getDays(), s.getTime(), s.getRoom()});
        }
        JTable table = new JTable(model);
        table.setRowHeight(24);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        table.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createTitledBorder("Courses Enrolled"));
        return scroll;
    }

    private JPanel buildFees(CORData d) {
        JPanel panel = new JPanel(new GridLayout(0, 2, 25, 3));
        panel.setBorder(BorderFactory.createTitledBorder("Assessment and Payment Schedule"));
        panel.setBackground(Color.WHITE);
        addFee(panel, "Total Units", String.valueOf(d.totalUnits()));
        addFee(panel, "Tuition Fee", peso(d.tuitionFee()));
        addFee(panel, "Miscellaneous Fee", peso(d.miscellaneousFee));
        addFee(panel, "ID Validation Fee", peso(d.idValidationFee));
        addFee(panel, "Laboratory Fees", peso(d.laboratoryFees()));
        addFee(panel, "TOTAL ASSESSMENT", peso(d.totalAssessment()));
        addFee(panel, "Scholarship Deduction", "(" + peso(d.scholarshipDeduction()) + ")");
        addFee(panel, "FINAL TOTAL", peso(d.finalAssessment()));
        addFee(panel, "Down Payment (" + d.downPaymentPercent + "%)", peso(d.finalAssessment() * d.downPaymentPercent / 100));
        addFee(panel, "Midterm (" + d.midtermPercent + "%)", peso(d.finalAssessment() * d.midtermPercent / 100));
        addFee(panel, "Final (" + d.finalPercent + "%)", peso(d.finalAssessment() * d.finalPercent / 100));
        return panel;
    }

    private void addFee(JPanel panel, String label, String value) {
        JLabel left = new JLabel(label);
        JLabel right = new JLabel(value, SwingConstants.RIGHT);
        if (label.contains("TOTAL")) {
            left.setFont(left.getFont().deriveFont(Font.BOLD));
            right.setFont(right.getFont().deriveFont(Font.BOLD));
        }
        panel.add(left);
        panel.add(right);
    }

    private String peso(double value) { return "₱ " + money.format(value); }
}
