package Dapeng.DataHubService.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("datahub")
public class UploadController {
    @GetMapping("test")
    public ResponseEntity test(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
