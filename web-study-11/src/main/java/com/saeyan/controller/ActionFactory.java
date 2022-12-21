package com.saeyan.controller;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.BoardCheckPassAction;
import com.saeyan.controller.action.BoardCheckPassFormAction;
import com.saeyan.controller.action.BoardListAction;
import com.saeyan.controller.action.BoardUpdateFormAction;
import com.saeyan.controller.action.BoardViewAction;
import com.saeyan.controller.action.BoardWriteAction;
import com.saeyan.controller.action.BoardWriteFormAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {  //board_update_form
		Action action = null;
		System.out.println("ActoryFactory : " + command);
		
		if(command.equals("board_list")) {
			action = new BoardListAction();
		}else if(command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
		}else if(command.equals("board_write")) {
			action = new BoardWriteAction();
		}else if(command.equals("board_write")) {
			action = new BoardWriteAction();
		}else if(command.equals("board_view")) {
			action = new BoardViewAction();
		}else if(command.equals("board_check_pass_form")) {
			action = new BoardCheckPassFormAction();
		}else if(command.equals("board_check_pass")) {
			action = new BoardCheckPassAction();
		}else if(command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
		}
		return action;
	}
	
}
