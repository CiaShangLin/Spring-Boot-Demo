package org.example.utils;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;


public class ImgurUploader {
    private static final String IMGUR_API_URL = "https://api.imgur.com/3/image";
    private static final String CLIENT_ID = "9d9ba49be7e4df4";

    public String uploadImage(MultipartFile file) throws IOException {
        // 將文件轉換為Base64編碼
        String base64Image = Base64.getEncoder().encodeToString(file.getBytes());

        // 設置請求頭
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Client-ID " + CLIENT_ID);

        // 設置請求體
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("image", base64Image);

        // 創建請求實體
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        // 發送POST請求
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ImgurResponse> response = restTemplate.postForEntity(
                IMGUR_API_URL,
                request,
                ImgurResponse.class
        );

        // 檢查響應並返回圖片鏈接
        if (response.getBody() != null && response.getBody().isSuccess()) {
            return response.getBody().getData().getLink();
        }

        throw new RuntimeException("圖片上傳失敗");
    }

    // Imgur API響應的數據結構
    private static class ImgurResponse {
        private boolean success;
        private ImgurData data;

        public boolean isSuccess() {
            return success;
        }

        public ImgurData getData() {
            return data;
        }
    }

    private static class ImgurData {
        private String link;

        public String getLink() {
            return link;
        }
    }
}