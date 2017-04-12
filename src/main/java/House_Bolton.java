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

    public double scores_boltons(){

        Stark_Army starkArmy= new Stark_Army();

        double soldierScore = 0;
        double bowmenScore = getBowmen()*18.5;
        double horsemanScore = getHorsemen()*6.5;
        double knightsScore = getKnights()*13.5;
        double elephantScore = getWar_elephants()*30;

        int wildlings = starkArmy.getWildlings();
        int horsemen_count = starkArmy.getHorsemen();

        //Condition 7
        if(getSoldiers()>wildlings){
            soldierScore=(getSoldiers()-wildlings)*3.5;
        }

        //Condition 9
        if(getBowmen()>2000){
            starkArmy.setHorsemen(horsemen_count/2);
        }




        double final_score_boltons = soldierScore+bowmenScore+horsemanScore+knightsScore+elephantScore;
        return final_score_boltons;
    }
}
