package at.htlleonding.Kinalyze.Controller;

import at.htlleonding.Kinalyze.Entity.FileEntity;
import at.htlleonding.Kinalyze.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FileController {
    private final FileService fileEntityService;

    @Autowired
    public FileController(FileService fileEntityService) {
        this.fileEntityService = fileEntityService;
    }

    @PostMapping("/upload/{uuid}/{fileName}")
    public ResponseEntity<String> uploadFile(@PathVariable String uuid, @PathVariable String fileName, @RequestParam("file") MultipartFile file) {
        // Implement your file upload logic here
        String fileContent = null;
        try {
            fileContent = new String(file.getBytes(), StandardCharsets.US_ASCII);
        }
        catch (java.io.IOException e) {
            return ResponseEntity.badRequest().body("Invalid file");
        }
        System.out.println("File content: " + fileContent);

        return ResponseEntity.ok("File uploaded successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<FileEntity>> getAllFiles() {
        List<FileEntity> allFiles = fileEntityService.getAll();
        System.out.println(allFiles);
        if (!allFiles.isEmpty()) {
            return ResponseEntity.ok(allFiles);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
