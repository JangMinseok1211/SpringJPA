package com.rubypaper.service;
import java.util.List;
import com.rubypaper.domain.Board;

public interface BoardService {
  public void insertBoard(Board board);
  public void updateBoard(Board board);
  public void deleteBoard(Board board);
  public Board getBoard(Board board);
  public List<Board> getBoardList(Board board);  
}
