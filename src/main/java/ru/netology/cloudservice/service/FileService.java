package ru.netology.cloudservice.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@EnableJpaRepositories
public class FileService {

    @Autowired
    @Qualifier("fileRepository")
    private final FileRepository fileRepository;


}
