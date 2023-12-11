package ru.netology.cloudservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.netology.cloudservice.models.FileInfo;
import ru.netology.cloudservice.service.FileService;

import java.io.IOException;


@RestController
@AllArgsConstructor
@RequestMapping
public class FileController {

    @Autowired
    private final FileService fileService;

    @PostMapping(value = "/file")
    public ResponseEntity<?> saveFile(@RequestParam("filename") String fileName, @RequestBody MultipartFile file) throws IOException {
        fileService.upload(fileName, file);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/file")
    public ResponseEntity<?> deleteFile(@RequestParam("filename") String fileName) throws IOException {
        fileService.delete(fileName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/file")
    public ResponseEntity<?> getFile(@RequestParam("filename") String fileName) throws IOException {
        FileInfo file = fileService.getFile(fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(file.getData());
    }

    @PutMapping(value = "/file")
    public ResponseEntity<?> updateFileName (@RequestParam("filename") String fileName,
                @RequestBody String newFileName) throws IOException {
        return new ResponseEntity<>(fileService.updateFileName(fileName, newFileName), HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<?> getListFile(@RequestParam("limit") int limit) {
            return new ResponseEntity<>(fileService.show(limit), HttpStatus.OK);
    }

}
