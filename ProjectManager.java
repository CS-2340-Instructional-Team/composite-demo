import java.util.HashMap;
import java.util.Map;

public class ProjectManager implements Worker {
    private int salary;
    private int numHours;
    public ProjectManager(int salary, int numHours) {
        this.salary = salary;
        this.numHours = numHours;
    }

    @Override
    public Map<WorkType, Integer> getHoursWorked() {
        HashMap<WorkType, Integer> hoursWorked = new HashMap<WorkType, Integer>();
        hoursWorked.put(WorkType.PROJECT_MANAGEMENT, numHours);
        return hoursWorked;
    }

    @Override
    public int getTotalCost() {
        return salary;
    }
}
