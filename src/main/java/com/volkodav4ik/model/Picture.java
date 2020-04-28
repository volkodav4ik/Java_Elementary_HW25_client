package com.volkodav4ik.model;

import com.volkodav4ik.Const;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class Picture {

    private int id;

    private String pictureFileName;

    private String base64;

    public Picture() {
    }

    public Picture(String pictureFileName) throws IOException {
        this.pictureFileName = pictureFileName;
        this.base64 = imageToBase64(pictureFileName);
    }

    private String imageToBase64(String pictureFileName) throws IOException {
        byte[] fileContent = FileUtils.readFileToByteArray(new File(Const.FOLDER_WITH_IMAGES
                + File.separator
                + pictureFileName));
        return Base64.getEncoder().encodeToString(fileContent);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPictureFileName() {
        return pictureFileName;
    }

    public void setPictureFileName(String pictureFileName) {
        this.pictureFileName = pictureFileName;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", pictureFileName='" + pictureFileName + '\'' +
                ", base64='" + base64 + '\'' +
                '}';
    }
}
