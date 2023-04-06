package com.llr.im.mem.d_test;

import com.llr.im.mem.entity.Member;
import com.llr.im.mem.d_test.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/encrypt/{param}")
    public String encryptPW(@PathVariable String param) {

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("test");
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);

        String test = encryptor.encrypt(param);
        return test;
    }

    @GetMapping("/image")
    public String setImage() {
        return "image";
    }

    @GetMapping("/imageResult/{userId}")
    public String getBoard(@PathVariable String userId, Model model) {
        Member member = testService.findImage(userId);
        String imgPath = member.getFileName();
        log.info(imgPath);

        String absolutePath = new File("").getAbsolutePath() + "/";
        log.info("ab : {}", absolutePath);
        model.addAttribute("imgUrl",  imgPath);
        return "imageResult";
    }

    @GetMapping("/image/file/{userId}")
    public ResponseEntity<?> createImage(
            @PathVariable String userId, @Validated @RequestParam("file") MultipartFile file
    ) throws Exception {
        log.info("??????????????????????");
        testService.addBoard(userId, file);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/nav")
    public String test() {
        return "navbar";
    }

    @GetMapping("/room")
    public String testroom() {
        return "room/roomList";
    }
}
