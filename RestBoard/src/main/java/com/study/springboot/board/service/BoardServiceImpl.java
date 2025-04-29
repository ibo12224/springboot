package com.study.springboot.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.study.springboot.board.common.FileUtils;
import com.study.springboot.board.dto.BoardDto;
import com.study.springboot.board.dto.BoardFileDto;
import com.study.springboot.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private FileUtils fileUtils;
	@Override
	public List<BoardDto> selectBoardList() throws Exception{
		return boardMapper.selectBoardList();
	}
	@Override
	public void insertBoard(BoardDto board,MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
		
		boardMapper.insertBoard(board);
		List<BoardFileDto> list = fileUtils.parseFileInfo(board.getBoardIdx(),multipartHttpServletRequest);
		if(CollectionUtils.isEmpty(list)==false) {
			boardMapper.insertBoardFileList(list);
		}
//	if(ObjectUtils.isEmpty(multipartHttpServletRequest)==false) {
//		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
//		String name;
//		while(iterator.hasNext()) {
//			name=iterator.next();
//			log.debug("file tag name : "+name);
//			List<MultipartFile> list = multipartHttpServletRequest.getFiles(name);
////			for(MultipartFile multipartFile : list) {
////				log.debug("start file infomation");
////				log.debug("file name : "+multipartFile.getOriginalFilename());
////				log.debug("file size : "+multipartFile.getSize());
////				log.debug("file content type : "+multipartFile.getContentType());
////				log.debug("end file infomation.\n");
////			}
//		}
//	}
	}
	
	@Override
	public void updateHitCount(int boardIdx) throws Exception {
		boardMapper.updateHitCount(boardIdx);
	}
	
	@Override
	public BoardDto selectBoardDetail(int boardIdx) throws Exception{
		//boardMapper.updateHitCount(boardIdx);
		
		BoardDto board = boardMapper.selectBoardDetail(boardIdx);
		List<BoardFileDto> fileList = boardMapper.selectBoardFileList(boardIdx);
		board.setFileList(fileList);
		boardMapper.updateHitCount(boardIdx);
		return board;
	}
	@Override
	public void updateBoard(BoardDto board) throws Exception {
		boardMapper.updateBoard(board);
	}
	@Override
	public void deleteBoard(int boardIdx) throws Exception{
		boardMapper.deleteBoard(boardIdx);
	}
	public BoardFileDto selectBoardFileInformation(int idx, int boardIdx) throws Exception{
		return boardMapper.selectBoardFileInformation(idx,boardIdx);
	}
}
