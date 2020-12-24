package com.min.edu;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.min.edu.dto.AnswerboardDto;
import com.min.edu.dto.MemberDto;
import com.min.edu.model.service.IBoardService;
import com.min.edu.model.service.IMemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("loginDto")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	//테스트 브런치 생성후 commit and push
	//하나더!
	@Autowired
	private IBoardService iService;
	
	@Autowired
	private IMemberService mService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/movetoBoard.do", method = RequestMethod.GET)
	public String movetoBoard(Model model, HttpSession session ) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", "null");
		List<AnswerboardDto> list = (List<AnswerboardDto>) iService.selectDynamic(null);
		
		model.addAttribute("lists", list);
		
		return "board";
	}
	@RequestMapping(value = "/detailBoard.do", method = RequestMethod.GET)
	public String detailBoard(String seq, Model model) {
		
		System.out.println("welcome detailBoard");
		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", seq);
		List<AnswerboardDto> list = (List<AnswerboardDto>) iService.selectDynamic(map);
		
		model.addAttribute("lists", list.get(0));
		
		return "detailBoard";
	}
	
	@RequestMapping(value = "/modifyFinish.do", method = RequestMethod.GET)
	public String modifyFinish(String seq, String content, Model model) {
		
		System.out.println("welcome modifyFinish");
		Map<String, String> map = new HashMap<String, String>();
		System.out.println("받은 content의 값 : "+content);
		map.put("seq", seq);
		map.put("content" , content);
		boolean isc = iService.modifyBoard(map);
		System.out.println("isc : "+isc);
		if(isc) {
			List<AnswerboardDto> list = (List<AnswerboardDto>) iService.selectDynamic(map);
			System.out.println("list : " +list.get(0));

			model.addAttribute("lists", list.get(0));
			return "detailBoard";
		}else {
			return "redirect:/movetoBoard.do";
		}
	}
	
	
	@RequestMapping(value = "/reply.do", method = RequestMethod.GET)
	public String reply(String seq,String content, String id, String title, Model model) {
		
		System.out.println("welcome detailBoard");
		
		AnswerboardDto adto = new AnswerboardDto( id,  title, content);
		adto.setSeq(seq);
		iService.reply(adto);
		
		return "redirect:/movetoBoard.do";
	}
	
	@RequestMapping(value ="/multiDel.do", method = RequestMethod.POST)
	public String multiDel( String[] chkval ) {
		logger.info("welcom multiDel.do 결과 : \t {}" , chkval);
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", chkval);
		boolean isc = iService.multiDelete2(map);
		return "redirect:/movetoBoard.do";
//		return null;
	}
	
	@RequestMapping(value = "/writeForm.do", method = RequestMethod.GET)
	public String writeForm(Model model) {
		//원래대로면 세션도 줘서 세션정보로 작성할텐데 딱히 로그인 내역은 안적혀 있어서 아이디는 USER02로 통일하였습니다.
		System.out.println("welcome writeForm");
		return "writeForm";
	}
	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public String write(Model model, AnswerboardDto dto) {
		//원래대로면 세션도 줘서 세션정보로 작성할텐데 딱히 로그인 내역은 안적혀 있어서 아이디는 USER02로 통일하였습니다.
		System.out.println("welcome write : " + dto.toString());
		
		
		iService.insertBoard(dto);
		
		return "redirect:/movetoBoard.do";
	}
	
	
	@RequestMapping(value = "/login.do", method =RequestMethod.POST)
	public String login(Model model , @RequestParam Map<String, String> map) {
		logger.info("welcom login.do dto: \t {}" , map);
		
		
		
		MemberDto loginDto= mService.loginMember(map);
		
		model.addAttribute("loginDto", loginDto);
		logger.info("addAttribute finish: \t {}" , loginDto);
		return "redirect:/movetoBoard.do";
	}
	
	@RequestMapping(value = "/signup.do", method =RequestMethod.POST)
	public String signup(Model model, MemberDto dto) {
		System.out.println(dto.toString());
		logger.info("welcom signup.do dto: \t {}" , dto);
		
		mService.signUpMember(dto);
		
		return "redirect:/movetoBoard.do";
	}
	
	@RequestMapping(value = "/signupForm.do", method =RequestMethod.GET)
	public String signInForm(Model model) {
		
		
		return "signupForm";
	}
	
	@RequestMapping(value ="/logout.do", method = RequestMethod.GET)
	public String Logout(Model model, SessionStatus sessionStatus, HttpSession session) {
		System.out.println("before : "+session.getAttribute("loginDto"));
		sessionStatus.setComplete();
		System.out.println("after : "+session.getAttribute("loginDto"));
		session.invalidate();
		return  "redirect:/movetoBoard.do";
		
	}
}
