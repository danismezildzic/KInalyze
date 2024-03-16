package at.htlleonding.Kinalyze.Controller;

import at.htlleonding.Kinalyze.Entity.AnalyzedDataEntity;
import at.htlleonding.Kinalyze.Entity.FileEntity;
import at.htlleonding.Kinalyze.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FileController {
    private final FileService fileEntityService;

    @Autowired
    public FileController(FileService fileEntityService) {
        this.fileEntityService = fileEntityService;
    }

    @PostMapping("/upload/{uuid}/{fileName}")
    public ResponseEntity<String> uploadFile(@RequestBody FileEntity requestBody, @PathVariable String uuid, @PathVariable String fileName) {
        System.out.println(requestBody.toString());
        fileEntityService.saveFileEntity(requestBody);

        return ResponseEntity.ok(requestBody.toString());
    }

    @GetMapping("/file/{uid}")
    public ResponseEntity<FileEntity> getFileByUID(@PathVariable String uid) {
        FileEntity fileEntity = fileEntityService.getFileByUID(uid);
        System.out.println(fileEntity);
        if (fileEntity != null && fileEntity.getFile_name() != null) {
            return ResponseEntity.ok(fileEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/file/all")
    public ResponseEntity<List<FileEntity>> getAllFiles() {
        List<FileEntity> allFiles = fileEntityService.getAllFiles();
        System.out.println(allFiles);
        if (!allFiles.isEmpty()) {
            return ResponseEntity.ok(allFiles);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @GetMapping("/analyzed/all")
    public ResponseEntity<List<AnalyzedDataEntity>> getAllAnalyzedData() {
        List<AnalyzedDataEntity> allAnalyzedData = fileEntityService.getAllAnalyzedData();
        System.out.println(allAnalyzedData);
        if (!allAnalyzedData.isEmpty()) {
            return ResponseEntity.ok(allAnalyzedData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
