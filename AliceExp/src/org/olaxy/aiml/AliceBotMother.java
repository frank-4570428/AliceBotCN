package org.olaxy.aiml;

import java.io.IOException;

import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.parser.AliceBotParser;
import bitoflife.chatterbean.parser.AliceBotParserConfigurationException;
import bitoflife.chatterbean.parser.AliceBotParserException;
import bitoflife.chatterbean.util.Searcher;

public class AliceBotMother {
	public static AliceBot aliceBot;
	static{
		try {
			aliceBot	= new AliceBotParser().parse(AliceBotMother.class.getResourceAsStream(
"/config/bots/context.xml"), AliceBotMother.class.getResourceAsStream(
"/config/bots/splitters.xml"), AliceBotMother.class.getResourceAsStream(
"/config/bots/substitutions.xml"), new Searcher().search(AliceBotMother.class.getResource("/"),"config/bots/alice", ".*\\.aiml"));
		} catch (AliceBotParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AliceBotParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
