/**
 * Created by Freakanomic on 4/12/17.
 */
public class Rules{

    Bolton_Army boltonArmy = new Bolton_Army();
    Stark_Army starkArmy = new Stark_Army();

    int b_soldiers = boltonArmy.getSoldiers();
    int b_bowmen = boltonArmy.getBowmen();
    int b_horsemen = boltonArmy.getHorsemen();
    int b_knights = boltonArmy.getKnights();
    int b_elephants = boltonArmy.getWar_elephants();


    int s_giant = starkArmy.getGiant();
    int s_soldiers = starkArmy.getSoldiers();
    int s_knights = starkArmy.getKnights();
    int s_horsemen = starkArmy.getHorsemen();
    int s_wildlings = starkArmy.getWildlings();
    int s_bowmen = starkArmy.getBowmen();
    int s_nights_watch = starkArmy.getNights_watch();

    double s_giantScore = 0;


    public void rules_by_precedence() {

        //Condition 2
        s_giantScore = s_giant * 1000;

        //Condition 3
        if (b_soldiers >= 4000) {
            s_giantScore = 0;
        }

        //Condition 11
        if (s_nights_watch > 100) {
            boltonArmy.setKnights(Math.abs(b_knights * 90 / 100));
        }

        //Condition 8
        if (s_wildlings > 500) {
            boltonArmy.setWar_elephants(Math.abs(b_elephants * 90 / 100));
        }

        //Condition 6
        if (s_soldiers > (b_elephants * 50)) {
            starkArmy.setSoldiers(s_soldiers - (boltonArmy.getWar_elephants() * 50));
        } else {
            starkArmy.setSoldiers(Math.abs(s_soldiers * 80 / 100));
        }

        //Condition 10
        if (b_bowmen > 2000) {
            starkArmy.setHorsemen(Math.abs(s_horsemen / 2));
        }

    }


    public double calculate_boltonScores() {

        double b_soldierScore = b_soldiers * 2.5;
        //Condition 7
        double b_bowmenScore = b_bowmen * 18.5;
        double b_horsemanScore = b_horsemen * 6.5;
        //Condition 4
        double b_knightsScore = b_knights * 13.5;
        double b_elephantScore = b_elephants * 30;


        double final_score_boltons = b_soldierScore + b_bowmenScore + b_horsemanScore + b_knightsScore + b_elephantScore;
        return final_score_boltons;
    }

    public double calculate_starkScores() {
        double s_wildlingsScore = s_wildlings * 13.5;
        //Condition 5
        double s_soldierScore = s_soldiers * 4.5;
        double s_nightswatchScore = s_nights_watch * 17.5;
        double s_knightsScore = s_knights * 7.5;
        //Condition 9
        double s_horsemenScore = s_horsemen * 13.5;
        double s_bowmenScore = s_bowmen * 8.5;

        double final_score_starks = s_giantScore + s_wildlingsScore + s_soldierScore + s_nightswatchScore + s_knightsScore + s_horsemenScore + s_bowmenScore;
        return final_score_starks;
    }


}
