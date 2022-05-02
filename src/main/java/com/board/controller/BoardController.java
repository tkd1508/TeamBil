package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.service.BoardService;
import com.board.vo.BoardVO;
import com.board.vo.Cirteria;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;

//	 @GetMapping("/list")
//	 public void list(Model model) {
//	
//	 log.info("list");
//	 model.addAttribute("list", service.list());
//	
//	 }
		
	 @GetMapping("/list")
	 public void list(@RequestParam(value="pstartno", defaultValue="0") int pstartno, Model model) {
	
		 model.addAttribute("list", service.getListWithPaging(pstartno)); // 책 p.300 list 동일
		 model.addAttribute("paging", new Cirteria(pstartno, service.listSum())); // 
			
	 }
	 
/*
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {

		log.info("list: " + cri);
		model.addAttribute("list", service.getList(cri));
		// model.addAttribute("pageMaker", new PageDTO(cri, 123));

		int total = service.getTotal(cri);

		log.info("total: " + total);

		model.addAttribute("pageMaker", new PageDTO(cri, total));

	}
*/
	 
	@GetMapping("/register") public void register() {  }
	 
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {

		log.info("register: " + board);

		service.register(board);

		rttr.addFlashAttribute("result", "등록");
		
		return "redirect:/board/list";
	}

	 @GetMapping({ "/get", "/modify" }) // @Get매핑 Post맵핑은 URL을 배열로 처리할 수 있기 때문에 여러 URL 설정 처리 가능하다.
	 public void get(@RequestParam("bno") int bno, @RequestParam(value="pstartno", defaultValue="0") int pstartno, Model model) {
	
	 log.info("/get or modify ");
	 model.addAttribute("board", service.get(bno));
	 model.addAttribute("paging", new Cirteria(pstartno, service.listSum())); // 조회 후 되돌아기 클릭시 paging 기억하기
	 }
/*
	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {

		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}
*/
	 @PostMapping("/modify")
	 public String modify(BoardVO board, RedirectAttributes rttr) {
	 log.info("modify:" + board);
	
	 if (service.modify(board)) {
	 rttr.addFlashAttribute("result", "수정");
	 }
	 return "redirect:/board/list";
	 }
/*
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify:" + board);

		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}

		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());

		return "redirect:/board/list";
	}
*/
	 @PostMapping("/remove")
	 public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr)
	 {
	
	 log.info("remove..." + bno);
	 if (service.remove(bno)) {
	 rttr.addFlashAttribute("result", "삭제");
	 }
	 return "redirect:/board/list";
	 }
/*
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, Criteria cri, RedirectAttributes rttr) {

		log.info("remove..." + bno);
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());

		return "redirect:/board/list";
	}
*/
}
