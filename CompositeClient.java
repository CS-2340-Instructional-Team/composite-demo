public class CompositeClient {
    public static void main(String[] args) {
        Manager manager1 = new Manager(100000, 40);

        Manager manager2 = new Manager(70000, 35);
        manager2.addWorker(new SoftwareEngineer(60000, 40));
        manager2.addWorker(new ProjectManager(50000, 41));

        Manager manager3 = new Manager(70000, 32);
        manager3.addWorker(new SoftwareEngineer(55000, 40));

        manager1.addWorker(manager2);
        manager1.addWorker(manager3);

        System.out.println("Total cost of manager1 and their subordinates: " + manager1.getTotalCost());
        System.out.println("Total hours worked by manager1 and their subordinates: " + manager1.getHoursWorked());
    }
}