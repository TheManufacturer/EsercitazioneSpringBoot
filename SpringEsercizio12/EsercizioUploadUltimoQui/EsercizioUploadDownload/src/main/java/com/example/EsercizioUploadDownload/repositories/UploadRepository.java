package com.example.EsercizioUploadDownload.repositories;

import com.example.EsercizioUploadDownload.entities.UploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadRepository extends JpaRepository<UploadEntity, Long> {
}
