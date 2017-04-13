import java.util.Arrays;
import java.util.Random;

/**
 * Created by Freakanomic on 4/10/17.
 */
public class House_Bolton extends Bolton_Army implements IDistribute {

    public void randomize(int boltonArmy){
        Random rand = new Random();
        int count = 5;
        int boltonArray[] = new int[count];
        boltonArmy -= count;
        for(int i=0; i<count-1; ++i){
            boltonArray[i] = rand.nextInt(boltonArmy);
        }
        boltonArray[count-1] = boltonArmy;
        Arrays.sort(boltonArray);
        for(int i = count-1; i>0; --i){
            boltonArray[i] -= boltonArray[i-1];
        }

        for(int i=0; i<count; ++i){
            ++boltonArray[i];
        }

        setSoldiers(boltonArray[0]);
        setHorsemen(boltonArray[1]);
        setKnights(boltonArray[2]);
        setWar_elephants(boltonArray[3]);
        setBowmen(boltonArray[4]);

        System.out.println("Soldiers : " +getSoldiers());
        System.out.println("Horsemen : " +getHorsemen());
        System.out.println("Knights :" +getKnights());
        System.out.println("War Elephants : " +getWar_elephants());
        System.out.println("Bowmen : " +getBowmen());
    }


}
