package java_basic;

import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 * @author 李杰
 * @version 1.0
 * @Description 附件和正文vo
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/20 18:31
 * @title 标题: 附件和正文vo
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class DataexFjVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<DataexFjVO> fileList;
    private File file;
    private String id;
    private String authInfo;
    private String cecfwId;
    private int completed;
    private String fileDir;
    private String fileName;
    private long fileSize;
    private String fileSuffix;
    private String md5;
    private String newFileName;
    private String uploadTime;
    private String uploader;
    private String uploaderId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<DataexFjVO> getFileList() {
        return fileList;
    }

    public void setFileList(List<DataexFjVO> fileList) {
        this.fileList = fileList;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }

    public String getCecfwId() {
        return cecfwId;
    }

    public void setCecfwId(String cecfwId) {
        this.cecfwId = cecfwId;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(String uploaderId) {
        this.uploaderId = uploaderId;
    }
}
