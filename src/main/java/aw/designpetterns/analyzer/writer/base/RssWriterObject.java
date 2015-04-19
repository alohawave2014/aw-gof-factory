package aw.designpetterns.analyzer.writer.base;

/**
 * Factoryパターンによるwriter実装
 */
public abstract class RssWriterObject {

    /**
     * 出力結果文字列 
     */
    protected String rssContents;
    
    /**
     * 出力ファイル名称
     */
    protected String fileName;
        
    /**
     * 出力結果の書出処理
     */
    public abstract void write();
    
    public void setRssContents(String rssContents){
        this.rssContents = rssContents;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
