package com.example.EsercizioUploadDownload.entities;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UploadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filename;
    private String contentType;

    @Lob
    private byte[] data;

}
