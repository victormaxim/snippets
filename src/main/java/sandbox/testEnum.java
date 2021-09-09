package A;

enum TrafficSignal
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
    private TrafficSignal(String actions)
    {
        this.actionz = actions;
    }
}

// Driver code 
public class testEnum
{

    public static void main(String args[])
    {
        // let's print name of each enum and there action 
        // - Enum values() examples 
        TrafficSignal[] signals = TrafficSignal.values();


        String y;
        y = TrafficSignal.valueOf("RED").getAction();
        System.out.println(y);

        for (TrafficSignal signal : signals)
        {
            // use getter method to get the value 
            System.out.println("name : " + signal.name() +
                    " action: " + signal.getAction() );
        }
    }
} 