import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Freakanomic on 4/10/17.
 */
public class Battle_Start{

    public static void main(String[] args) throws IOException {

        Battle_Start battle = new Battle_Start();
        IDistribute distribute_stark=new House_Stark();
        IDistribute distribute_bolton=new House_Bolton();
        System.out.println("Welcome to Battle of the Bastards");
        System.out.println("---------------------------------");
        System.out.println("1. House Stark");
        System.out.println("2. House Bolton");
        System.out.println("----------------------------------");
        System.out.println("Choose the size of Stark Stark_Army : ");
        Scanner sc1 = new Scanner(System.in);
        int starkArmy = sc1.nextInt();
        System.out.println("----------------------------------");
        System.out.println("Distributing the Stark Stark_Army");
        System.out.println("----------------------------------");
        distribute_stark.randomize(starkArmy);
        System.out.println("----------------------------------");
        System.out.println("Choose the number of Bolton soldiers : ");
        Scanner sc2 = new Scanner(System.in);
        int boltonArmy = sc2.nextInt();
        System.out.println("----------------------------------");
        System.out.println("Distributing the Bolton Stark_Army ");
        System.out.println("----------------------------------");
        distribute_bolton.randomize(boltonArmy);
        System.out.println("----------------------------------");
        System.out.println("Press ENTER to start the battle");
        System.out.println("----------------------------------");
        System.in.read();
        System.out.println("SIMULATING THE BATTLE");
        System.out.println();
        System.out.println();
        battle.run();

    }


    public void run(){

        System.out.println("The battle has begun.....");

        Rules rules = new Rules();

        rules.rules_by_precedence();

        double boltons = rules.calculate_boltonScores();
        double starks = rules.calculate_starkScores();


        System.out.println();
        System.out.println();



        if(starks>boltons){
            System.out.println("The STARKS won the battle...");
        }
        else if(starks<boltons){
            System.out.println("The BOLTONS won the battle...");
        }
        //Edge Case
        else{
            System.out.println("War always brings misery. Everybody died in the battle...");
        }
    }
}
