package nl.novi.springboot.first_demo.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

    private static final String storageLocation = "\\Users\\ewoud\\Documents\\SpringBootMap\\uploaded_files/";

    @RequestMapping(value = "/file-upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        multipartFile.transferTo(new File(storageLocation + multipartFile.getOriginalFilename()));
        return "File successfully uploaded!";
    }
}