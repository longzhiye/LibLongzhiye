package com.longzhiye.android.lib.common.util;

import android.app.Activity;
import android.os.Environment;

import com.longzhiye.android.lib.config.AppConfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 文件工具类
 * Author: longzhiye
 * Date: 16-3-8
 * Time: 11:07
 */
public class FileUtil {

    private static final String TAG = FileUtil.class.getSimpleName();

    /**
     * 判断SD是否存在
     *
     * @return
     */
    public static boolean isSdcardExisting() {
        final String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param path 创建路径
     */
    public static void createPath(String path) {
        File file = new File(path);
        if (!file.exists()) {// 判断文件的路径是否存在
            // 按照指定的路径创建文件夹
            file.mkdirs();
        }
    }

    public static File updateDir = null;
    public static File updateFile = null;

    /**
     * 创建文件
     */
    public static void createFile(String name) {
        if (Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState())) {
            updateDir = new File(AppConfig.PROJECT_DOWNLOAD_PATH);
            updateFile = new File(updateDir + name + ".apk");

            if (!updateDir.exists()) {
                updateDir.mkdirs();
            }
            if (!updateFile.exists()) {
                try {
                    updateFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * byte转MB
     *
     * @param byteSize
     * @return
     */
    public static Double byteToMB(Long byteSize) {
        if (byteSize == null) {
            return 0.0;
        }
        Double doubleSize = (double) (byteSize / 1024 / 1024);
        return doubleSize;
    }

    /**
     * Mb转byte
     *
     * @param doubleSize
     * @return
     */
    public static Long MBtoByte(Double doubleSize) {
        if (doubleSize == null) {
            return (long) 0;
        }
        Long longSize = (long) (doubleSize * 1024 * 1024);
        return longSize;
    }

    public static String getFromAssets(Activity activity, String fileName) {
        try {
            InputStreamReader inputReader = new InputStreamReader(activity.getResources().getAssets().open(fileName));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line = "";
            String Result = "";
            while ((line = bufReader.readLine()) != null) {
                Result += line;
            }
            inputReader.close();
            bufReader.close();
            return Result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static File writeFile(InputStream is, String path, boolean isOverride) throws Exception {
        String sPath = extractFilePath(path);
        if (!pathExists(sPath)) {
            makeDir(sPath, true);
        }

        if (!isOverride && fileExists(path)) {
            if (path.contains(".")) {
                String suffix = path.substring(path.lastIndexOf("."));
                String pre = path.substring(0, path.lastIndexOf("."));
                path = pre + "_" + DateUtil.getNowTime() + suffix;
            } else {
                path = path + "_" + DateUtil.getNowTime();
            }
        }

        FileOutputStream os = null;
        File file = null;

        try {
            file = new File(path);
            os = new FileOutputStream(file);
            int byteCount = 0;
            byte[] bytes = new byte[1024];

            while ((byteCount = is.read(bytes)) != -1) {
                os.write(bytes, 0, byteCount);
            }
            os.flush();

            return file;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("写文件错误", e);
        } finally {
            try {
                if (os != null)
                    os.close();
                if (is != null)
                    is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建目录
     *
     * @param _sDir             目录名称
     * @param _bCreateParentDir 如果父目录不存在，是否创建父目录
     * @return
     */
    public static boolean makeDir(String _sDir, boolean _bCreateParentDir) {
        boolean zResult = false;
        File file = new File(_sDir);
        if (_bCreateParentDir)
            zResult = file.mkdirs(); // 如果父目录不存在，则创建所有必需的父目录
        else
            zResult = file.mkdir(); // 如果父目录不存在，不做处理
        if (!zResult)
            zResult = file.exists();
        return zResult;
    }

    /**
     * 从文件的完整路径名（路径+文件名）中提取 路径（包括：Drive+Directroy )
     *
     * @param _sFilePathName
     * @return
     */
    public static String extractFilePath(String _sFilePathName) {
        int nPos = _sFilePathName.lastIndexOf('/');
        if (nPos < 0) {
            nPos = _sFilePathName.lastIndexOf('\\');
        }

        return (nPos >= 0 ? _sFilePathName.substring(0, nPos + 1) : "");
    }

    /**
     * 从文件的完整路径名（路径+文件名）中提取文件名(包含扩展名) <br>
     * 如：d:\path\file.ext --> file.ext
     *
     * @param _sFilePathName
     * @return
     */
    public static String extractFileName(String _sFilePathName) {
        return extractFileName(_sFilePathName, File.separator);
    }

    /**
     * 从文件的完整路径名（路径+文件名）中提取文件名(包含扩展名) <br>
     * 如：d:\path\file.ext --> file.ext
     *
     * @param _sFilePathName  全文件路径名
     * @param _sFileSeparator 文件分隔符
     * @return
     */
    public static String extractFileName(String _sFilePathName,
                                         String _sFileSeparator) {
        int nPos = -1;
        if (_sFileSeparator == null) {
            nPos = _sFilePathName.lastIndexOf(File.separatorChar);
            if (nPos < 0) {
                nPos = _sFilePathName
                        .lastIndexOf(File.separatorChar == '/' ? '\\' : '/');
            }
        } else {
            nPos = _sFilePathName.lastIndexOf(_sFileSeparator);
        }

        if (nPos < 0) {
            return _sFilePathName;
        }

        return _sFilePathName.substring(nPos + 1);
    }

    /**
     * 从文件的完整路径名（路径+文件名）中提取文件格式 <br>
     * 如：d:\path\file.ext --> ext
     *
     * @param _sFilePathName
     * @return
     */
    public static String extractFileForamt(String _sFilePathName) {
        return _sFilePathName.substring(_sFilePathName.lastIndexOf(".") + 1);
    }

    /**
     * 检查指定文件的路径是否存在
     *
     * @param _sPathFileName 文件名称(含路径）
     * @return 若存在，则返回true；否则，返回false
     */
    public static boolean pathExists(String _sPathFileName) {
        String sPath = extractFilePath(_sPathFileName);
        return fileExists(sPath);
    }

    public static boolean fileExists(String _sPathFileName) {
        File file = new File(_sPathFileName);
        return file.exists();
    }

    /**
     * 删除文件
     * @param path
     */
    public static void deleteFile(String path) {
        File file = new File(path);
        if (file.exists()) { // 判断文件是否存在
            if (file.isFile()) { // 判断是否是文件
                file.delete(); // delete()方法 你应该知道 是删除的意思;
            }
//            else if (file.isDirectory()) { // 否则如果它是一个目录
//                File files[] = file.listFiles(); // 声明目录下所有的文件 files[];
//                for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
//                    this.deleteFile(files[i]); // 把每个文件 用这个方法进行迭代
//                }
//            }
            file.delete();
        } else {
            LogUtil.d(TAG, "文件不存在！" + "\n");
        }
    }

}
