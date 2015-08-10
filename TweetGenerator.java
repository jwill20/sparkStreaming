package com.ibm.sae;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * A TCP server that runs on port 9090.  When a client connects, it
 * sends the client the current date and time, then closes the
 * connection with that client.  Arguably just about the simplest
 * server you can write.
 */
public class TweetGenerator {

    /*
	Aconite			inflammation, joint pain						nausea, vomiting, low blood pressure, heart rhythm disorder, death
	Bitter Orange	weight loss										fainting, heart rhythm disorder, heart attack, stroke, death
	Chaparral		infection, cancer								liver damage, kidney problems
	Colloidal   	infection, lyme disease, psoriasis,fatigue		neurological problems, kidney damage
	Coltsfoot		cough, sore throat, asthma						liver damage, cancer
	Comfrey			cough, chest pain, cancer						liver damage, cancer
	Country mallow	nasal congention, allergies, weight loss		heart attack, stroke, death
	Germanium		pain, infection, arthritis						kidney damage, death
	Kava			anxiety											liver damage
	Lobelia			coughing, asthma								fast heartbeat, low blood pressure, coma, death
	Yohimbe			aphrodisiac										high blood pressure, rapid heart rate, low blood pressure, death

	 */
    public static void main(String[] args) throws IOException 
    {
        ServerSocket listener = new ServerSocket(5678);
     
        try 
        {
        	System.out.println("Listener ready and waiting");
            Socket socket = listener.accept();
            try 
            {
                PrintWriter sendData = new PrintWriter(socket.getOutputStream(), true);
                
                for(;;)
                {
                	//System.out.println("Writing to socket => progress = " + progress);
                	System.out.println("Writing to socket => ");
                	
                	sendData.println("Been taking aconite and have been vomitting all night - just kidding");
                	sendData.println("Been taking aconite and have been vomitting all night");
                	sendData.println("aconite seems to work for my joint pain");
                	sendData.println("Not a hit");
                	sendData.println("I was using chaparral for infection and I think it has caused kidney problems");
                	sendData.println("My infection cleared up using chaparral");
                	sendData.println("Not a hit");
                	sendData.println("My father died after taking bitter orange ");
                	sendData.println("My father died after taking bitter orange ");
                	sendData.println("My father died after taking bitter orange ");
                	sendData.println("My father died after taking bitter orange ");
                	sendData.println("I've lost 30 pounds taking bitter orange");
                	sendData.println("Not a hit");
                	
                	
                	sendData.println("I was using chaparral for infection and I think it has caused kidney problems");
                	sendData.println("I was using chaparral for infection and I think it has caused kidney problems");
                	sendData.println("I was using chaparral for infection and I think it has caused kidney problems");
                	sendData.println("I was using chaparral for infection and I think it has caused kidney problems");
                	
                	sendData.println("I tried colloidal for my psoriasis and now I have neurological problems");
                	sendData.println("I tried colloidal for my psoriasis and now I have neurological problems");
                	sendData.println("I tried colloidal for my psoriasis and now I have neurological problems");
                	sendData.println("colloidal worked great on my psoriasis");
                	sendData.println("Not a hit");
                	
                	sendData.println("coltsfoot caused my liver to be damaged");
                	sendData.println("coltsfoot caused my liver to be damaged");
                	sendData.println("coltsfoot cleared up my sore throat");
                	sendData.println("Not a hit");
                	
                	sendData.println("My friend now has cancer.  He was taking comfrey - coincidence?");
                	sendData.println("My chest pain is gone after I started taking 100mg of comfrey every day");
                	sendData.println("Not a hit");
                	
                	//sendData.println("My sister had a stroke right after taking country mallow");
                	sendData.println("country mallow is good for allergies");
                	sendData.println("country mallow trouble breathing");
                	sendData.println("Not a hit");
                	
                	sendData.println("I have kidney damage from germanium");
                	sendData.println("germanium cleared up my arthritis");
                	sendData.println("Not a hit");
                	
                	sendData.println("kava caused my liver damage");
                	sendData.println("For anxiety kava is better than Valium");
                	sendData.println("Not a hit");
                	
                	sendData.println("I have really low blood pressure now after taking lobelia");
                	sendData.println("I don't cough anymore after taking lobelia");
                	sendData.println("Not a hit");
                	
                	sendData.println("My blood pressure went through the roof after I started taking yohimbe");
                	sendData.println("yohimbe is great - hehe");
                	sendData.println("Not a hit");

                	sendData.println("caused neurological problems yohimbe");
                	sendData.println("caused neurological problems yohimbe");
                	sendData.println("caused neurological problems yohimbe");
                	
                	sendData.println("caused neurological problems comfrey");
                	sendData.println("caused neurological problems comfrey");
                	sendData.println("caused neurological problems comfrey");
                	sendData.println("caused neurological problems comfrey");
                	
                	sendData.println("caused neurological problems kava");
                	sendData.println("caused neurological problems kava");
                	
                	Thread.sleep(3);
                }
                  
            } 
            catch(Exception e)
            {
            	
            }
            finally 
            {
                socket.close();
            }
        }
        finally 
        {
            listener.close();
        }
    }
}