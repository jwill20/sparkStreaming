package com.ibm.sae;	

import java.io.IOException;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import redis.clients.jedis.Jedis;

@WebSocket
public class TweetCountFetcher 
{
	
	Jedis jedis = new Jedis("localhost");

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) 
    {
        System.out.println("TweetCountFetcher:onClose => Close: statusCode=" + statusCode + ", reason=" + reason);
    }

    @OnWebSocketError
    public void onError(Throwable t) 
    {
        System.out.println("TweetCountFetcher:onError => Error: " + t.getMessage());
    }

    @OnWebSocketConnect
    public void onConnect(Session session) 
    {
        System.out.println("TweetCountFetcher:onConnect => Connect: " + session.getRemoteAddress().getAddress());
        System.out.println("TweetCountFetcher:onConnect => Connect: " + session.getRemoteAddress().getPort());
        String aconite, bitterOrange, chaparral, colloidal, coltsfoot, comfrey, 
               countryMallow, germanium, kava, lobelia, yohimbe, gingko;
        
        try 
        {
           for (;;)
           {
        	   Thread.sleep(3000);
        	   
	           aconite        = jedis.get("aconite");
	   	       if (new Integer(aconite) > 9500) jedis.set("aconite","51"); 
	           
	           bitterOrange   = jedis.get("bitter orange");
	           if (new Integer(bitterOrange) > 9500) jedis.set("bitter orange","122");
	           
	   	       chaparral      = jedis.get("chaparral");       
	   	       if (new Integer(chaparral) > 9500) jedis.set("chaparral","301");
	   	    
	   	       colloidal      = jedis.get("colloidal");      
	   	       if (new Integer(colloidal) > 9500) jedis.set("colloidal","95");
	   	    
	   	       coltsfoot      = jedis.get("coltsfoot");       
	   	       if (new Integer(coltsfoot) > 9500) jedis.set("coltsfoot","118");
	   	       
	   	       comfrey        = jedis.get("comfrey");        
	   	       if (new Integer(comfrey) > 9500) jedis.set("comfrey","109");
	   	    
	   	       countryMallow  = jedis.get("country mallow");
	   	       if (new Integer(countryMallow) > 9500) jedis.set("country mallow","355");
	   	    
	   	       germanium      = jedis.get("germanium");       
	   	       if (new Integer(germanium) > 9500) jedis.set("germanium","10");
	   	    
	   	       kava           = jedis.get("kava");            
	   	       if (new Integer(kava) > 9500) jedis.set("kava","111");
	   	       
	   	       lobelia        = jedis.get("lobelia");         
	   	       if (new Integer(lobelia) > 9500) jedis.set("lobelia","222");
	   	    
	   	       yohimbe        = jedis.get("yohimbe");  
	   	       if (new Integer(yohimbe) > 9500) jedis.set("yohimbe","312");
	   	    
	   	       gingko         = "1208";
	           
	           session.getRemote().sendString("aconite:" + aconite);
	           session.getRemote().sendString("bitterOrange:" + bitterOrange);
	           session.getRemote().sendString("chaparral:" + chaparral);
	           session.getRemote().sendString("colloidal:" + colloidal);
	           session.getRemote().sendString("coltsfoot:" + coltsfoot);
	           session.getRemote().sendString("comfrey:" + comfrey);
	           session.getRemote().sendString("countryMallow:" + countryMallow);
	           session.getRemote().sendString("germanium:" + germanium);
	           session.getRemote().sendString("kava:" + kava);
	           session.getRemote().sendString("lobelia:" + lobelia);
	           session.getRemote().sendString("yohimbe:" + yohimbe);
	           session.getRemote().sendString("gingko:" + gingko);
           }
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        } catch (Exception e)
		{
			
			e.printStackTrace();
		}
    }

    @OnWebSocketMessage
    public void onMessage(String message) 
    {
        System.out.println("TweetCountFetcher:onMessage => Message: " + message);
    }
}

	
	
	
	
	