import java.util.Map;

public interface Worker {
    public Map<WorkType, Integer> getHoursWorked();
    public int getTotalCost();
}
