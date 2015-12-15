package loginAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Srinivas Javvaji on 12/15/2015.
 */
public class GenerateObjectsList {



    public static List<DueDetails> getDueDetailsList()
    {
            List<DueDetails> dueDetailsliList = new ArrayList<DueDetails>();

        for(int i =0 ; i < 10; i++)
        {
            DueDetails dueDetails = new DueDetails();

            dueDetails.setParty_name("Party_" + i);
            dueDetails.setParty_id("" + i);
            dueDetails.setPending_amt(new Random().nextDouble() * 86);

            dueDetailsliList.add(dueDetails);
        }
        return dueDetailsliList;
    }






}
