import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Manager implements Worker {
    private ArrayList<Worker> managed;
    private int salary;
    private int numHours;

    public Manager(int salary, int numHours) {
        this.salary = salary;
        this.numHours = numHours;
        this.managed = new ArrayList<>();
    }

    public Manager(int salary, int numHours, ArrayList<Worker> managed) {
        this(salary, numHours);
        this.managed = managed;
    }

    public void addWorker(Worker worker) {
        managed.add(worker);
    }

    public void removeWorker(Worker worker) {
        managed.remove(worker);
    }

    @Override
    public Map<WorkType, Integer> getHoursWorked() {
        HashMap<WorkType, Integer> hoursWorked = new HashMap<WorkType, Integer>();
        hoursWorked.put(WorkType.MANAGEMENT, numHours);
        for (Worker subordinate : managed) {
            Map<WorkType, Integer> subWork = subordinate.getHoursWorked();
            for (Map.Entry<WorkType, Integer> entry : subWork.entrySet()) {
                if (hoursWorked.containsKey(entry.getKey())){
                    hoursWorked.put(entry.getKey(), hoursWorked.get(entry.getKey()) + entry.getValue());
                } else {
                    hoursWorked.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return hoursWorked;
    }

    @Override
    public int getTotalCost() {
        //find tasks for subtree of classes to work on
        int totalCost = salary;
        for (Worker subordinate : managed) {
            totalCost += subordinate.getTotalCost();
        }
        return totalCost;
    }

}
