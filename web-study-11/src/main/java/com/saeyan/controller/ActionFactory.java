package com.saeyan.controller;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.BoardListAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {  //board_list
		Action action = null;
		System.out.println("ActoryFactory : " + command);
		
		if(command.equals("board_list")) {
			action = new BoardListAction();
		}
		return action;
	}
	
}
