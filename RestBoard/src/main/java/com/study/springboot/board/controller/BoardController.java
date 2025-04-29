package com.study.springboot.board.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.filter.HiddenHttpMethodFilter;
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
	
	// @RequestMapping("/board/openBoardList.do")
	// @RequestMapping(value="/board", method=RequestMethod.GET)
	@GetMapping("/board")
	public ModelAndView openBoardList() throws Exception{
		ModelAndView mv = new ModelAndView("/board/restBoardList");
		log.debug("openBoardList");
		List<BoardDto> list = boardService.selectBoardList();
		mv.addObject("list",list);
		
		return mv;
	}
	
	// @RequestMapping("/board/openBoardWrite.do")
	// @RequestMapping(value="/board/write", method=RequestMethod.GET)
	@GetMapping("/board/write")
	public String openBoardWrite() throws Exception{
		return "/board/restBoardWrite";
	}
	
	// @RequestMapping("/board/insertBoard.do")
	// @RequestMapping(value="/board/write", method=RequestMethod.POST)
	@PostMapping("/board/write")
	public String insertBoard(BoardDto board,MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
		boardService.insertBoard(board,multipartHttpServletRequest);
		return "redirect:/board";
	}
	
	// @RequestMapping("/board/openBoardDetail.do")
	// @RequestMapping(value="/board/{boardIdx}", method=RequestMethod.GET)
	@GetMapping("/board/{boardIdx}")
	public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception{
		ModelAndView mv = new ModelAndView("/board/restBoardDetail");
		BoardDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board",board);
		
		return mv;
	}
	
	// @RequestMapping("/board/updateBoard.do")
	// @RequestMapping(value="/board/{boardIdx}", method=RequestMethod.PUT)
	@PutMapping("/board/{boardIdx}")
	public String updateBoard(BoardDto board) throws Exception{
		boardService.updateBoard(board);
		return "redirect:/board";
	}
	
	// @RequestMapping("/board/deleteBoard.do")
	// @RequestMapping(value="/board/{boardIdx}", method=RequestMethod.DELETE)
	@DeleteMapping("/board/{boardIdx}")
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		return "redirect:/board";
	}
	
	// @RequestMapping("/board/downloadBoardFile.do")
	// @RequestMapping(value="/board/file", method=RequestMethod.GET)
	@GetMapping("/board/file")
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
