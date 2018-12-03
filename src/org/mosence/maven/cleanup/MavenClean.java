package org.mosence.maven.cleanup;

import java.io.File;

/**
 * @author MoSence
 */
public class MavenClean {
    /**
     * 删除所有.lastUpdated结尾的文件
     *
     * @param f
     */
    public int cleanLastUpdate(File f) {
        int deleted = 0;
        if (f != null) {
            if (f.isFile() && f.getName().endsWith("lastUpdated")) {
                System.out.println("要删除的文件是：" + f.getAbsolutePath());
                f.delete();
                deleted++;
            }
            if (f.isDirectory()) {
                File[] fs = f.listFiles();
                for (File fItem : fs) {
                    deleted += cleanLastUpdate(fItem);
                }
            }
        }
        return deleted;
    }

    /**
     * 删除所有javaDoc
     *
     * @param f
     */
    public int cleanJavaDoc(File f) {
        int deleted = 0;
        if (f != null) {
            if (f.isFile() && f.getName().endsWith("-javadoc.jar") || f.getName().endsWith("-javadoc.jar.sha1")) {
                System.out.println("要删除的文件是：" + f.getAbsolutePath());
                f.delete();
                deleted++;
            }
            if (f.isDirectory()) {
                File[] fs = f.listFiles();
                for (File fItem : fs) {
                    deleted+=cleanJavaDoc(fItem);
                }
            }
        }
        return deleted;
    }

    /**
     * 删除所有srouces
     *
     * @param f
     */
    public int cleanSources(File f) {
        int deleted = 0;
        if (f != null) {
            if (f.isFile() && f.getName().endsWith("-sources.jar") || f.getName().endsWith("-sources.jar.sha1")) {
                System.out.println("要删除的文件是：" + f.getAbsolutePath());
                f.delete();
                deleted++;
            }
            if (f.isDirectory()) {
                File[] fs = f.listFiles();
                for (File fItem : fs) {
                    deleted+=cleanSources(fItem);
                }
            }
        }
        return deleted;
    }

    /**
     * 删除所有的空文件夹
     *
     * @param f
     */
    public int cleanEmptyDirectory(File f) {
        int deleted = 0;
        if (f != null && f.isDirectory()) {
            File[] fs = f.listFiles();
            if (fs.length == 0) {
                System.out.println(f.getAbsolutePath() + " 是空文件夹被删除");
                f.delete();
                deleted++;
            } else {
                for (File fc : fs) {
                    deleted+=cleanEmptyDirectory(fc);
                }
            }
        }
        return deleted;

    }
}
