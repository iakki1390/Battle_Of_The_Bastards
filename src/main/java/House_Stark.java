import java.util.Arrays;
import java.util.Random;

/**
 * Created by Freakanomic on 4/10/17.
 */
public class House_Stark extends Stark_Army implements IDistribute{
    public void randomize(int starkArmy) {
        Random rand = new Random();
        int count = 6;
        int starkArray[] = new int[count];
        starkArmy=starkArmy-1;//Giant is constant 1
        starkArmy -= count;
        for(int i=0; i<count-1; ++i){
            starkArray[i] = rand.nextInt(starkArmy);
        }
        starkArray[count-1] = starkArmy;
        Arrays.sort(starkArray);
        for(int i = count-1; i>0; --i){
            starkArray[i] -= starkArray[i-1];
        }

        for(int i=0; i<count; ++i){
            ++starkArray[i];
        }

        setSoldiers(starkArray[0]);
        setWildlings(starkArray[1]);
        setNights_watch(starkArray[2]);
        setHorsemen(starkArray[3]);
        setKnights(starkArray[4]);
        setBowmen(starkArray[5]);

        System.out.println("Soldiers : " +getSoldiers());
        System.out.println("Wildlings : " +getWildlings());
        System.out.println("Nights Watch : " +getNights_watch());
        System.out.println("Horsemen : " +getHorsemen());
        System.out.println("Knights :" +getKnights());
        System.out.println("Bowmen : " +getBowmen());
        System.out.println("Giant : " +getGiant());
    }

    public double scores_starks(){

        Bolton_Army boltonArmy = new Bolton_Army();
        int b_soldierno = boltonArmy.getSoldiers();

        //Condition 2
        double giantScore = getGiant()*1000;
        double wildlingsScore=0;
        double soldierScore = getSoldiers()*4.5;
        double nightswatchScore = 17.5;
        double knightsScore = getKnights()*7.5;
        double horsemenScore = getHorsemen()*13.5;
        double bowmenScore = 8.5;

        //Condition 3
        if(b_soldierno>=4000){
            giantScore=0;
        }

        //Condition 10
        if(getNights_watch()>100){
            boltonArmy.setSoldiers(b_soldierno*90/100);
        }

        //Condition 7
        if(getWildlings()>b_soldierno){
            wildlingsScore=(getWildlings()-b_soldierno)*75;
        }

        //Condition 5
        setSoldiers(getSoldiers()-(boltonArmy.getWar_elephants()*50));


        double final_score_starks=giantScore+wildlingsScore+soldierScore+nightswatchScore+knightsScore+horsemenScore+bowmenScore;
        return final_score_starks;
    }
}
