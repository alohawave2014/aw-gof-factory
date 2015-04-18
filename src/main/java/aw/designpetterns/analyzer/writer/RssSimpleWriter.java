package aw.designpetterns.analyzer.writer;

import aw.designpetterns.analyzer.writer.base.RssWriterObject;

/**
 * Writerクラス<br>
 *  1) 標準出力 (対応)<br>
 *  2) テキスト出力 (対応)
 */
public class RssSimpleWriter extends RssWriterObject {

    @Override
    public void write() {
        System.out.println(rssContents);        
    }
}
