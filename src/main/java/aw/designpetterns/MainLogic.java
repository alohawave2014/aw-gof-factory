package aw.designpetterns;

import aw.designpetterns.analyzer.writer.RssAnalyzer;

/**
 * Abstract factrory patternサンプル
 * [仕様]
 * 第1引数: 【必須】出力形式 (1: 標準出力、 2: ファイル出力) 
 * 第2引数: 【必須】URL (|　で区切ることにより複数指定可能。 eg.  www.hoge.com | www.foge.com | ...)
 * 第3引数: 【必須】変換元文字列
 * 第4引数: 【必須】変換後文字列 (ブランクへの変換は、'null'を指定)
 * 第5引数: 【任意】(絶対パス指定による)出力ファイル名(指定なしの場合は、標準出力。指定ありの場合は、ファイル出力。)
 */
public class MainLogic {

    private static int outType ;
    private static String urls, src, dst, fileName;

    
    public static void main(String[] args){
        int result = 0;
        
        // 各種パラメーターセット
        if (!setParameters(args)) return;            
                
        // rss 解析実行
        //TODO 検討余地あり
        RssAnalyzer rssAnalyzer = new RssAnalyzer(outType, urls, src, dst, fileName);
        rssAnalyzer.execute();
        
        //TODO 厳密に正常終了の判定してない
        System.exit(result);
    };
    
    private static boolean setParameters(String[] args){        
        try {
            // initialize (引数1,2,3は必須)
            if (args.length < 4){
                System.err.print("[Error]引数の数が不正です");// 多言語対応するの絵あれば、ErrorCodeを返す
                return false;
            }
            
            outType = Integer.parseInt(args[0]);
            urls = args[1];
            src = args[2];
            dst = ("null".equals(args[3])) ? "": args[3];
            fileName = (args.length >= 5) ? args[4]: "";
            
        } catch (Exception e) {
            System.err.print("[Error]引数が不正です");
            return false;
        }
        return true;
    }
}
