package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * @Classname upload
 * @Description TODO
 * @Date 2020/11/1 12:38
 * @Created by Administrator
 */
public class upload extends ActionSupport {
    private File myFile;
    private String myFileContentType;
    private String myFileFileName;
    private String destPath;

    @Override
    public String execute() throws Exception {
        destPath="D:/code/";
        try {
            System.out.println("Src File name:"+myFile);
            System.out.println("Dst File name:"+myFileFileName);
            File destFile=new File(destPath,myFileFileName);
            FileUtils.copyFile(myFile,destFile);
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    public File getMyFile() {
        return myFile;
    }

    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }

    public String getMyFileContentType() {
        return myFileContentType;
    }

    public void setMyFileContentType(String myFileContentType) {
        this.myFileContentType = myFileContentType;
    }

    public String getMyFileFileName() {
        return myFileFileName;
    }

    public void setMyFileFileName(String myFileFileName) {
        this.myFileFileName = myFileFileName;
    }

    public String getDestPath() {
        return destPath;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }
}
