package at.htlleonding.Kinalyze.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {
    @PostMapping("/api/upload/{userId}/{fileName}")
    public ResponseEntity<String> uploadFile(@PathVariable String userId, @PathVariable String fileName) {
        // Your logic to handle the file upload
        // userId and fileName can be accessed within this method

        // Return an appropriate response
        return ResponseEntity.ok("File uploaded successfully");
    }
}
