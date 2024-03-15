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

    @PostMapping("/upload/{uuid}/{fileName}")
    public ResponseEntity<String> uploadFile(@RequestBody FileEntity requestBody, @PathVariable String uuid, @PathVariable String fileName) {
        System.out.println(requestBody.toString());
        fileEntityService.saveFileEntity(requestBody);

        return ResponseEntity.ok(requestBody.toString());
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
