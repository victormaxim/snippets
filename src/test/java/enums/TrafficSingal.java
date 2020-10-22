package enums;

enum TrafficSingal
{
    // This will call enum constructor with one 
    // String argument 
    RED("STOP this"), GREEN("GO"), ORANGE("SLOW DOWN"), BLUE("s");

    // declaring private variable for getting values 
    private String actionz;

    // getter method 
    public String getAction()
    {
        return this.actionz;
    }

    // enum constructor - cannot be public or protected 
    private TrafficSingal(String actions)
    {
        this.actionz = actions;
    }
}