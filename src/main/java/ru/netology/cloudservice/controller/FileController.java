package ru.netology.cloudservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.cloudservice.models.AuthRequest;
import ru.netology.cloudservice.service.FileService;


@RestController
@AllArgsConstructor
public class FileController {

    @Autowired
    private final FileService fileService;

    @PostMapping(value = "/file")
    public ResponseEntity<?> saveFile(@RequestBody AuthRequest authRequest) {

    }

    @DeleteMapping(value = "/file")
    public ResponseEntity<?> deleteFile(@RequestBody AuthRequest authRequest){

    }

    @GetMapping(value = "/file")
    public ResponseEntity<?> getFile(@RequestBody AuthRequest authRequest){

    }

    @PutMapping(value = "/file")
    public ResponseEntity<?> putFile(@RequestBody AuthRequest authRequest){

    }

    @GetMapping(value = "/list")
    public ResponseEntity<?> getListFile(@RequestBody AuthRequest authRequest){

    }

}
