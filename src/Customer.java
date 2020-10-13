import java.time.LocalDate;
import java.util.List;

public class Customer {
    private String name;
    private long personalNumber;
    private LocalDate membershipPaymentDate;
    private List<LocalDate> visits;

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
