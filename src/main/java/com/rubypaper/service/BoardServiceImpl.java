package com.rubypaper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	public void insertBoard(Board board) {
		boardRepository.save(board); //영속캐싱영역으로 들어가게함

	}

	@Override
	public void updateBoard(Board board) {
		Board findBoard = boardRepository.findById(board.getSeq()).get();
		//optional 타입으로 받아오기 때문에 .get() 으로 Board 타입으로 받아온다
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		
		boardRepository.save(findBoard);

	}

	@Override
	public void deleteBoard(Board board) {
		boardRepository.deleteById(board.getSeq());

	}

	@Override
	public Board getBoard(Board board) {
		
		return boardRepository.findById(board.getSeq()).get();
	}

	@Override
	public List<Board> getBoardList(Board board) {
		//리턴 자료형으로 강제 형변환
		return (List<Board>)boardRepository.findAll(); //PSQL 이 만들어짐
	}

}
