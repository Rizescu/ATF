package Util;

import java.io.File;

public class CreationFolderIfNotExists {
    public static void  createDirectoryIfNotExists(String filePath){
        File f = new File(filePath);
        f.mkdir();
    }

}
