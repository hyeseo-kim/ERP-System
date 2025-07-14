package com.algorizo.erp.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.algorizo.erp.company.CompanyDTO;

@Controller
public class BoardController {
	
	@Inject
	BoardService boardService;
	
	@GetMapping(value="board/register")
	public String register(HttpSession session) {
		
		session.getAttribute("m_name");
		session.getAttribute("team");
		
		return "board/boardRegister";
	}
	
	@PostMapping(value="board/register")
	public String register(BoardDTO boardDTO, HttpSession session, Model model) {
		if (session.getAttribute("m_id") == null) {
			return "redirect:/"; // ✅ 세션 없으면 로그인 페이지로 리다이렉트
		}
		
		boardService.register(boardDTO);
		
		return "redirect:/board/list";
		
		
	}
	
	@GetMapping(value="board/list")
	public String list(HttpSession session, Model model) {
		if (session.getAttribute("m_id") == null) { 
	        return "redirect:/";  // ✅ 세션 없으면 로그인 페이지로 리다이렉트
	    }
		List<BoardDTO> boardList=boardService.list();
		model.addAttribute("list", boardList);
		
		return "board/boardList";
	}
	
	@GetMapping(value="board/detail")
	public String detail(HttpSession session, Model model, @RequestParam("b_id") int b_id) {
		if (session.getAttribute("m_id") == null) { 
	        return "redirect:/";  // ✅ 세션 없으면 로그인 페이지로 리다이렉트
	    }
		BoardDTO board = boardService.detail(b_id);
		model.addAttribute("board", board);
		
		return "board/boardDetail";
	}
	
	@GetMapping(value="board/delete")
	public String delete(@RequestParam("b_id") int b_id) {
		boardService.delete(b_id);
		return "redirect:/board/list";
	}
	
	@GetMapping(value = "board/update")
	public String update(@RequestParam("b_id") int b_id, Model model) {
		BoardDTO board = boardService.detail(b_id);
		model.addAttribute("board",board);
		return "board/boardUpdate";
	}
	
	@PostMapping(value = "board/update")
	public String update(BoardDTO board) {
		boardService.update(board);
		return "redirect:/board/list";
	}
	
}
