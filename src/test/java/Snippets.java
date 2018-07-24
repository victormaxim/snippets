import com.jcraft.jsch.*;
import com.jcraft.jsch.*;
import org.junit.Ignore;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Snippets {
    private By popUpOk = By.xpath("//table//button[text()='OK']");

    @Test
    @Ignore
    public void clickWithActions() throws JSchException {
//        WebElement isPopUp = waitForElement(this.popUpOk);
//                WebElement secondPopUp = waitForElement(this.popUpOk);
//                Actions actions = new Actions(driver);
//                if (isPopUp  != null && isPopUp.isDisplayed()) {
//                        actions.moveToElement(isPopUp).click().perform();
//                    }
//                Thread.sleep(500);
//                if (secondPopUp  != null && isPopUp.isDisplayed()) {
//                        actions.moveToElement(secondPopUp).click().perform();

    }

        public static void main(String[] args) {

        System.out.println("x");
    }

//    @Test
//    public void SSH() throws JSchException{
//
//
//                String user = "ec2-user";
//                String password = "";
//                String host = "fat8-node.digi-leap.com";
//                int port = 22;
//        String privateKey = "~/.ssh/dev-jenkins.key";
//
//                String remoteFile = "/home";
//
//                try {
//                    JSch jsch = new JSch();
//                    jsch.addIdentity(privateKey);
//                    System.out.println("identity added ");
//
//                    Session session = jsch.getSession(user, host, port);
//                    session.setPassword(password);
//                    session.setConfig("StrictHostKeyChecking", "no");
//                    System.out.println("Establishing Connection...");
//                    session.connect();
//                    System.out.println("Connection established.");
//                    System.out.println("Crating SFTP Channel.");
//                    ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
//                    sftpChannel.connect();
//                    System.out.println("SFTP Channel created.");
//
//                    sftpChannel.cd(remoteFile);
//                    Vector filelist = sftpChannel.ls(remoteFile);
//                    for(int i=0; i<filelist.size();i++){
//                        System.out.println(filelist.get(i).toString());
//                    }
//
//
//                    InputStream inputStream = sftpChannel.get(remoteFile);
//                    System.out.println("Working Directory = " + System.getProperty("user.dir"));
//                    try (Scanner scanner = new Scanner(new InputStreamReader(inputStream))) {
//                        while (scanner.hasNextLine()) {
//                            String line = scanner.nextLine();
//                            System.out.println(line);
//                        }
//                    }
//                } catch (SftpException e) {
//                    e.printStackTrace();
//                }
//            }


    @Test
    public void SSH_B() throws JSchException{


        String user = "ec2-user";
        String password = "";
        String host = "fat8-node.digi-leap.com";
        int port = 22;
        String privateKey = "~/.ssh/dev-jenkins.key";

        String remoteFile = "/opt/sap/hybris/log/tomcat";

        try {
            JSch jsch = new JSch();
            jsch.addIdentity(privateKey);
            System.out.println("identity added ");

            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            System.out.println("Establishing Connection...");
            session.connect();
            System.out.println("Connection established.");
            System.out.println("Crating SFTP Channel.");
            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();
            System.out.println("SFTP Channel created.");

            sftpChannel.cd(remoteFile);
            Vector filelist = sftpChannel.ls(remoteFile);
            for(int i=0; i<filelist.size();i++){
                System.out.println(filelist.get(i).toString());
            }


            InputStream inputStream = sftpChannel.get(remoteFile + "/console-20180706.log");
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
            try (Scanner scanner = new Scanner(new InputStreamReader(inputStream))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            }
        } catch (SftpException e) {
            e.printStackTrace();
        }
    }


}




