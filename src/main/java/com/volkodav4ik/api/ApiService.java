package com.volkodav4ik.api;

import com.google.gson.Gson;
import com.volkodav4ik.Const;
import com.volkodav4ik.model.Picture;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApiService {

    private static ApiService instance;

    public static synchronized ApiService getInstance() {
        if (instance == null) {
            instance = new ApiService();
        }
        return instance;
    }

    private static String pictureToJson(Picture picture) {
        Gson gson = new Gson();
        return gson.toJson(picture);

    }

    public void addImageToDataBase(String fileName) throws IOException {
        File image = new File(Const.FOLDER_WITH_IMAGES
                + File.separator
                + fileName);
        if (image.isFile()) {
            Picture picture = new Picture(fileName);
            String jsonBody = pictureToJson(picture);
            OkHttpClient client = new OkHttpClient()
                    .newBuilder()
                    .connectTimeout(5, TimeUnit.MINUTES)
                    .writeTimeout(5, TimeUnit.MINUTES)
                    .readTimeout(5, TimeUnit.MINUTES)
                    .build();
            MediaType mediaType = MediaType.parse(Const.BODY_VALUE);
            RequestBody body = RequestBody.create(mediaType, jsonBody);
            Request request = new Request.Builder()
                    .url(Const.URL_ADD_REQUEST)
                    .method(Const.POST, body)
                    .addHeader(Const.HEADER_NAME, Const.BODY_VALUE)
                    .build();
            Response response = client.newCall(request).execute();
            if (response.code() == Const.OK || response.code() == Const.BAD_REQUEST) {
                String result = response.body().string();
                System.out.println(result);
            } else {
                System.out.println(Const.FAIL_RESULT);
            }
        } else {
            System.out.println("Probably, you mentioned wrong file name");
        }
    }

    public void showAllAvailableImageInDirectory(String path) {
        File folder = new File(path);
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }

}
