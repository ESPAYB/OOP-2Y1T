package MainProject;


import java.util.ArrayList;
import java.util.List;

public class CORData {
    String studentNumber, studentName, homeAddress, zipCode, classification;
    String college, program, yearLevel, term, schoolYear;
    double tuitionPerUnit, miscellaneousFee, idValidationFee;
    double scholarshipPercent, downPaymentPercent, midtermPercent, finalPercent;
    List<Subject> subjects = new ArrayList<>();

    public int totalUnits() {
        int total = 0;
        for (Subject subject : subjects) total += subject.getUnits();
        return total;
    }

    public double tuitionFee() {
        return totalUnits() * tuitionPerUnit;
    }

    public double laboratoryFees() {
        double total = 0;
        for (Subject subject : subjects) {
            String code = subject.getCode().toUpperCase();
            if (code.contains("LAB") || subject.getTitle().toUpperCase().contains("LABORATORY")) {
                total += 4000;
            }
        }
        return total;
    }

    public double totalAssessment() {
        return tuitionFee() + miscellaneousFee + idValidationFee + laboratoryFees();
    }

    public double scholarshipDeduction() {
        return tuitionFee() * scholarshipPercent / 100.0;
    }

    public double finalAssessment() {
        return totalAssessment() - scholarshipDeduction();
    }
}
