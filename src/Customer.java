import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable {
    private final String name;
    private final long personalNumber;
    private LocalDate membershipPaymentDate;
    private final List<LocalDate> visits = new ArrayList<>();

    public Customer(long personalNumber, String name, LocalDate membershipPaymentDate) {
        this.personalNumber = personalNumber;
        this.name = name;
        this.membershipPaymentDate = membershipPaymentDate;
    }

    public boolean isActiveMember() {
        //return membershipPaymentDate.plusYears(1).compareTo(LocalDate.now()) <= 0;
        return membershipPaymentDate.plusYears(1).isAfter(LocalDate.now());
    }

    public void logVisit() {
        visits.add(LocalDate.now());
        Database.save();
    }

    public void printAllVisits() {
        if (visits.isEmpty()) {
            System.out.println(name + " har inte besökt gymmet");
        } else {
            System.out.println(name + " har besökt gymmet följande datum: ");
            for (LocalDate date : visits) {
                System.out.println(date);
            }
        }
    }

    public String getName() {
        return name;
    }

    public long getPersonalNumber() {
        return personalNumber;
    }

    public LocalDate getMembershipPaymentDate() {
        return membershipPaymentDate;
    }

    public List<LocalDate> getVisits() {
        return visits;
    }
}
