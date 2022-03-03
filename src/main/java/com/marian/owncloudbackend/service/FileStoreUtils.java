package com.marian.owncloudbackend.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class FileStoreUtils {

    private static final String DEFAULT_DIR_NAME = "OwnCloud";

    public static void makeBaseDir() {
        File userDirectory = FileUtils.getUserDirectory();
        Path defaultDirectoryPath = Path.of(userDirectory.getAbsolutePath(),DEFAULT_DIR_NAME);
        File defaultDirectory = new File(defaultDirectoryPath.toString());
        if (!defaultDirectory.exists()) {
            boolean creationSuccess = defaultDirectory.mkdir();
            if (creationSuccess){
                log.info("Default dir created successfully");
            }else log.error("Default dir creation error");
            return;
        }

        log.info("Default dir has been found successfully");


    }

    public static String getBaseDir() {
        File userDirectory = FileUtils.getUserDirectory();
        String absolutePath = userDirectory.getAbsolutePath();
        return Paths.get(absolutePath,DEFAULT_DIR_NAME).toString();
    }

    public void saveNewFile(MultipartFile file, String path) {

    }
}