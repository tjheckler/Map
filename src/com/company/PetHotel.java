package com.company;

import java.sql.SQLOutput;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class PetHotel
{
    Map<Integer, String > rooms = new TreeMap<>();
    public static void main(String[] args)
    {
        PetHotel petHotel = new PetHotel();
        petHotel.run();

    }

    private void run()
    {
        String command;
        String commandLine;
        Scanner in = new Scanner(System.in);

        System.out.println("Please Enter one of the Following Commands:");
        System.out.println("CheckIn <petName> <roomNumber> to check pet in hotel");
        System.out.println("CheckOut <Room Number> to check pet out of hotel");
        System.out.println("Move <roomNumber> <toRoomNumber> to change rooms");
        System.out.println("Occupancy, To list rooms occupied");
        System.out.println("CloseForSeason, to remove all pets from the hotel");
        System.out.println("Exit, To Exit the Program");

        do
        {

            System.out.println("What is your command?");
            commandLine = in.nextLine();
            String[] commands = commandLine.split(" ");
            command = commands[0].toUpperCase();


            if (command.equals("CHECKIN")&& commands.length == 3)
            {
                String petName = commands[1];
                int roomNumber = Integer.parseInt(commands[2]);
                checkIn(petName, roomNumber);

            } else if (command.equals("OCCUPANCY"))
            {

                for (Map.Entry<Integer,String> entry : rooms.entrySet() )
                {
                    Integer roomNumber = entry.getKey();
                    String petName = entry.getValue();
                    System.out.println("Room Number: "+roomNumber+ " Pet Name: "+petName);
                }

            }
            else if (command.equals("MOVE")&& commands.length == 3)

            {
                int roomNumber = Integer.parseInt(commands[1]);
                Integer newRoomNumber = Integer.parseInt(commands[2]);
                movePet(roomNumber, newRoomNumber);

            }
            else if (command.equals("CHECKOUT")&& commands.length == 2)
            {
                int x = Integer.parseInt(commands[1]);
                rooms.remove(x);


            } else if (command.equals("CLOSEFORSEASON"))
            {
                rooms.clear();
                System.out.println("Hotel is now empty");
            }
            else if (command.equals("SWAP"))
            {
                int firstRoomNumber = Integer.parseInt(commands[1]);
                Integer secondRoomNumber = Integer.parseInt(commands[2]);
                swapPets(firstRoomNumber, secondRoomNumber);
            }
            else
            {
                System.out.println("Please Try Again");
            }
        }
        while (!command.equals("EXIT"));
        System.out.println("You Have Ended Program");

    }
    private void movePet(int roomNumber, int newRoomNumber)
    {
        if(rooms.containsKey(newRoomNumber))
        {
            System.out.println("Sorry room is already filled");
        }
        else
        {
            String petName = rooms.remove(roomNumber);
            System.out.println("Moving " + petName + " to " + newRoomNumber);
            rooms.remove(roomNumber);
            rooms.put(newRoomNumber, petName);
        }
    }
    private void swapPets(int firstRoomNumber, int secondRoomNumber)
    {
        String firstPetName = rooms.remove(firstRoomNumber);
        String secondPetName = rooms.remove(secondRoomNumber);
        System.out.println("Moving " + firstPetName + " to " + secondRoomNumber);
        System.out.println("Moving "+ secondPetName + " to "+ firstRoomNumber);

        rooms.put(secondRoomNumber, firstPetName);
        rooms.put(firstRoomNumber, secondPetName);
    }
    private void checkIn(String petName, int roomNumber)
    {
        System.out.println("Checking " + petName + " in to room " + roomNumber);
        rooms.put(roomNumber,petName);
    }
}

