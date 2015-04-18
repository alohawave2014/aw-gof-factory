package aw.designpetterns.analyzer.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import aw.designpetterns.analyzer.writer.base.RssWriterObject;

public class RssFileWriter extends RssWriterObject{

    @Override
    public void write() {
        writeToFile(this.fileName);        
    }

    /**
     * @param fileName
     */
    public void writeToFile(String fileName){
        try{
            File file = new File(fileName);

            if ((!file.exists()) || ((file.isFile() && file.canWrite()))) {
              // 追記する
              FileWriter filewriter = new FileWriter(file, true);

              filewriter.write(rssContents);
              filewriter.close();
            }else{
              System.err.println("[Error]ファイルに書き込めません");
            }
          }catch(IOException e){
              e.printStackTrace();
              System.err.println("[Error]ファイルに書き込めに失敗しました");
          }
    }
}
