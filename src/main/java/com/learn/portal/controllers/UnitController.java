package com.learn.portal.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.learn.portal.dto.UnitDto;
import com.learn.portal.dto.UserDto;
import com.learn.portal.service.FileService;
import com.learn.portal.service.UnitService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/unit")
public class UnitController {

	@Autowired
	private UnitService unitService;
	
	@Autowired
	private FileService fileService;
	
	@PostMapping("/{subjectId}")
	public ResponseEntity<UnitDto> createUnit(@RequestBody UnitDto unitDto, @PathVariable Integer subjectId){
		UnitDto createdUnit = this.unitService.createUnit(unitDto, subjectId);
		return new ResponseEntity<UnitDto>(createdUnit, HttpStatus.CREATED);	
	}
	
	@GetMapping("/allUnits")
	public ResponseEntity<List<UnitDto>> viewAllUnits(){
		List<UnitDto> unitDtos = this.unitService.viewAllUnits();
		return new ResponseEntity<List<UnitDto>>(unitDtos, HttpStatus.OK);
	}
	
	@GetMapping("/unitsBySubject/{subjectId}")
	public ResponseEntity<List<UnitDto>> viewUnitsBySubject(@PathVariable Integer subjectId){
		List<UnitDto> unitDtos = this.unitService.viewUnitsBySubject(subjectId);
		return new ResponseEntity<List<UnitDto>>(unitDtos, HttpStatus.OK);
	}
	
	@PostMapping("/notes_upload/{unitId}")
	public ResponseEntity<UnitDto> uploadNotes(@RequestParam("note") MultipartFile note,
			@PathVariable Integer unitId) throws IOException {

		UnitDto unitDto = this.unitService.getUnitById(unitId);
		String fileName = this.fileService.uploadNote(note);

		if(unitDto.getNotes()!=null) {
			List<String> unitNotes = unitDto.getNotes();
			unitNotes.add(fileName);
			unitDto.setNotes(unitNotes);
		}else {
			List<String> unitNotes = new ArrayList<>();
			unitNotes.add(fileName);
			unitDto.setNotes(unitNotes);
		}
		
		

		UnitDto updatedUnit= this.unitService.updateUnit(unitDto, unitId);
		return new ResponseEntity<UnitDto>(updatedUnit, HttpStatus.OK);
	}
	
	@GetMapping(value = "/notes/{note}", produces = MediaType.APPLICATION_PDF_VALUE)
	public void viewNote(@PathVariable String note, HttpServletResponse response) throws IOException {

		InputStream resource = this.fileService.getResource(note);
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}
	
	
	
}

