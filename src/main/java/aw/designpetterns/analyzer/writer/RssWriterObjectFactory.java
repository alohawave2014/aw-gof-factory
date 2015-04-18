package aw.designpetterns.analyzer.writer;

import aw.designpetterns.analyzer.writer.base.RssWriterObject;

/**
 * Abstract Factoryパターンによるwriter実装
 */
public class RssWriterObjectFactory {

    public static final int SYSTEM_OUT= 1;
    public static final int FILE_OUT= 2;

    public static RssWriterObject create(int type){
        RssWriterObject result = null;
        
        if (type == SYSTEM_OUT){
            result = new RssSimpleWriter();
        } else if (type == FILE_OUT) {
            result = new RssFileWriter();
        } else {
            System.err.println("[Error]第1引数が不正(1:標準出力 2:テキストファイル出力");
        }
        return result ;
    }

}
