package com.rubypaper.controller;

import java.io.File;
import java.io.IOException;

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
	@RequestMapping("/getBoardList")
	public String getBoardList(Board board,Model model) {
		model.addAttribute("boardList",boardService.getBoardList(board));
		return "getBoardList";
		
	}
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	
	//method="get" 페이지를 불러올때
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "insertBoard";
	}
	//method="post" form 에서 값을 post 로 넣을때
	@PostMapping("/insertBoard")
	public String insertBoard(Board board, @RequestBody MultipartFile uploadFile) {
		String fileName= uploadFile.getOriginalFilename();
	    String path = "C:/spring/workspace2/A31/files/" + fileName;
	    
	    try {
	        uploadFile.transferTo(new File(path));
	        boardService.insertBoard(board);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return "forward:getBoardList"; //forward:
	}
}
