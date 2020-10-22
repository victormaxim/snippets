package enums;

// Driver code
public class testEnum
{

    public static void main(String args[])
    {
        // let's print name of each enum and there action 
        // - Enum values() examples 
        TrafficSingal[] signals = TrafficSingal.values();


        String y;
        y = TrafficSingal.valueOf("RED").getAction();
        System.out.println(y);

        for (TrafficSingal signal : signals)
        {
            // use getter method to get the value 
            System.out.println("name : " + signal.name() +
                    " action: " + signal.getAction() );
        }
    }
} 