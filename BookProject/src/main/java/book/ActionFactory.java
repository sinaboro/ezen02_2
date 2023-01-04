package book;

import member.IdCheckAction;
import member.IdCheckFormAction;
import member.MemberJoinAction;
import member.MemberJoinFormAction;
import member.MemberListAction;
import member.MemberLoginAction;
import member.MemberLoginFormAction;
import member.MemberLogoutAction;
import member.MemberMyPageAction;
import member.MemberMyPageFormAction;
import member.MemberTermsFormAction;
import member.MypageCheckPassAction;
import member.MypageCheckPassFormAction;
import member.MypageDeleteAction;
import member.MypageUpdateAction;
import member.MypageUpdateFormAction;
import member.UserDeleteAction;
import member.UserManagerAction;
import member.UserManagerFormAction;
import notice.DeleteNoticeAction;
import notice.NoticeListAction;
import notice.NoticeRegisterAction;
import notice.NoticeViewAction;
import notice.NoticeWriteFormAction;
import notice.UpdateNoticeAction;
import notice.UpdateNoticeFormAction;

public class ActionFactory {
	//페이지 이동을 위한 팩토리(커맨드 패턴으로 작업 처리를 위한 명령 처리 클래스가 있어야 한다.)
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
 
		if (command.equals("book_list")) {
			action = new BookListAction();
		} else if (command.equals("book_register_form")) {
			action = new BookRegisterFormAction();
		} else if (command.equals("book_register")) {
			action = new BookRegisterAction();
		} else if (command.equals("book_detail")) {
			action = new BookDetailAction();
		} else if (command.equals("book_update_form")) {
			action = new BookUpdateFormAction();
		} else if (command.equals("book_update")) {
			action = new BookUpdateAction();
		} else if (command.equals("book_delete")) {
			action = new BookDeleteAction();
		} else if (command.equals("member_list")) {
			action = new MemberListAction();
		} else if (command.equals("member_info_form")) {
			action = new UserManagerFormAction();
		} else if (command.equals("member_info")) {
			action = new UserManagerAction();
		} else if (command.equals("member_mypage_form")) {
			action = new MemberMyPageFormAction();
		} else if (command.equals("member_mypage")) {
			action = new MemberMyPageAction();
		} else if (command.equals("member_delete")) {
			action = new UserDeleteAction();
		} else if (command.equals("book_main")) {
			action = new BookMainAction();
		} else if (command.equals("member_login_form")) {
			action = new MemberLoginFormAction();
		} else if (command.equals("member_login")) {
			action = new MemberLoginAction();
		} else if (command.equals("book_category_viewer")) {
			action = new BookCategoryViewerAction();
		} else if (command.equals("member_join")) {
			action = new MemberJoinAction();
		} else if (command.equals("member_join_form")) {
			action = new MemberJoinFormAction();
		} else if (command.equals("id_check")) {
			action = new IdCheckAction();
		} else if (command.equals("id_check_form")) {
			action = new IdCheckFormAction();
		} else if (command.equals("mypage_update_form")) {
			action = new MypageUpdateFormAction();
		} else if (command.equals("mypage_update")) {
			action = new MypageUpdateAction();
		} else if (command.equals("member_logout")) {
			action = new MemberLogoutAction();
		} else if (command.equals("member_terms_form")) {
			action = new MemberTermsFormAction();
		} else if (command.equals("book_search")) {
			action = new BookSearchAction();
		} else if(command.equals("mypage_check_pass_form")) {
			action = new MypageCheckPassFormAction();
		} else if(command.equals("mypage_check_pass")) {
			action = new MypageCheckPassAction();
		} else if(command.equals("mypage_delete")) {
			action = new MypageDeleteAction();
		} else if (command.equals("notice_list")) {
			action = new NoticeListAction();
		} else if (command.equals("notice_write_form")) {
			action = new NoticeWriteFormAction();
		} else if (command.equals("notice_register")) {
			action = new NoticeRegisterAction();
		} else if (command.equals("notice_view")) {
			action = new NoticeViewAction();
		} else if (command.equals("update_notice_form")) {
			action = new UpdateNoticeFormAction();
		} else if (command.equals("update_notice")) {
			action = new UpdateNoticeAction();
		} else if (command.equals("delete_notice")) {
			action = new DeleteNoticeAction();
		} else if (command.equals("book_best")) {
			action = new BookBestFormAction();
		} else if (command.equals("book_new")) {
			action = new BookNewFormAction();
		}
			
		
		return action;
	}
}


