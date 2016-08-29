package org.conference.parser.conference.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.conference.parser.conference.talk.Talk;

public class Parser {
	
	private static final int LIGHTNING_MINUTES = 5;
	
	public List<Talk> parseFile (File file) throws NumberFormatException, IOException{
		
		BufferedReader reader = null;
		List<Talk>  tracks = new ArrayList<Talk>();		
		reader = new BufferedReader(new FileReader(file));
	    String talkTitle = null;

	    while ((talkTitle = reader.readLine()) != null) {
	    	Matcher matchMin = Pattern.compile("\\d+").matcher(talkTitle);
	    	Matcher matchLightning = Pattern.compile("lightning").matcher(talkTitle);
	    	if (matchMin.find()){
	    		tracks.add(new Talk(Integer.parseInt(matchMin.group()) , talkTitle));	    		
	    	} else if(matchLightning.find()){
	    		tracks.add(new Talk(LIGHTNING_MINUTES, talkTitle));
	    	}
	    }
	    reader.close();
		return tracks;
	}
}
