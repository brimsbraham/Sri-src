package com.netjets

import grails.transaction.Transactional
import com.netjets.Airport
import java.util.List
import java.util.ArrayList
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

@Transactional
class AirportService {

    String list() {
	 Gson gson = new Gson();
	List<Airport> lstUser=new ArrayList<Airport>();
    
	String listData="";
	try{
	lstUser=Airport.list()
	JsonElement element = gson.toJsonTree(lstUser, new TypeToken<List<Airport>>() {}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				 listData=jsonArray.toString();
				listData="{\"Result\":\"OK\",\"Records\":"+listData+"}";
				}catch(Exception ex){
					 listData="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}"
					
					ex.printStackTrace()
					
				}	
				return listData
    }
	String create(String altAirport,String notes)
	{
	 Gson gson = new Gson();
	String listData=""
	try{
	  Airport airport=new Airport()
	  airport.alternateAirport=altAirport
	  airport.notes=notes
	  airport.save()
	  log.info "altAirport: ${altAirport},notes: ${notes}"
	
	def json="{\"id\":${airport.id},\"alternateAirport\":\"${airport.alternateAirport}\",\"notes\":\"${airport.notes}\"}"

	 log.info "json: ${json}"
	   listData="{\"Result\":\"OK\",\"Record\":"+json+"}";	
	    log.info "listData: ${listData}"
	}catch(Exception e)
	{
	 listData="{\"Result\":\"ERROR\",\"Message\":"+e.getStackTrace().toString()+"}";
	 e.printStackTrace()
	}
	return listData
	}
	
	String update( int id, String altAirport,String notes)
	{
	 
	String listData=""
	try{
	  Airport airport= Airport.get(id)
	  airport.alternateAirport=altAirport
	  airport.notes=notes
	  airport.save()
	  
	   listData="{\"Result\":\"OK\"}"	
	}catch(Exception e)
	{
	 listData="{\"Result\":\"ERROR\",\"Message\":"+e.getStackTrace().toString()+"}";
	 e.printStackTrace()
	}
	return listData
	}
	
	String delete( int id)
	{
	String listData=""
	try{
	  Airport airport= Airport.get(id)
	  	  airport.delete()
	  
	   listData="{\"Result\":\"OK\"}"	
	}catch(Exception e)
	{
	 listData="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
	 e.printStackTrace()
	}
	return listData
	}
}
