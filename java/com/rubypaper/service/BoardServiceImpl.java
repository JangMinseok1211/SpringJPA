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
		private BoardRepository  boardRepository;
		public void insertBoard(Board board) {
			boardRepository.save(board);   //영속캐싱영역으로 들어가게함		
		}
		public void updateBoard(Board board) {
			Board findBoard = boardRepository.findById(board.getSeq()).get();
			findBoard.setTitle(board.getTitle());
			findBoard.setContent(board.getContent());
			boardRepository.save(findBoard);		
		}	
		public void deleteBoard(Board board) {
			boardRepository.deleteById(board.getSeq());		
		}	
		public Board getBoard(Board board) {		
			return boardRepository.findById(board.getSeq()).get();
		}
		@Override
		public List<Board> getBoardList(Board board) {
			return (List<Board>)boardRepository.findAll();
			//PSQL이 만들어짐
		}
	}

