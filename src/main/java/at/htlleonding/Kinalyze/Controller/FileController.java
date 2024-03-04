package at.htlleonding.Kinalyze.Controller;

import at.htlleonding.Kinalyze.Entity.FileEntity;
import at.htlleonding.Kinalyze.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FileController {
    private final FileService fileEntityService;

    @Autowired
    public FileController(FileService fileEntityService) {
        this.fileEntityService = fileEntityService;
    }
    @PostMapping("/upload/{userId}/{fileName}")
    public ResponseEntity<String> uploadFile(@PathVariable String userId, @PathVariable String fileName) {

        return ResponseEntity.ok("File uploaded successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<FileEntity>> getAllFiles() {
        List<FileEntity> allFiles = fileEntityService.getAllFiles();

        if (!allFiles.isEmpty()) {
            return ResponseEntity.ok(allFiles);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}/{fileName}")
    public ResponseEntity<FileEntity> getFileByIdAndFileName(
            @PathVariable String id,
            @PathVariable String fileName) {
        FileEntity fileEntity = fileEntityService.getFileByIdAndFileName(id, fileName);

        if (fileEntity != null) {
            return ResponseEntity.ok(fileEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
