package com.green.shoppingmall.utils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class FileUtils {
    //확장자 리턴하는 메소드
    public static String getExt(String fileNm) { // abcd.123.hhh.jpg
        return fileNm.substring(fileNm.lastIndexOf(".") + 1);
    }

    //파일명만 리턴하는 메소드
    public static String getFileNm(String fileNm) {
        return fileNm.substring(0, fileNm.lastIndexOf("."));
    }

    // UUID 이용, 랜덤값 파일명 리턴
    public static String makeRandomFileNm(String fileNm) {
        return UUID.randomUUID() + "." +  getExt(fileNm);
    }

    public static String getAbsolutePath(String path) {
        Path p = Paths.get(path);
        return p.toFile().getAbsolutePath();
    }


}