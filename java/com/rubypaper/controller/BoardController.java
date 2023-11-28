package com.rubypaper.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.rubypaper.domain.Board;
import com.rubypaper.service.BoardService;

@Controller
public class BoardController {
	@Autowired
    private BoardService boardService;
	//글목록보기
	@RequestMapping("/getBoardList")
    public String getBoardList(Board board, Model model) {
    	    	
    	model.addAttribute("boardList", boardService.getBoardList(board));
    	return "getBoardList";
    }
	//삽입 글등록 method="get"
	@GetMapping("/insertBoard")
	public String insertBoard() {
		return "insertBoard";
	}
	@PostMapping("insertBoard")
    public String insertBoardp(Board board, @RequestBody MultipartFile uploadFile)
	throws Exception{
		
		String fileName =uploadFile.getOriginalFilename();
		uploadFile.transferTo(new File("C:/spring/workspace2/A31/files/"+fileName));
		boardService.insertBoard(board);
		
		return "forward:getBoardList";
	}
	//글상세 페이지 
	@RequestMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		
		return "getBoard";
	}
	//글 수정
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	//글 삭제 
    @GetMapping("/deleteBoard")
    public String deleteBoard(Board board) {
    	boardService.deleteBoard(board);
    	return "forward:getBoardList";
    } 
	
    	
}






