package ru.sapteh;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Program {
    public static void main(String[] args) throws IOException {

        BufferedReader pathArchiv = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь архива");
        String pathArchive = pathArchiv.readLine();

        BufferedReader nameArchive = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите название архива с расширение");
        String archive = nameArchive.readLine();

        FileOutputStream zipArchive = new FileOutputStream(pathArchive+"/"+archive);
        ZipOutputStream zip = new ZipOutputStream(zipArchive);
//        zip.putNextEntry(new ZipEntry());
//
//        Path pathFile = Paths.get(  );
//        Files.copy(pathFile,zip);


        BufferedReader readURL = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите URL картинки");

        String urlRead = readURL.readLine();
        URL urlPicture = new URL(urlRead);
        InputStream pictures = urlPicture.openStream();

        BufferedReader readNamePictures = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите название картинки с расширением");
        String picturesRead = readNamePictures.readLine();

        Path pathPictures = Paths.get("D:/42tJava"+ File.separator + picturesRead);
        Files.copy(pictures,pathPictures);

        zip.putNextEntry(new ZipEntry(picturesRead));
        Files.copy(pathPictures,zip);

        zip.close();
        File file = new File(String.valueOf(pathPictures));

        if (zip.equals(" ")){
            System.out.println("Сохранение не прошло успешным");
        }else
            System.out.println("Картинка сохранена");

        Desktop desktop = null;
        if (Desktop.isDesktopSupported()){
            desktop = Desktop.getDesktop();
        }
        try {
            desktop.open(file);
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
