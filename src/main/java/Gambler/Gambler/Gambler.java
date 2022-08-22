package Gambler.Gambler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Gambler 
{
	
	public static void gamble(int stake, int goal)

	{
		int win = 0;
		int loss = 0;
		float totalGambles = 0;
		int gamble = 0;
		Random random = new Random();
		do
		{
			gamble = random.nextInt(2);
			System.out.println(gamble);
			totalGambles++;
			if(gamble == 0)
			{
				stake++;
				System.out.println("you won! You now have "+stake+". Your goal:"+goal);
				win++;
			}
			else
			{
				stake--;
				System.out.println("Bad luck! You now have "+stake+". Your goal:"+goal);
				loss++;
			}			
		}while(!(stake == 0 || stake == goal));

		System.out.println("You won "+win+" times");
		float winp = (win/totalGambles)*100;
		System.out.println("Win percent % "+winp);
		float lossp = (loss/totalGambles)*100;
		System.out.println("Loss percent %"+lossp);

	}
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		//create the variable to take the input from user 
		int choice = 0;

		Scanner scanner = new Scanner(System.in);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		System.out.println("keep on betting until you win or lose completely!");
		System.out.println("lets Play...");
		
		do{
			System.out.println("Enter the beggining stake");

			int stake = Integer.parseInt(br.readLine());
			while(stake < 1)
			{
				System.out.println("you can't start empty handed!");
				System.out.println("Please enter an amount greater than 0");
				stake = Integer.parseInt(br.readLine());
			}
			
			System.out.println("Enter you goal...");
			int goal = Integer.parseInt(br.readLine());
			while( goal < stake)
			{
				System.out.println("Goal must be greater than your stake!");
				goal = Integer.parseInt(br.readLine());
			}
			gamble(stake, goal);
			System.out.println("press 1 for continue");
			choice = scanner.nextInt();
		}while(choice == 1);
		
		scanner.close();

	}
}
