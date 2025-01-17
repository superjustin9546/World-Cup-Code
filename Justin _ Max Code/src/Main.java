import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;

        String[] teams = new String[8];
        for (i = 0; i < 8; i++) {
            System.out.print("Enter team name " + (i + 1) + ": ");
            teams[i] = sc.nextLine();
        }

        String[] groupA = new String[4];
        String[] groupB = new String[4];

        Random rand = new Random();
        for (i = 0; i < 4; i++) {
            groupA[i] = teams[i];
            groupB[i] = teams[i + 4];
        }

        System.out.println("Group A: ");
        for (String team : groupA) {
            System.out.println(team);
        }

        System.out.println("Group B: ");
        for (String team : groupB) {
            System.out.println(team);
        }

        int[] groupApoints = new int[4];
        int[] groupBpoints = new int[4];

        for (i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                int score1 = rand.nextInt(6);
                int score2 = rand.nextInt(6);

                if (score1 > score2) {
                    groupApoints[i] += 3; 
                } else if (score1 < score2) {
                    groupApoints[j] += 3; 
                } else {
                    groupApoints[i] += 1;
                    groupApoints[j] += 1;
                }
            }
        }

        for (i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                int score1 = rand.nextInt(6);
                int score2 = rand.nextInt(6);

                if (score1 > score2) {
                    groupBpoints[i] += 3; 
                } else if (score1 < score2) {
                    groupBpoints[j] += 3; 
                } else {
                    groupBpoints[i] += 1; 
                    groupBpoints[j] += 1;
                }
            }
        }

        System.out.println("Group A Standings:");
        for (i = 0; i < 4; i++) {
            System.out.println(groupA[i] + " - Points: " + groupApoints[i]);
        }

        System.out.println("Group B Standings:");
        for (i = 0; i < 4; i++) {
            System.out.println(groupB[i] + " - Points: " + groupBpoints[i]);
        }

        int teamA1 = 0, teamA2 = 1, teamB1 = 0, teamB2 = 1;
        for (i = 1; i < 4; i++) {
            if (groupApoints[i] > groupApoints[teamA1]) {
                teamA2 = teamA1;
                teamA1 = i;
            } else if (groupApoints[i] > groupApoints[teamA2]) {
                teamA2 = i;
            }

            if (groupBpoints[i] > groupBpoints[teamB1]) {
                teamB2 = teamB1;
                teamB1 = i;
            } else if (groupBpoints[i] > groupBpoints[teamB2]) {
                teamB2 = i;
            }
        }

        System.out.println("Playoff Match 1: " + groupA[teamA1] + " vs " + groupB[teamB2]);
        int scoreA1 = rand.nextInt(6);
        int scoreB2 = rand.nextInt(6);
        System.out.println("Score: " + groupA[teamA1] + " " + scoreA1 + " - " + scoreB2 + " " + groupB[teamB2]);
        String finalist1 = (scoreA1 > scoreB2) ? groupA[teamA1] : groupB[teamB2];

        System.out.println("Playoff Match 2: " + groupB[teamB1] + " vs " + groupA[teamA2]);
        int scoreB1 = rand.nextInt(6);
        int scoreA2 = rand.nextInt(6);
        System.out.println("Score: " + groupB[teamB1] + " " + scoreB1 + " - " + scoreA2 + " " + groupA[teamA2]);
        String finalist2 = (scoreB1 > scoreA2) ? groupB[teamB1] : groupA[teamA2];

        System.out.println("Final Match: " + finalist1 + " vs " + finalist2);
        int finalScore1 = rand.nextInt(6);
        int finalScore2 = rand.nextInt(6);
        System.out.println("Score: " + finalist1 + " " + finalScore1 + " - " + finalScore2 + " " + finalist2);
        String winner = (finalScore1 > finalScore2) ? finalist1 : finalist2;

        System.out.println("Winner of the tournament: " + winner);
    }
}
