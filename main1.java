import javax.swing.*;
import java.util.ArrayList;

public class main1 {
    public static void main(String[] args) {
        System.out.println("instructions ");
        ArrayList<college> colleges = new ArrayList<>();
        JOptionPane.showMessageDialog(null, "Welcome to the College Chancer Program!");

        double gpa = 0.0;
        try { // error handling to make sure correct input
            gpa = Double.parseDouble(JOptionPane.showInputDialog("Enter your GPA :"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid GPA. Please enter a valid number between 1.0 and 4.0.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int sat = 0;
        try {
            Integer.parseInt(JOptionPane.showInputDialog("Enter your SAT Score (BETWEEN 400 - 1600):"));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input for SAT Score. Please enter a valid number.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean ib = JOptionPane.showConfirmDialog(null, "Are you in IB?", "IBCheck",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        int clubCount = Integer.parseInt(JOptionPane.showInputDialog("How many clubs are you in?"));

        double personalChance = collegeChancer(gpa, sat, ib, clubCount);
        JOptionPane.showMessageDialog(null,
                "You will get into a college of an acceptance rate of: " + personalChance + "% or higher!");

        int numColleges = Integer.parseInt(JOptionPane.showInputDialog("How many colleges would you like to enter?"));

        for (int i = 0; i < numColleges; i++) {
            String name = JOptionPane.showInputDialog("Enter the name of College " + (i + 1) + ":");
            double rate = Double
                    .parseDouble(JOptionPane.showInputDialog("Enter the acceptance rate for " + name + ":"));
            colleges.add(new college(name, rate));
        }

        StringBuilder result = new StringBuilder("Comparison of your chances with the colleges you entered:\n");
        for (college college : colleges) {
            result.append(college.compareAcceptanceRate(personalChance)).append("\n");
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }

    public static double collegeChancer(double gpa, int sat, boolean ib, int clubCount) {
        // gpa rating
        int gpa_rating;
        if (gpa >= 3.90) {
            gpa_rating = 1;
        } else if (gpa >= 3.75) {
            gpa_rating = 2;
        } else if (gpa >= 3.5) {
            gpa_rating = 3;
        } else if (gpa >= 3.0) {
            gpa_rating = 4;
        } else {
            gpa_rating = 5;
        }

        // sat rating
        int sat_rating;
        if (sat >= 1500) {
            sat_rating = 1;
        } else if (sat >= 1400) {
            sat_rating = 2;
        } else if (sat >= 1300) {
            sat_rating = 3;
        } else if (sat >= 1200) {
            sat_rating = 4;
        } else {
            sat_rating = 5;
        }

        // club rating
        int club_rating;
        if (clubCount >= 4) {
            club_rating = 1;
        } else if (clubCount >= 3) {
            club_rating = 2;
        } else if (clubCount >= 2) {
            club_rating = 3;
        } else if (clubCount >= 1) {
            club_rating = 4;
        } else {
            club_rating = 5;
        }

        int ib_rating;
        if (ib) {
            ib_rating = 5;
        } else
            ib_rating = 2;

        double avg_chance = (5.0 - gpa_rating) * 0.3 + (5.0 - sat_rating) * 0.25 + (5.1 - club_rating) * 0.2
                + (6.0 - ib_rating) * 0.1;
        return avg_chance * 20;
    }
}
