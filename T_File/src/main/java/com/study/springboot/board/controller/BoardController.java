package com.study.springboot.board.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.study.springboot.board.dto.BoardDto;
import com.study.springboot.board.dto.BoardFileDto;
import com.study.springboot.board.service.BoardService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class BoardController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/board/openBoardList.do")
	public ModelAndView openBoardList() throws Exception{
		ModelAndView mv = new ModelAndView("/board/boardList");
		log.debug("openBoardList");
		List<BoardDto> list = boardService.selectBoardList();
		mv.addObject("list",list);
		
		return mv;
	}
	
	@RequestMapping("/board/openBoardWrite.do")
	public String openBoardWrite() throws Exception{
		return "/board/boardWrite";
	}
	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(BoardDto board,MultipartHttpServletRequest multipartHttpServletRequest ) throws Exception{
		boardService.insertBoard(board,multipartHttpServletRequest);
		return "redirect:/board/openBoardList.do";
	}
	@RequestMapping("/board/openBoardDetail.do")
	public ModelAndView openBoardDetail(@RequestParam("boardIdx") int boardIdx) throws Exception{
		ModelAndView mv = new ModelAndView("/board/boardDetail");
		
		BoardDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board",board);
		
		return mv;
		
	}
	@RequestMapping("/board/updateBoard.do")
	public String updateBoard(BoardDto board) throws Exception{
		boardService.updateBoard(board);
		return "redirect:/board/openBoardList.do";
	}
	
	@RequestMapping("/board/deleteBoard.do")
	public String deleteBoard(@RequestParam("boardIdx") int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		return "redirect:/board/openBoardList.do";
	}
	
	@RequestMapping("/board/downloadBoardFile.do")
	public void downloadBoardFile(@RequestParam("idx") int idx, @RequestParam("boardIdx") int boardIdx, HttpServletResponse response) throws Exception{
		BoardFileDto boardFile = boardService.selectBoardFileInformation(idx, boardIdx);
		if(ObjectUtils.isEmpty(boardFile)==false) {	
			String fileName = boardFile.getOriginalFileName();
			
			byte[] files = FileUtils.readFileToByteArray(new File(boardFile.getStoredFilePath()));
			
			response.setContentType("application/octet-stream");
			response.setContentLengthLong(files.length);
			response.setHeader("Content-Disposition","attachment; fileName=\""+URLEncoder.encode(fileName,"UTF-8")+"\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			
			response.getOutputStream().write(files);
			response.getOutputStream().flush();
			response.getOutputStream().close();
	}
  }
	
}
