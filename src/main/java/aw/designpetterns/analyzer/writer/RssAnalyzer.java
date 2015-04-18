package aw.designpetterns.analyzer.writer;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import aw.designpetterns.analyzer.ReplaceHelper;
import aw.designpetterns.analyzer.writer.base.RssWriterObject;

/**
 * RSS feed 解析クラス
 */
public class RssAnalyzer {

    /**
     * @see RssWriterObjectFactory
     */
    private final int outType;
    
    /**
     * | で区切られた複数のURL
     */
    private final String urls;
    
    /**
     * 変換元文字列 (NewsPicksに該当)
     */
    private final String src;
    
    /**
     * 変換先文字列 (""に該当)
     */
    private final String dst;
    
    /**
     * 出力ファイル名称
     */
    private final String fileName;
    
    /**
     * コンストラクタ
     * @param Urls
     * @param src
     * @param dst
     * @param fileName
     */
    public RssAnalyzer(int outType, String Urls, String src, String dst, String fileName){
        this.outType = outType;
        this.urls = Urls;
        this.src = src;
        this.dst = dst;
        this.fileName = fileName;
    }
    
    /**
     * 指定したURLのHTMLを文字列で返す
     * @param url
     * @return
     */
    private String parse(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            return doc.html();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("[Error]RSSの取得に失敗しました。");// 多言語対応するの絵あれば、ErrorCodeを返す            
        }
        return "";
    }

    
    /**
     * 解析処理。<br>
     * 具体的には、「NewsPicks」という文字を取り除く <br>
     */
    public void execute(){
        
        // | で区切られた複数URLをリスト化
        String[] urlList = this.urls.split("\\|", 0);
        
        // 各URL毎に処理
        for (int i = 0; i < urlList.length; i++) {
            String url = urlList[i].trim();
            
            // rss feed -> String
            String rssContents = this.parse(url);
            if ("".equals(rssContents)) return ;
       
            // この部分を変換以外に汎用化するのであれば、Helperクラスを Interfaceとして定義して、
            // replace some word(src) to other word(dst).
            rssContents = ReplaceHelper.replaceAll(rssContents, src, dst);

            // writer (fileName指定なしの場合は標準出力)
            // 出力ファイルを分割せず、追記する
            RssWriterObject writer = RssWriterObjectFactory.create(this.outType);
            if(writer == null) return ;
            writer.setRssContents(rssContents);
            writer.setFileName(fileName);
            writer.write();
        }        
    }
}
