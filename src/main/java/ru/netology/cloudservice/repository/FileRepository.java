package ru.netology.cloudservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.cloudservice.models.FileInfo;
import ru.netology.cloudservice.models.User;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface FileRepository extends JpaRepository <FileInfo, Integer> {


    Optional<FileInfo> findByName(String name);

    void removeFileByName(String fileName);


    List<FileInfo> findAllFilesByUser(User user);

}
