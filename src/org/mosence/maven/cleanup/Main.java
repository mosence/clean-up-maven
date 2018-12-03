package org.mosence.maven.cleanup;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        final String mavenRepositoryPath = "C:\\Users\\MoSence\\.m2";
        File f = new File(mavenRepositoryPath);
        MavenClean clean = new MavenClean();
        int flag = 0;
        do {
            flag = clean.cleanLastUpdate(f);
            System.out.println("删除lastUpdate文件 " + flag + "个！");
        } while (flag != 0);
        do {
            flag = clean.cleanJavaDoc(f);
            System.out.println("删除javaDoc & check文件 " + flag + "个！");
        } while (flag != 0);
        do {
            flag = clean.cleanSources(f);
            System.out.println("删除sources & check文件 " + flag + "个！");
        } while (flag != 0);
        do {
            flag = clean.cleanEmptyDirectory(f);
            System.out.println("删除空文件夹 " + flag + "个！");
        } while (flag != 0);
    }
}
