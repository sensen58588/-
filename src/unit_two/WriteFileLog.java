package unit_two;


import java.io.*;
import java.util.Random;

/**
 * @Description:
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/9/22.
 */

class FileLog implements Serializable{
    private String userName;
    private String ipHost;

    FileLog(String name,String ipHost){
        this.ipHost = ipHost;
        this.userName = name;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getIpHost() {
        return ipHost;
    }

    public void setIpHost(String ipHost) {
        this.ipHost = ipHost;
    }
}


public class WriteFileLog {

    //生成随机字符串
    public static String makeUserName(int length){
        StringBuffer stringBuffer = new StringBuffer();

        Random random = new Random();
        for(int i=0;i<length;i++){
            int key = random.nextInt(3);
            long result=0;
            switch (key){
                case 0:
                    result = Math.round (random.nextInt(10));
                    stringBuffer.append(result);
                    break;
                case 1:
                    result = Math.round(Math.random()*25+65);
                    stringBuffer.append(String.valueOf((char)result));
                    break;
                case 2:
                    result = Math.round(Math.random()*25+97);
                    stringBuffer.append(String.valueOf((char)result));
                    break;
            }
        }
        return stringBuffer.toString();
    }

    public static void MakeFile() throws IOException {

        long size = 1024*1024*4;
        long count=0;
        FileWriter fileWriter = new FileWriter("G:/log.txt");
        while(count<size){
            String userName = makeUserName(8);
            String ipHost = "http://"+userName;
            FileLog fileLog = new FileLog(userName,ipHost);
            try{
               // FileOutputStream objectOutputStream = new FileOutputStream(fileOutputStream);
                fileWriter.write("userName:"+userName);
                fileWriter.write(" ");
                fileWriter.write("ipHost:"+ipHost);
                fileWriter.write("\r\n");
                System.out.println(ipHost);
            }catch (Exception e){
                e.printStackTrace();
            }

            count++;
        }
        fileWriter.close();
    }

    public static void main(String args[]) throws Exception{
        MakeFile();
    }

}
