// assume shape is 2D
// assume material shape won't affect max weight/fire strength
// assume weight on different point will be simply accumulated to weight to the whole part
// assume weight duration on different point will be simply accumulated to weight duration to the whole part

class Rectangle {
    public double x;
    public double y;
    public double w;
    public double h;
}

interface Material {
    double getMaxWeightStrength();
    double getMaxWeightStrengthDuration();
    double getMaxFireStrength();
    double getMaxFireStrengthDuration();
}


class Plastic implement Material {
    public double getMaxWeightStrength() {
        ...
    }
    public double getMaxWeightStrengthDuration();
    public double getMaxFireStrength();
    public double getMaxFireStrengthDuration();
}

class MaterialStatus {
    private double accumulatedWeight;
    private double ...;
}

enum Color {
    gray,
    brown,
    black,
}

enum FurnitureState {
    OK,
    UNUSABLE
}

abstract class Furniture {
    private FurnitureState state;
    private Map<Rectangle, Material> parts;
    private Map<Rectangle, MaterialStatus> parts;

    public void applyWeight(double x, double y, double weight, double seconds) {
        // add weight at (x,y) with duration seconds
        // if weight at (x, y) with duration seconds > max weight/duration at (x,y) state = UNUSABLE
    }
    
    public void applyFire(double x, double y, double fireStrength, double seconds) {

    }

    public Color getColor() {

    }

    @Override
    public FurnitureState getState() {
        return state;
    }

    //abstract public void applyWeight(double x, double y, double weight, double seconds);
}

class WoodChair extends Furniture {
}











select unique customer_id from requests where access_time >= day1 and access_time < day2;

select unique customer_id from request where access_time >= day2 and access_time < day3;


log

Set<Customer> day1Customers;
Set<Customer> day2Customers;

for (read one request from log file) {
    if (request.getAccessTime() >= day1 and request.getAccessTime() < day2) {
        day1Customers.add(request.getCustomer());
    }
    if (request.getAccessTime() >= day2 and request.getAccessTime() < day3) {
        day2Customers.add(request.getCustomer());
    }
}

for (customer: day1Cutomers) if customer in day2Customers a++;

Set<Customer> totalCustomers;
totalCustomers.addAll(day1Customers);
totalCustomers.addAll(day2Customers);
b = totalCustomers.size();

a/b
