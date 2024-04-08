import java.util.HashMap;
import java.util.Map;

public class SoftwareEngineer implements Worker {
    private int salary;
    private int numHours;
    public SoftwareEngineer(int salary, int numHours) {
        this.salary = salary;
        this.numHours = numHours;
    }

    @Override
    public Map<WorkType, Integer> getHoursWorked() {
        HashMap<WorkType, Integer> hoursWorked = new HashMap<WorkType, Integer>();
        hoursWorked.put(WorkType.SOFTWARE_DEVELOPMENT, numHours);
        return hoursWorked;
    }

    @Override
    public int getTotalCost() {
        return salary;
    }
}
