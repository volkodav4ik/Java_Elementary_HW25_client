package com.volkodav4ik;

import com.volkodav4ik.api.ApiService;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        ApiService apiService = ApiService.getInstance();
        apiService.showAllAvailableImageInDirectory(Const.FOLDER_WITH_IMAGES);
        apiService.addImageToDataBase("cage.jpg");
        apiService.addImageToDataBase("you_cant_just.jpg");
        apiService.addImageToDataBase("shut_up.png");
        apiService.addImageToDataBase("programming.jpg");
        apiService.addImageToDataBase("python.jpg");

    }
}
