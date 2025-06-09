public class college {
private String name;
private double acceptanceRate;

public college(String name, double acceptanceRate) {
this.name = name;
this.acceptanceRate = acceptanceRate;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public double getAcceptanceRate() {
return acceptanceRate;
}

public void setAcceptanceRate(double acceptanceRate) {
this.acceptanceRate = acceptanceRate;
}

public String compareAcceptanceRate(double userChance) {
if (userChance < acceptanceRate) {
return "You have a good chance of being accepted into " + name + " (Acceptance Rate: " + acceptanceRate
+ "%).";
} else {
return "Your personal chance is lower than or equal to " + name + " (Acceptance Rate: " + acceptanceRate
+ "%). It might be a reach school.";
}
}

@Override
public String toString() {
return "College: " + name + ", Acceptance Rate: " + acceptanceRate + "%";
}
}

